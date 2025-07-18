package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class RecuperarContraseniaView extends JInternalFrame{


    private JPanel panelPrincipal;
    private JButton btnVerificar;
    private JButton btnCancelar;
    private JLabel lblIngreseUsuario;
    private JLabel lblRecuperarContrasenia;
    private JButton btnAceptar;
    private JTextField txtRestablecerContrasenia;
    private JButton btnGuardar;
    private JTextField txtIUsuario;
    private JTextField txtResponderPregunta;
    private JLabel lblRestablecerContrasenia;
    private JLabel lblRespondaPregunta;
    private JLabel lblUsuario;
;

    public RecuperarContraseniaView(MensajeInternacionalizacionHandler handler){
        setContentPane(panelPrincipal);
        setTitle("Registro de Usuario");
        setSize(600, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
    }

    public JPanel getPanel1() {
        return panelPrincipal;
    }

    public void setPanel1(JPanel panel1) {
        this.panelPrincipal = panel1;
    }

    public JButton getBtnVerificar() {
        return btnVerificar;
    }

    public void setBtnVerificar(JButton btnVerificar) {
        this.btnVerificar = btnVerificar;
    }

    public JLabel getLblIngreseUsuario() {
        return lblIngreseUsuario;
    }

    public void setLblIngreseUsuario(JLabel lblIngreseUsuario) {
        this.lblIngreseUsuario = lblIngreseUsuario;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JLabel getLblRecuperarContrasenia() {
        return lblRecuperarContrasenia;
    }

    public void setLblRecuperarContrasenia(JLabel lblRecuperarContrasenia) {
        this.lblRecuperarContrasenia = lblRecuperarContrasenia;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JTextField getTxtRestablecerContrasenia() {
        return txtRestablecerContrasenia;
    }

    public void setTxtRestablecerContrasenia(JTextField txtRestablecerContrasenia) {
        this.txtRestablecerContrasenia = txtRestablecerContrasenia;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JTextField getTxtIUsuario() {
        return txtIUsuario;
    }

    public void setTxtIUsuario(JTextField txtIUsuario) {
        this.txtIUsuario = txtIUsuario;
    }

    public JTextField getTxtResponderPregunta() {
        return txtResponderPregunta;
    }

    public void setTxtResponderPregunta(JTextField txtResponderPregunta) {
        this.txtResponderPregunta = txtResponderPregunta;
    }

    public JLabel getLblRestablecerContrasenia() {
        return lblRestablecerContrasenia;
    }

    public void setLblRestablecerContrasenia(JLabel lblRestablecerContrasenia) {
        this.lblRestablecerContrasenia = lblRestablecerContrasenia;
    }

    public JLabel getLblRespondaPregunta() {
        return lblRespondaPregunta;
    }

    public void setLblRespondaPregunta(JLabel lblRespondaPregunta) {
        this.lblRespondaPregunta = lblRespondaPregunta;
    }

    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    public void setLblUsuario(JLabel lblUsuario) {
        this.lblUsuario = lblUsuario;
    }
}