package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ec.edu.ups.modelo.Rol;

import java.util.List;


public class UsuarioAdminView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField txtUsuario;
    private JTextField txtCorreoElectronico;
    private JLabel lblCorreoElectronico;
    private JButton btnCrear;
    private JButton btnEditar;
    private JButton btnActualizar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JLabel lblNombreUsuario;
    private JTable tblUsuarios;
    private JComboBox cbxRol;
    private JLabel lblRol;
    private MensajeInternacionalizacionHandler mensajeHandler;
    private DefaultTableModel modelo;

    public UsuarioAdminView(MensajeInternacionalizacionHandler handler) {
        this.mensajeHandler = handler;
        setContentPane(panelPrincipal);
        setTitle("Gestión de Usuarios");
        setTitle(mensajeHandler.get("usuario.admin.titulo"));
        setSize(700, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);


        modelo = new DefaultTableModel(
                new Object[]{
                        mensajeHandler.get("usuario.admin.tabla.username"),
                        mensajeHandler.get("usuario.correoElectronico"),
                        mensajeHandler.get("usuario.rol")
                }, 0
        );

        tblUsuarios.setModel(modelo);

        cbxRol.setModel(new DefaultComboBoxModel<>(Rol.values()));

        tblUsuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = tblUsuarios.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    txtUsuario.setText(tblUsuarios.getValueAt(filaSeleccionada, 0).toString());
                    txtCorreoElectronico.setText(tblUsuarios.getValueAt(filaSeleccionada, 1).toString());
                    cbxRol.setSelectedItem(Rol.valueOf(tblUsuarios.getValueAt(filaSeleccionada, 2).toString()));
                }
            }

        });

    }
    public void actualizarTextos() {
        setTitle(mensajeHandler.get("usuario.admin.titulo"));

        lblNombreUsuario.setText(mensajeHandler.get("usuario.admin.tabla.username"));
        lblCorreoElectronico.setText(mensajeHandler.get("usuario.correoElectronico"));
        lblRol.setText(mensajeHandler.get("usuario.rol"));

        btnCrear.setText(mensajeHandler.get("usuario.boton.crear"));
        btnEditar.setText(mensajeHandler.get("usuario.boton.editar"));
        btnActualizar.setText(mensajeHandler.get("usuario.boton.actualizar"));
        btnBuscar.setText(mensajeHandler.get("usuario.boton.buscar"));
        btnListar.setText(mensajeHandler.get("usuario.boton.listar"));

        modelo.setColumnIdentifiers(new Object[]{
                mensajeHandler.get("usuario.admin.tabla.username"),
                mensajeHandler.get("usuario.rol"),
                mensajeHandler.get("usuario.correoElectronico")
        });
        modelo.fireTableStructureChanged();

    }

    public void cargarDatos(List<Usuario> usuarios) {
        modelo.setRowCount(0);
        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{u.getUsername(), u.getRol()});
        }
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }


    public JTextField getTxtCorreoElectronico() {
        return txtCorreoElectronico;
    }

    public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
        this.txtCorreoElectronico = txtCorreoElectronico;
    }

    public JLabel getLblCorreoElectronico() {
        return lblCorreoElectronico;
    }

    public void setLblCorreoElectronico(JLabel lblCorreoElectronico) {
        this.lblCorreoElectronico = lblCorreoElectronico;
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

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
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

    public JLabel getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public void setLblNombreUsuario(JLabel lblNombreUsuario) {
        this.lblNombreUsuario = lblNombreUsuario;
    }

    public JTable getTblUsuarios() {
        return tblUsuarios;
    }

    public void setTblUsuarios(JTable tblUsuarios) {
        this.tblUsuarios = tblUsuarios;
    }

    public JComboBox getCbxRol() {
        return cbxRol;
    }

    public void setCbxRol(JComboBox cbxRol) {
        this.cbxRol = cbxRol;
    }

    public JLabel getLblRol() {
        return lblRol;
    }

    public void setLblRol(JLabel lblRol) {
        this.lblRol = lblRol;
    }

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    public void mostrarMensaje(String clave) {
        JOptionPane.showMessageDialog(this, mensajeHandler.get(clave));
    }
}
