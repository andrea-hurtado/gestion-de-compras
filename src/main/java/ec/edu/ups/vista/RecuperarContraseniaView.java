package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import javax.swing.*;

public class RecuperarContraseniaView extends JInternalFrame{

    private JPanel panelPrincipal;
    private JButton btnCancelar;
    private JLabel lblRecuperarContrasenia;
    private JButton btnAceptar;
    private JButton btnGuardar;
    private JTextField txtIUsuario;
    private JLabel lblRespondaPregunta;
    private JLabel lblUsuario;
    private JTextField txtRespuestaSeguridad;
    private JButton btnVerificar;
    private JPanel panelSecundario;
    private JPanel panelTercero;
    private JTextField txtNuevaContrasenia;
    private JLabel lblNuevaContrasenia;
    private JLabel lblPreguntaSeguridad;
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
        if (lblUsuario != null) lblUsuario.setText(mensajeHandler.get("recuperar.lbl.usuario"));
        if (lblRespondaPregunta != null) lblRespondaPregunta.setText(mensajeHandler.get("recuperar.lbl.responda.pregunta"));
        if (lblPreguntaSeguridad != null) lblPreguntaSeguridad.setText(mensajeHandler.get("recuperar.lbl.pregunta.seguridad"));
        if (lblNuevaContrasenia != null) lblNuevaContrasenia.setText(mensajeHandler.get("recuperar.lbl.nueva.contrasenia"));
        if (btnAceptar != null) btnAceptar.setText(mensajeHandler.get("recuperar.btn.aceptar"));
        if (btnVerificar != null) btnVerificar.setText(mensajeHandler.get("recuperar.btn.verificar.usuario"));
        if (btnGuardar != null) btnGuardar.setText(mensajeHandler.get("recuperar.btn.guardar"));
        if (btnCancelar != null) btnCancelar.setText(mensajeHandler.get("recuperar.btn.cancelar"));
    }
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public void limpiarCampos() {
        if (txtIUsuario != null) txtIUsuario.setText("");
        if (txtRespuestaSeguridad != null) txtRespuestaSeguridad.setText("");
        if (txtNuevaContrasenia != null) txtNuevaContrasenia.setText("");
    }
    public void mostrarSoloPanelUsuario() {
        if (txtIUsuario != null) txtIUsuario.setEnabled(true);
        if (btnAceptar != null) btnAceptar.setEnabled(true);
        if (txtRespuestaSeguridad != null) txtRespuestaSeguridad.setEnabled(false);
        if (btnVerificar != null) btnVerificar.setEnabled(false);
        if (txtNuevaContrasenia != null) txtNuevaContrasenia.setEnabled(false);
        if (btnGuardar != null) btnGuardar.setEnabled(false);
    }

    public void mostrarSoloPanelPregunta() {
        if (txtIUsuario != null) txtIUsuario.setEnabled(false);
        if (btnAceptar != null) btnAceptar.setEnabled(false);
        if (txtRespuestaSeguridad != null) txtRespuestaSeguridad.setEnabled(true);
        if (btnVerificar != null) btnVerificar.setEnabled(true);
        if (txtNuevaContrasenia != null) txtNuevaContrasenia.setEnabled(false);
        if (btnGuardar != null) btnGuardar.setEnabled(false);
    }

    public void mostrarPanelRestablecerContrasenia() {
        if (txtIUsuario != null) txtIUsuario.setEnabled(false);
        if (btnAceptar != null) btnAceptar.setEnabled(false);
        if (txtRespuestaSeguridad != null) txtRespuestaSeguridad.setEnabled(false);
        if (btnVerificar != null) btnVerificar.setEnabled(false);
        if (txtNuevaContrasenia != null) txtNuevaContrasenia.setEnabled(true);
        if (btnGuardar != null) btnGuardar.setEnabled(true);
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
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
    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }
    public JTextField getTxtIUsuario() {
        return txtIUsuario;
    }
    public void setTxtIUsuario(JTextField txtIUsuario) {
        this.txtIUsuario = txtIUsuario;
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
    public JTextField getTxtRespuestaSeguridad() {
        return txtRespuestaSeguridad;
    }
    public void setTxtRespuestaSeguridad(JTextField txtRespuestaSeguridad) {
        this.txtRespuestaSeguridad = txtRespuestaSeguridad;
    }
    public JButton getVerificarButton() {
        return btnVerificar;
    }
    public void setVerificarButton(JButton verificarButton) {
        this.btnVerificar = verificarButton;
    }
    public JPanel getPanelSecundario() {
        return panelSecundario;
    }
    public void setPanelSecundario(JPanel panelSecundario) {
        this.panelSecundario = panelSecundario;
    }
    public JPanel getPanelTercero() {
        return panelTercero;
    }
    public void setPanelTercero(JPanel panelTercero) {
        this.panelTercero = panelTercero;
    }
    public JTextField getTxtNuevaContrasenia() {
        return txtNuevaContrasenia;
    }
    public void setTxtNuevaContrasenia(JTextField txtNuevaContrasenia) {
        this.txtNuevaContrasenia = txtNuevaContrasenia;
    }
    public JLabel getLblNuevaContrasenia() {
        return lblNuevaContrasenia;
    }
    public void setLblNuevaContrasenia(JLabel lblNuevaContrasenia) {
        this.lblNuevaContrasenia = lblNuevaContrasenia;
    }
    public JLabel getLblPreguntaSeguridad() {
        return lblPreguntaSeguridad;
    }
    public void setLblPreguntaSeguridad(JLabel lblPreguntaSeguridad) {
        this.lblPreguntaSeguridad = lblPreguntaSeguridad;
    }
    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }
    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }
}