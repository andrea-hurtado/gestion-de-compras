package ec.edu.ups.vista;

import ec.edu.ups.modelo.Rol;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class UsuarioRegistroView extends JFrame {
    private JPanel panelPrincipal;
    private JTextField txtNombreCompleto;
    private JTextField txtFechaNacimiento;
    private JTextField txtCorreoElectronico;
    private JTextField txtTelefono;
    private JComboBox<String> cbxPregunta1;
    private JComboBox<String> cbxPregunta2;
    private JComboBox<String> cbxPregunta3;
    private JTextField txtRespuesta1;
    private JTextField txtRespuesta2;
    private JTextField txtRespuesta3;
    private JButton btnRegistrarse;
    private JLabel lblNombreCompleto;
    private JLabel lblFechaNacimiento;
    private JLabel lblCorreoElectronico;
    private JLabel lblRespuesta1;
    private JLabel lblRespuesta2;
    private JLabel lblRespuesta3;
    private JLabel lblSistemaRegistro;
    private JTextField txtIngreseUsuario;
    private JTextField txtIngreseContrasenia;
    private JLabel lblusuario;
    private JLabel lblContrasenia;
    private JLabel lblTelefono;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public UsuarioRegistroView(MensajeInternacionalizacionHandler handler) {
        this.mensajeHandler = handler;
        initComponents();
        //initPreguntasSeguridad();
    }
    private void initComponents() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
//
//        cbxRol.removeAllItems();
//        for (Rol rol : Rol.values()) {
//            cbxRol.addItem(rol);
//        }
    }
    private void initPreguntasSeguridad() {
        String[] preguntas = {
                "¿Cuál es su deporte favorito?",
                "¿Cuál es el primer nombre de su padre?",
                "¿Cuál es su una película que le ponga triste?"
        };

        //cbxPregunta1.setModel(new DefaultComboBoxModel<>(preguntas));
        //cbxPregunta2.setModel(new DefaultComboBoxModel<>(preguntas));
        //cbxPregunta3.setModel(new DefaultComboBoxModel<>(preguntas));
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }


    public JTextField getTxtNombreCompleto() {
        return txtNombreCompleto;
    }

    public void setTxtNombreCompleto(JTextField txtNombreCompleto) {
        this.txtNombreCompleto = txtNombreCompleto;
    }

    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public JTextField getTxtCorreoElectronico() {
        return txtCorreoElectronico;
    }

    public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
        this.txtCorreoElectronico = txtCorreoElectronico;
    }

    public JComboBox<String> getCbxPregunta1() {
        return cbxPregunta1;
    }

    public void setCbxPregunta1(JComboBox<String> cbxPregunta1) {
        this.cbxPregunta1 = cbxPregunta1;
    }

    public JComboBox<String> getCbxPregunta3() {
        return cbxPregunta3;
    }

    public void setCbxPregunta3(JComboBox<String> cbxPregunta3) {
        this.cbxPregunta3 = cbxPregunta3;
    }

    public JTextField getTxtRespuesta2() {
        return txtRespuesta2;
    }

    public void setTxtRespuesta2(JTextField txtRespuesta2) {
        this.txtRespuesta2 = txtRespuesta2;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public void setBtnRegistrarse(JButton btnRegistrarse) {
        this.btnRegistrarse = btnRegistrarse;

    }

    public JTextField getTxtRespuesta3() {
        return txtRespuesta3;
    }

    public void setTxtRespuesta3(JTextField txtRespuesta3) {
        this.txtRespuesta3 = txtRespuesta3;
    }

    public JTextField getTxtRespuesta1() {
        return txtRespuesta1;
    }

    public void setTxtRespuesta1(JTextField txtRespuesta1) {
        this.txtRespuesta1 = txtRespuesta1;
    }

    public JComboBox<String> getCbxPregunta2() {
        return cbxPregunta2;
    }

    public void setCbxPregunta2(JComboBox<String> cbxPregunta2) {
        this.cbxPregunta2 = cbxPregunta2;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JLabel getLblFechaNacimiento() {
        return lblFechaNacimiento;
    }

    public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
        this.lblFechaNacimiento = lblFechaNacimiento;
    }

    public JLabel getLblNombreCompleto() {
        return lblNombreCompleto;
    }

    public void setLblNombreCompleto(JLabel lblNombreCompleto) {
        this.lblNombreCompleto = lblNombreCompleto;
    }

    public JLabel getLblCorreoElectronico() {
        return lblCorreoElectronico;
    }

    public void setLblCorreoElectronico(JLabel lblCorreoElectronico) {
        this.lblCorreoElectronico = lblCorreoElectronico;
    }

    public JLabel getLblRespuesta1() {
        return lblRespuesta1;
    }

    public void setLblRespuesta1(JLabel lblRespuesta1) {
        this.lblRespuesta1 = lblRespuesta1;
    }

    public JLabel getLblRespuesta2() {
        return lblRespuesta2;
    }

    public void setLblRespuesta2(JLabel lblRespuesta2) {
        this.lblRespuesta2 = lblRespuesta2;
    }

    public JLabel getLblRespuesta3() {
        return lblRespuesta3;
    }

    public void setLblRespuesta3(JLabel lblRespuesta3) {
        this.lblRespuesta3 = lblRespuesta3;
    }

    public JLabel getLblSistemaRegistro() {
        return lblSistemaRegistro;
    }

    public void setLblSistemaRegistro(JLabel lblSistemaRegistro) {
        this.lblSistemaRegistro = lblSistemaRegistro;
    }

    public JTextField getTxtIngreseUsuario() {
        return txtIngreseUsuario;
    }

    public void setTxtIngreseUsuario(JTextField txtIngreseUsuario) {
        this.txtIngreseUsuario = txtIngreseUsuario;
    }

    public JTextField getTxtIngreseContrasenia() {
        return txtIngreseContrasenia;
    }

    public void setTxtIngreseContrasenia(JTextField txtIngreseContrasenia) {
        this.txtIngreseContrasenia = txtIngreseContrasenia;
    }

    public JLabel getLblusuario() {
        return lblusuario;
    }

    public void setLblusuario(JLabel lblusuario) {
        this.lblusuario = lblusuario;
    }

    public JLabel getLblContrasenia() {
        return lblContrasenia;
    }

    public void setLblContrasenia(JLabel lblContrasenia) {
        this.lblContrasenia = lblContrasenia;
    }

    public JLabel getLblTelefono() {
        return lblTelefono;
    }

    public void setLblTelefono(JLabel lblTelefono) {
        this.lblTelefono = lblTelefono;
    }
}
