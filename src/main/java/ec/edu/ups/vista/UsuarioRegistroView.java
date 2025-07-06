package ec.edu.ups.vista;

import javax.swing.*;

public class UsuarioRegistroView extends JInternalFrame {
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

    public UsuarioRegistroView() {
        setContentPane(panelPrincipal);
        setTitle("Registro de Usuario");
        setSize(600, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        initPreguntasSeguridad();
    }
    private void initPreguntasSeguridad() {
        String[] preguntas = {
                "¿Cuál es su deporte favorito?",
                "¿Cuál es el primer nombre de su padre?",
                "¿Cuál es su color favorito?",
                "¿Cuál es su película favorita?"
        };

        cbxPregunta1.setModel(new DefaultComboBoxModel<>(preguntas));
        cbxPregunta2.setModel(new DefaultComboBoxModel<>(preguntas));
        cbxPregunta3.setModel(new DefaultComboBoxModel<>(preguntas));
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
}
