package ec.edu.ups.controlador;

import ec.edu.ups.dao.PreguntasSeguridadDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.PreguntasSeguridad;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.UsuarioRegistroView;
import java.util.List;
import java.util.Arrays;
import javax.swing.*;
import java.time.LocalDate;


public class UsuarioRegistroController {

    private final UsuarioRegistroView vista;
    private final UsuarioDAO usuarioDAO;
    private final PreguntasSeguridadDAO preguntasSeguridadDAO;

    public UsuarioRegistroController(UsuarioRegistroView vista, UsuarioDAO usuarioDAO,  PreguntasSeguridadDAO preguntasSeguridadDAO) {
        this.vista = vista;
        this.usuarioDAO = usuarioDAO;
        this.preguntasSeguridadDAO = preguntasSeguridadDAO;

        this.vista.getBtnRegistrarse().addActionListener(e -> registrarUsuario());
    }

    private void registrarUsuario() {

        String nombre = vista.getTxtNombreCompleto().getText().trim();
        LocalDate fechaNacimiento = LocalDate.parse(vista.getTxtFechaNacimiento().getText().trim());
        String correo = vista.getTxtCorreoElectronico().getText().trim();
        String telefono = vista.getTxtTelefono().getText().trim();

        String username = vista.getTxtIngreseUsuario().getText().trim();
        String contrasenia = vista.getTxtIngreseContrasenia().getText().trim();
        Rol rol = (Rol) vista.getCbxRol().getSelectedItem();

        String respuesta1 = vista.getTxtRespuestaSeguridad1().getText().trim();
        String respuesta2 = vista.getTxtRespuestSeguridad2().getText().trim();
        String respuesta3 = vista.getTxtRespuestaSeguridad3().getText().trim();

        List<PreguntasSeguridad> preguntasRespondidas = Arrays.asList(
                new PreguntasSeguridad("¿Cuál es el primer nombre de su padre?", respuesta1),
                new PreguntasSeguridad("¿Cuál es su comida favorita?", respuesta2),
                new PreguntasSeguridad("¿Cuál es su película o serie favorita?", respuesta3)
        );
        preguntasSeguridadDAO.guardarPreguntasPorUsuario(username, preguntasRespondidas);

        Usuario nuevoUsuario = new Usuario(
                username, contrasenia, Rol.USUARIO, nombre, fechaNacimiento, correo, telefono,
                new String[]{respuesta1, respuesta2, respuesta3}
        );

        usuarioDAO.crear(nuevoUsuario);

        JOptionPane.showMessageDialog(vista, "Usuario registrado correctamente");
        vista.dispose();
    }

}




