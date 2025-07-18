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
    private MensajeInternacionalizacionHandler mensajeHandler;
;

    public RecuperarContraseniaView(MensajeInternacionalizacionHandler mensajeHandler){
        this.mensajeHandler = mensajeHandler;
        setContentPane(panelPrincipal);
        setTitle("Registro de Usuario");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        actualizarTextos();
    }
    public void actualizarTextos() {
        setTitle(mensajeHandler.get("recuperar.titulo"));

        if (lblRecuperarContrasenia != null) lblRecuperarContrasenia.setText(mensajeHandler.get("recuperar.titulo"));
        if (lblIngreseUsuario != null) lblIngreseUsuario.setText(mensajeHandler.get("recuperar.lbl.ingrese.usuario"));
        if (lblUsuario != null) lblUsuario.setText(mensajeHandler.get("recuperar.lbl.usuario"));
        if (lblRespondaPregunta != null) lblRespondaPregunta.setText(mensajeHandler.get("recuperar.lbl.responda.pregunta"));
        if (lblRestablecerContrasenia != null) lblRestablecerContrasenia.setText(mensajeHandler.get("recuperar.lbl.restablecer.contrasenia"));
        if (btnVerificar != null) btnVerificar.setText(mensajeHandler.get("recuperar.btn.verificar.usuario"));
        if (btnAceptar != null) btnAceptar.setText(mensajeHandler.get("recuperar.btn.aceptar"));
        if (btnGuardar != null) btnGuardar.setText(mensajeHandler.get("recuperar.btn.guardar"));
        if (btnCancelar != null) btnCancelar.setText(mensajeHandler.get("recuperar.btn.cancelar"));
    }
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public void limpiarCampos() {
        txtIUsuario.setText("");
        txtResponderPregunta.setText("");
        txtRestablecerContrasenia.setText("");
    }
    public void mostrarSoloPanelUsuario() {
        txtIUsuario.setEnabled(true);
        btnAceptar.setEnabled(true);
        txtResponderPregunta.setEnabled(false);
        btnVerificar.setEnabled(false);
        txtRestablecerContrasenia.setEnabled(false);
        btnGuardar.setEnabled(false);
    }

    public void mostrarSoloPanelPregunta() {
        txtIUsuario.setEnabled(false);
        btnAceptar.setEnabled(false);
        txtResponderPregunta.setEnabled(true);
        btnVerificar.setEnabled(true);
        txtRestablecerContrasenia.setEnabled(false);
        btnGuardar.setEnabled(false);
    }

    public void mostrarPanelRestablecerContrasenia() {
        txtIUsuario.setEnabled(false);
        btnAceptar.setEnabled(false);
        txtResponderPregunta.setEnabled(false);
        btnVerificar.setEnabled(false);
        txtRestablecerContrasenia.setEnabled(true);
        btnGuardar.setEnabled(true);
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

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }
}