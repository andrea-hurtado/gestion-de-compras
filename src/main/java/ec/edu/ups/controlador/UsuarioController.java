package ec.edu.ups.controlador;

import ec.edu.ups.dao.PreguntasSeguridadDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.PreguntasSeguridad;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.CedulaValida;
import ec.edu.ups.vista.LoginView;
import ec.edu.ups.vista.RecuperarContraseniaView;
import ec.edu.ups.vista.UsuarioAdminView;
import ec.edu.ups.vista.UsuarioRegistroView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UsuarioController {

    private Usuario usuarioAutenticado;
    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private final LoginView loginView;
    private final UsuarioRegistroView usuarioRegistroView;
    private final UsuarioAdminView usuarioAdminView;
    private final RecuperarContraseniaView recuperarContraseniaView;
    private final PreguntasSeguridadDAO preguntasSeguridadDAO;

    private List<PreguntasSeguridad> preguntasDelUsuario;
    private PreguntasSeguridad preguntaSeleccionada;
    private Usuario usuarioRecuperacion;


    public UsuarioController(
            UsuarioDAO usuarioDAO,
            LoginView loginView,
            UsuarioRegistroView usuarioRegistroView,
            UsuarioAdminView usuarioAdminView,
            RecuperarContraseniaView recuperarContraseniaView,
            PreguntasSeguridadDAO preguntasSeguridadDAO) {

        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
        this.usuarioRegistroView = usuarioRegistroView;
        this.usuarioAdminView = usuarioAdminView;
        this.usuario = null;
        this.recuperarContraseniaView = recuperarContraseniaView;
        this.preguntasSeguridadDAO = preguntasSeguridadDAO;

        configurarEventosEnVistas();
    }

    private void configurarEventosEnVistas() {
        loginView.getBtnIniciarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticar();
            }
        });
        loginView.getBtnRecuperar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { mostrarRecuperarContrasenia();
            }

        });
