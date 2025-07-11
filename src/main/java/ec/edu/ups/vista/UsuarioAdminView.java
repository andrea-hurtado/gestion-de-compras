package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class UsuarioAdminView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField txtNombreCompleto;
    private JTextField txtFechaNacimiento;
    private JTextField txtCorreoElectronico;
    private JTextField txtTelefono;
    private JLabel lblNombreCompleto;
    private JLabel lblFechaNacimiento;
    private JLabel lblTelefono;
    private JButton btnCrear;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public UsuarioAdminView(MensajeInternacionalizacionHandler handler) {
        this.mensajeHandler = handler;
        setContentPane(panelPrincipal);
        setTitle("Gestión de Usuarios");
        setSize(600, 400);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
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

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public void setBtnListar(JButton btnListar) {
        this.btnListar = btnListar;
    }

    public JLabel getLblFechaNacimiento() {
        return lblFechaNacimiento;
    }

    public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
        this.lblFechaNacimiento = lblFechaNacimiento;
    }

    public JLabel getLblTelefono() {
        return lblTelefono;
    }

    public void setLblTelefono(JLabel lblTelefono) {
        this.lblTelefono = lblTelefono;
    }

    public JLabel getLblNombreCompleto() {
        return lblNombreCompleto;
    }

    public void setLblNombreCompleto(JLabel lblNombreCompleto) {
        this.lblNombreCompleto = lblNombreCompleto;
    }
}
