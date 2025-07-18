package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.LoginView;
import ec.edu.ups.vista.RecuperarContraseniaView;
import ec.edu.ups.vista.UsuarioAdminView;
import ec.edu.ups.vista.UsuarioRegistroView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class UsuarioController {

    private Usuario usuarioAutenticado;
    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private final LoginView loginView;
    private final UsuarioRegistroView usuarioRegistroView;
    private final UsuarioAdminView usuarioAdminView;
    private final RecuperarContraseniaView recuperarContraseniaView;


    public UsuarioController(UsuarioDAO usuarioDAO, LoginView loginView, UsuarioRegistroView usuarioRegistroView, UsuarioAdminView usuarioAdminView, RecuperarContraseniaView recuperarContraseniaView) {
        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
        this.usuarioRegistroView = usuarioRegistroView;
        this.usuarioAdminView = usuarioAdminView;
        this.usuario = null;
        this.recuperarContraseniaView = recuperarContraseniaView;

        configurarEventosEnVistas();
    }

    private void configurarEventosEnVistas(){
        loginView.getBtnIniciarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticar();
            }
        });
        loginView.getBtnRegistrarse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ffff");
                mostrarRegistro();
            }
        });
        usuarioRegistroView.getBtnRegistrarse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }
    private void registrarUsuario() {
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

        String[] campos = {
                nombreCompleto, fechaNacimientoTexto, correo, telefono, username,
                contrasenia, respuesta1, respuesta2, respuesta3
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
            usuarioRegistroView.mostrarMensaje("Selecciona un rol.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(
                username,
                contrasenia,
                (Rol) rolObj,
                nombreCompleto,
                fechaNacimiento, // ahora sí es LocalDate
                correo,
                telefono,
                new String[]{respuesta1, respuesta2, respuesta3}
        );
        usuarioDAO.crear(nuevoUsuario);

        usuarioRegistroView.mostrarMensaje("Usuario registrado correctamente.");
        usuarioRegistroView.setVisible(false);

    }
    private void mostrarRegistro() {
        usuarioRegistroView.setVisible(true);
    }
    private void autenticar(){
        String username = loginView.getTxtUsername().getText();
        String contrasenia = loginView.getTxtContrasenia().getText();

        usuario = usuarioDAO.autenticar(username, contrasenia);
        if(usuario == null){
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        }else{
            loginView.dispose();
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
        } //else {
            //usuarioAdminView.mostrarMensaje("Seleccione un usuario para editar.");
       // }
    }
    private void eliminarUsuario() {
        String username = usuarioAdminView.getTxtUsuario().getText();
        usuarioDAO.eliminar(username);

        //usuarioAdminView.mostrarMensaje("usuario.admin.eliminado");
        buscarUsuarios();
    }

    public Usuario getUsuarioAutenticado(){
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
                //usuarioAdminView.mostrarMensaje("usuario.admin.no.encontrado");
                usuarioAdminView.cargarDatos(usuarioDAO.listarTodos());
            }
        } else {
            usuarioAdminView.cargarDatos(usuarioDAO.listarTodos());
        }

    }



}