package ec.edu.ups.vista;

import ec.edu.ups.modelo.Producto;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProductoActualizarView extends JInternalFrame{
    private JTextField txtIngreseProducto;
    private JButton btnActualizar;
    private JTable tblProductos;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JLabel lblProducto;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JButton btnCancelar;
    private JLabel lblNombre;
    private JLabel lblCodigo;
    private JPanel panelPrincipal;
    private MensajeInternacionalizacionHandler mensajeHandler;
    private DefaultTableModel modelo;


    public ProductoActualizarView(MensajeInternacionalizacionHandler handler) {
        this.mensajeHandler = handler;
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        modelo = new DefaultTableModel();
        tblProductos.setModel(modelo);

        actualizarTextos();
    }

    public void actualizarTextos() {
        setTitle(mensajeHandler.get("producto.actualizar.titulo"));
        lblProducto.setText(mensajeHandler.get("producto.actualizar.label"));
        lblCodigo.setText(mensajeHandler.get("producto.lbl.codigo"));
        lblNombre.setText(mensajeHandler.get("producto.lbl.nombre"));
        btnBuscar.setText(mensajeHandler.get("producto.btn.buscar"));
        btnActualizar.setText(mensajeHandler.get("producto.btn.actualizar"));
        btnEliminar.setText(mensajeHandler.get("producto.btn.eliminar"));
        btnCancelar.setText(mensajeHandler.get("producto.btn.cancelar"));

        modelo.setColumnIdentifiers(new String[]{
                mensajeHandler.get("producto.columna.codigo"),
                mensajeHandler.get("producto.columna.nombre")
        });
        modelo.fireTableStructureChanged();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensajeHandler.get(mensaje));
    }
    public void cargarDatos(List<Producto> Productos) {
        modelo.setRowCount(0);

        for (Producto producto : Productos) {
            modelo.addRow(new Object[]{
                    producto.getCodigo(),
                    producto.getNombre()
            });
        }

    }


    public JTextField getTxtIngreseProducto() {
        return txtIngreseProducto;
    }

    public void setTxtIngreseProducto(JTextField txtIngreseProducto) {
        this.txtIngreseProducto = txtIngreseProducto;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JTable getTable1() {
        return tblProductos;
    }

    public void setTable1(JTable table1) {
        this.tblProductos = table1;
    }

    public JButton getEliminarButton() {
        return btnEliminar;
    }

    public void setEliminarButton(JButton eliminarButton) {
        this.btnEliminar = eliminarButton;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JLabel getLblProducto() {
        return lblProducto;
    }

    public void setLblProducto(JLabel lblProducto) {
        this.lblProducto = lblProducto;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }


    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }

    public JTable getTblProductos() { return tblProductos; }
    public DefaultTableModel getModelo() { return modelo; }



}