/*
        if (recuperarContraseniaView.getBtnAceptar() != null) {
            recuperarContraseniaView.getBtnAceptar().addActionListener(e -> verificarUsuarioParaRecuperar());
        }
        if (recuperarContraseniaView.getVerificarButton() != null) {
            recuperarContraseniaView.getVerificarButton().addActionListener(e -> verificarRespuesta());
        }
        if (recuperarContraseniaView.getBtnGuardar() != null) {
            recuperarContraseniaView.getBtnGuardar().addActionListener(e -> guardarNuevaContrasenia());
        }
        if (recuperarContraseniaView.getBtnCancelar() != null) {
            recuperarContraseniaView.getBtnCancelar().addActionListener(e -> recuperarContraseniaView.setVisible(false));
        }
*/
        loginView.getBtnRegistrarse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistro();
            }
        });
        usuarioRegistroView.getBtnRegistrarse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
        if (usuarioAdminView.getBtnBuscar() != null) {
            usuarioAdminView.getBtnBuscar().addActionListener(e -> buscarUsuarios());
        }
        if (usuarioAdminView.getBtnEditar() != null) {
            usuarioAdminView.getBtnEditar().addActionListener(e -> editarUsuario());
        }
        if (usuarioAdminView.getBtnEliminar() != null) {
            usuarioAdminView.getBtnEliminar().addActionListener(e -> eliminarUsuario());
        }
        if (usuarioAdminView.getBtnListar() != null) {
            usuarioAdminView.getBtnListar().addActionListener(e -> buscarUsuarios());
        }

    }

    private void verificarUsuarioParaRecuperar() {
        String username = recuperarContraseniaView.getTxtIUsuario().getText().trim();
        if (username.isEmpty()) {
            recuperarContraseniaView.mostrarMensaje("Ingrese un nombre de usuario.");
            return;
        }

        usuarioRecuperacion = usuarioDAO.buscarPorUsername(username);
        if (usuarioRecuperacion == null) {
            recuperarContraseniaView.mostrarMensaje("Usuario no encontrado.");
            return;
        }
        preguntasDelUsuario = preguntasSeguridadDAO.obtenerPreguntasPorUsuario(username);
        if (preguntasDelUsuario == null || preguntasDelUsuario.isEmpty()) {
            recuperarContraseniaView.mostrarMensaje("No existen preguntas de seguridad registradas.");
            return;
        }

        int randomIndex = (int) (Math.random() * preguntasDelUsuario.size());
        preguntaSeleccionada = preguntasDelUsuario.get(randomIndex);

        recuperarContraseniaView.getLblPreguntaSeguridad().setText(preguntaSeleccionada.getPregunta());
        recuperarContraseniaView.mostrarSoloPanelPregunta();
    }

    private void verificarRespuesta() {
        String respuestaIngresada = recuperarContraseniaView.getTxtRespuestaSeguridad().getText().trim();
        if (preguntaSeleccionada == null) {
            recuperarContraseniaView.mostrarMensaje("Debe ingresar primero el usuario.");
            return;
        }
        if (respuestaIngresada.isEmpty()) {
            recuperarContraseniaView.mostrarMensaje("Ingrese su respuesta a la pregunta de seguridad.");
            return;
        }
        if (preguntaSeleccionada.getRespuesta().equalsIgnoreCase(respuestaIngresada)) {
            recuperarContraseniaView.mostrarMensaje("Respuesta correcta. Ahora puede establecer una nueva contraseña.");
            recuperarContraseniaView.mostrarPanelRestablecerContrasenia();
        } else {
            recuperarContraseniaView.mostrarMensaje("Respuesta incorrecta. Intente de nuevo.");
        }
    }

    private void guardarNuevaContrasenia() {
        String nuevaContrasenia = recuperarContraseniaView.getTxtNuevaContrasenia().getText().trim();
        if (usuarioRecuperacion == null) {
            recuperarContraseniaView.mostrarMensaje("Debe ingresar primero el usuario.");
            return;
        }
        if (nuevaContrasenia.isEmpty()) {
            recuperarContraseniaView.mostrarMensaje("Ingrese la nueva contraseña.");
            return;
        }
        usuarioRecuperacion.setContrasenia(nuevaContrasenia);
        usuarioDAO.actualizar(usuarioRecuperacion);
        recuperarContraseniaView.mostrarMensaje("Contraseña actualizada correctamente.");
        recuperarContraseniaView.limpiarCampos();
        recuperarContraseniaView.setVisible(false);
    }

    private void registrarUsuario() {
        try {
            String nombreCompleto = usuarioRegistroView.getTxtNombreCompleto().getText().trim();
            String fechaNacimientoTexto = usuarioRegistroView.getTxtFechaNacimiento().getText().trim();
            String correo = usuarioRegistroView.getTxtCorreoElectronico().getText().trim();
            String telefono = usuarioRegistroView.getTxtTelefono().getText().trim();
            String username = usuarioRegistroView.getTxtIngreseUsuario().getText().trim();
            String contrasenia = usuarioRegistroView.getTxtIngreseContrasenia().getText().trim();
            Object rolObj = usuarioRegistroView.getCbxRol().getSelectedItem();
            String respuesta1 = usuarioRegistroView.getTxtRespuestaSeguridad1().getText().trim();
            String respuesta2 = usuarioRegistroView.getTxtRespuestSeguridad2().getText().trim();
            String respuesta3 = usuarioRegistroView.getTxtRespuestaSeguridad3().getText().trim();
            String cedula = usuarioRegistroView.getTxtCedula().getText().trim();

            if (!CedulaValida.validarCedulaEcuatoriana(cedula)) {
                usuarioRegistroView.mostrarMensaje("La cédula que ingresó no es válida.");
                return;
            }

            String[] campos = {
                    nombreCompleto, fechaNacimientoTexto, correo, telefono, username,
                    contrasenia, respuesta1, respuesta2, respuesta3, cedula
            };
            for (String campo : campos) {
                if (campo.isEmpty()) {
                    usuarioRegistroView.mostrarMensaje("Todos los campos son obligatorios.");
                    return;
                }
            }

            if (!fechaNacimientoTexto.matches("\\d{4}-\\d{2}-\\d{2}")) {
                usuarioRegistroView.mostrarMensaje("La fecha debe tener el formato AAAA-MM-DD.");
                return;
            }
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoTexto);

            if (rolObj == null) {
                usuarioRegistroView.mostrarMensaje("Seleccione un rol.");
                return;
            }
            List<PreguntasSeguridad> preguntasRespondidas = Arrays.asList(
                    new PreguntasSeguridad("¿Cuál es el primer nombre de su padre?", respuesta1),
                    new PreguntasSeguridad("¿Cuál es su comida favorita?", respuesta2),
                    new PreguntasSeguridad("¿Cuál es su película o serie favorita?", respuesta3)
            );
            preguntasSeguridadDAO.guardarPreguntasPorUsuario(username, preguntasRespondidas);

            Usuario nuevoUsuario = new Usuario(
                    username,
                    contrasenia,
                    (Rol) rolObj,
                    nombreCompleto,
                    fechaNacimiento,
                    correo,
                    telefono,
                    cedula,
                    new String[]{respuesta1, respuesta2, respuesta3}
            );
            usuarioDAO.crear(nuevoUsuario);

            usuarioRegistroView.mostrarMensaje("Usuario registrado correctamente.");
            usuarioRegistroView.setVisible(false);
        } catch (Exception ex) {
            usuarioRegistroView.mostrarMensaje("Error en el registro: " + ex.getMessage());
        }

    }

    private void mostrarRegistro() {
        usuarioRegistroView.setVisible(true);
        usuarioRegistroView.setLocationRelativeTo(loginView);
    }

    private void autenticar() {
        String username = loginView.getTxtUsername().getText();
        String contrasenia = loginView.getTxtContrasenia().getText();

        usuario = usuarioDAO.autenticar(username, contrasenia);
        if (usuario == null) {
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        } else {
            loginView.dispose();
            usuarioAutenticado = usuario;
        }
    }

    private void editarUsuario() {
        int fila = usuarioAdminView.getTblUsuarios().getSelectedRow();
        if (fila >= 0) {
            String username = usuarioAdminView.getTblUsuarios().getValueAt(fila, 0).toString();
            Usuario usuario = usuarioDAO.buscarPorUsername(username);
            usuarioAdminView.getTxtUsuario().setText(usuario.getUsername());
            usuarioAdminView.getTxtCorreoElectronico().setText(usuario.getContrasenia());
            usuarioAdminView.getCbxRol().setSelectedItem(usuario.getRol());
        }
    }

    private void eliminarUsuario() {
        String username = usuarioAdminView.getTxtUsuario().getText();
        usuarioDAO.eliminar(username);
        buscarUsuarios();
    }

    private void mostrarRecuperarContrasenia() {
        recuperarContraseniaView.setVisible(true);
        usuarioRegistroView.setLocationRelativeTo(loginView);

        //debe mosgtrar el panel principal
        recuperarContraseniaView.limpiarCampos();
        recuperarContraseniaView.mostrarSoloPanelUsuario();
    }


    public Usuario getUsuarioAutenticado() {
        return usuario;
    }

    public void setUsuarioAutenticado(Usuario usuario) {
        this.usuarioAutenticado = usuario;
    }

    public void buscarUsuarios() {
        String username = usuarioAdminView.getTxtUsuario().getText();
        if (username != null && !username.trim().isEmpty()) {
            Usuario usuario = usuarioDAO.buscarPorUsername(username);
            if (usuario != null) {
                usuarioAdminView.cargarDatos(List.of(usuario));
            } else {
                usuarioAdminView.cargarDatos(usuarioDAO.listarTodos());
            }
        } else {
            usuarioAdminView.cargarDatos(usuarioDAO.listarTodos());
        }
    }
}