package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.UsuarioRegistroView;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UsuarioRegistroController {

    private final UsuarioRegistroView vista;
    private final UsuarioDAO usuarioDAO;

    public UsuarioRegistroController(UsuarioRegistroView vista, UsuarioDAO usuarioDAO) {
        this.vista = vista;
        this.usuarioDAO = usuarioDAO;

        this.vista.getBtnRegistrarse().addActionListener(e -> registrarUsuario());
    }

    private void registrarUsuario() {

            String nombre = vista.getTxtNombreCompleto().getText();
            LocalDate fechaNacimiento = LocalDate.parse(vista.getTxtFechaNacimiento().getText()); // usa un formateador si lo necesitas
            String correo = vista.getTxtCorreoElectronico().getText();
            String telefono = vista.getTxtTelefono().getText();

            // preguntas y respuestas de seguridad por si olvida contraseña
            String pregunta1 = (String) vista.getCbxPregunta1().getSelectedItem();
            String respuesta1 = vista.getTxtRespuesta1().getText();
            String pregunta2 = (String) vista.getCbxPregunta2().getSelectedItem();
            String respuesta2 = vista.getTxtRespuesta2().getText();
            String pregunta3 = (String) vista.getCbxPregunta3().getSelectedItem();
            String respuesta3 = vista.getTxtRespuesta3().getText();


            List<String> preguntas = Arrays.asList(pregunta1, pregunta2, pregunta3);
            List<String> respuestas = Arrays.asList(respuesta1, respuesta2, respuesta3);

            String username = correo;
            String contrasenia = "1234";

        Usuario nuevoUsuario = new Usuario(
                username,
                contrasenia,
                Rol.USUARIO,
                nombre,
                fechaNacimiento,
                correo,
                telefono,
                preguntas,
                respuestas
        );

            usuarioDAO.crear(nuevoUsuario);

            JOptionPane.showMessageDialog(vista,"Usuario registrado correctamente");
            vista.dispose();

        }
}

