package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.UsuarioRegistroView;

import javax.swing.*;

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
        String fechaNacimiento = vista.getTxtFechaNacimiento().getText();
        String correo = vista.getTxtCorreoElectronico().getText();
        String telefono = vista.getTxtTelefono().getText();

        String pregunta1 = (String) vista.getCbxPregunta1().getSelectedItem();
        String respuesta1 = vista.getTxtRespuesta1().getText();
        String pregunta2 = (String) vista.getCbxPregunta2().getSelectedItem();
        String respuesta2 = vista.getTxtRespuesta2().getText();
        String pregunta3 = (String) vista.getCbxPregunta3().getSelectedItem();
        String respuesta3 = vista.getTxtRespuesta3().getText();

        String nombreCompleto = vista.getTxtNombreCompleto().getText();
        // ...otros campos...
        // Usuario usuario = new Usuario(...);
        // usuarioDAO.crear(usuario);
        JOptionPane.showMessageDialog(vista, "Usuario registrado correctamente");
        vista.dispose();
    }
}
