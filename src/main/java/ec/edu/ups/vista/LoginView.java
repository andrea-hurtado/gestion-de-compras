package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import javax.swing.*;
import java.net.URL;

public class LoginView extends JFrame {
    private boolean comboInicializado = false;
    private JPanel panelPrincipal;
    private JPanel panelSecundario;
    private JLabel lblUsuario;
    private JLabel lblContrasenia;
    private JTextField txtUsername;
    private JPasswordField txtContrasenia;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;
    private JButton recuperarButton;
    private JLabel lblMensaje;
    private JComboBox<String> comboBoxIdioma;
    private JButton btnCambiarIdioma;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public LoginView(MensajeInternacionalizacionHandler handler) {
        this.mensajeHandler = handler;
        setContentPane(panelPrincipal);
        setTitle(mensajeHandler.getMensaje("ventana.titulo"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        configurarComboBoxIdioma();
        comboBoxIdioma.addActionListener(e -> {
            if (comboInicializado) {
                cambiarIdiomaDesdeCombo();
            }
        });
        actualizarTextos();
        cargarIconos();
    }

    private void configurarComboBoxIdioma() {
        comboInicializado = false;

        comboBoxIdioma.removeAllItems();
        comboBoxIdioma.addItem(mensajeHandler.getMensaje("lenguaje.espaniol"));
        comboBoxIdioma.addItem(mensajeHandler.getMensaje("lenguaje.ingles"));
        comboBoxIdioma.addItem(mensajeHandler.getMensaje("lenguaje.frances"));

        // Detectar el idioma ACTUAL y seleccionar la opción correcta
        String lang = mensajeHandler.getLocale().getLanguage();
        if (lang.equals("es")) {
            comboBoxIdioma.setSelectedItem(mensajeHandler.getMensaje("lenguaje.espaniol"));
        } else if (lang.equals("en")) {
            comboBoxIdioma.setSelectedItem(mensajeHandler.getMensaje("lenguaje.ingles"));
        } else if (lang.equals("fr")) {
            comboBoxIdioma.setSelectedItem(mensajeHandler.getMensaje("lenguaje.frances"));
        }

        comboInicializado = true;
    }



    private void cambiarIdiomaDesdeCombo() {
        String selected = (String) comboBoxIdioma.getSelectedItem();
        if (selected == null) {
            return;
        }
        System.out.println("Idioma seleccionado: " + selected);

        if (selected.equals(mensajeHandler.getMensaje("lenguaje.espaniol"))) {
            mensajeHandler.setLenguaje("es", "EC");
        } else if (selected.equals(mensajeHandler.getMensaje("lenguaje.ingles"))) {
            mensajeHandler.setLenguaje("en", "US");
        } else if (selected.equals(mensajeHandler.getMensaje("lenguaje.frances"))) {
            mensajeHandler.setLenguaje("fr", "FR");
        }
        actualizarTextos();
    }

    public void actualizarTextos() {
        setTitle(mensajeHandler.getMensaje("ventana.titulo"));
        lblUsuario.setText(mensajeHandler.getMensaje("login.lblusuario"));
        lblContrasenia.setText(mensajeHandler.getMensaje("login.lblcontrasenia"));
        btnIniciarSesion.setText(mensajeHandler.getMensaje("login.boton"));
        btnRegistrarse.setText(mensajeHandler.getMensaje("login.registrarse"));
        recuperarButton.setText(mensajeHandler.getMensaje("login.recuperar"));
        lblMensaje.setText(mensajeHandler.getMensaje("login.lblmensaje"));

        // Refresca el combo en el idioma correcto
        configurarComboBoxIdioma();
    }

    public void cargarIconos() {
        URL loginURL = LoginView.class.getClassLoader().getResource("imagenes/login.png");
        if (loginURL != null) {
            btnIniciarSesion.setIcon(new ImageIcon(loginURL));
        }
        URL registrarseURL = LoginView.class.getClassLoader().getResource("imagenes/registrarse.png");
        if (registrarseURL != null) {
            btnRegistrarse.setIcon(new ImageIcon(registrarseURL));
        }
    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
    public JPanel getPanelSecundario() {
        return panelSecundario;
    }
    public JTextField getTxtUsername() {
        return txtUsername;
    }
    public JPasswordField getTxtContrasenia() {
        return txtContrasenia;
    }
    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }
    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }
    public JButton getRecuperarButton() {
        return recuperarButton;
    }
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}


