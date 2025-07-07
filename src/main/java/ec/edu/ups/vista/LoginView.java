package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton btnRecuperar;
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
        btnRecuperar.setText(mensajeHandler.getMensaje("login.recuperar"));
        lblMensaje.setText(mensajeHandler.getMensaje("login.lblmensaje"));

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

    public boolean isComboInicializado() {
        return comboInicializado;
    }

    public void setComboInicializado(boolean comboInicializado) {
        this.comboInicializado = comboInicializado;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelSecundario() {
        return panelSecundario;
    }

    public void setPanelSecundario(JPanel panelSecundario) {
        this.panelSecundario = panelSecundario;
    }

    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    public void setLblUsuario(JLabel lblUsuario) {
        this.lblUsuario = lblUsuario;
    }

    public JLabel getLblContrasenia() {
        return lblContrasenia;
    }

    public void setLblContrasenia(JLabel lblContrasenia) {
        this.lblContrasenia = lblContrasenia;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public JPasswordField getTxtContrasenia() {
        return txtContrasenia;
    }

    public void setTxtContrasenia(JPasswordField txtContrasenia) {
        this.txtContrasenia = txtContrasenia;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(JButton btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public void setBtnRegistrarse(JButton btnRegistrarse) {
        this.btnRegistrarse = btnRegistrarse;
    }

    public JButton getBtnRecuperar() {
        return btnRecuperar;
    }

    public void setBtnRecuperar(JButton btnRecuperar) {
        this.btnRecuperar = btnRecuperar;
    }

    public JLabel getLblMensaje() {
        return lblMensaje;
    }

    public void setLblMensaje(JLabel lblMensaje) {
        this.lblMensaje = lblMensaje;
    }

    public JButton getBtnCambiarIdioma() {
        return btnCambiarIdioma;
    }

    public void setBtnCambiarIdioma(JButton btnCambiarIdioma) {
        this.btnCambiarIdioma = btnCambiarIdioma;
    }

    public JComboBox<String> getComboBoxIdioma() {
        return comboBoxIdioma;
    }

    public void setComboBoxIdioma(JComboBox<String> comboBoxIdioma) {
        this.comboBoxIdioma = comboBoxIdioma;
    }

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

}


