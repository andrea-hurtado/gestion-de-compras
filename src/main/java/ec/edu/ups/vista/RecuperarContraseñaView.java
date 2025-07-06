package ec.edu.ups.vista;

import javax.swing.*;

public class RecuperarContraseñaView extends JInternalFrame{

    public String mensaje;
    private JTextField txtUsuario;
    private JPanel panel1;
    private JTextField txtResponderPrefunta;
    private JButton btnVerificar;
    private JButton btnCancelar;
    private JLabel lblRespondaPregunta;
    private JLabel lblIngreseUsuario;
    private JLabel lblRecuperarContrasenia;

    public RecuperarContraseñaView(){
        setContentPane(panel1);
        setTitle("Registro de Usuario");
        setSize(600, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getTxtResponderPrefunta() {
        return txtResponderPrefunta;
    }

    public void setTxtResponderPrefunta(JTextField txtResponderPrefunta) {
        this.txtResponderPrefunta = txtResponderPrefunta;
    }

    public JButton getBtnVerificar() {
        return btnVerificar;
    }

    public void setBtnVerificar(JButton btnVerificar) {
        this.btnVerificar = btnVerificar;
    }

    public JLabel getLblRespondaPregunta() {
        return lblRespondaPregunta;
    }

    public void setLblRespondaPregunta(JLabel lblRespondaPregunta) {
        this.lblRespondaPregunta = lblRespondaPregunta;
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
}
