package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductoEliminarView extends JInternalFrame {
    private JTextField txtIngreseProducto;
    private JButton btnBuscar;
    private JTable table1;
    private JButton btnEliminar;
    private JLabel lblProductos;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private DefaultTableModel modelo;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public ProductoEliminarView(MensajeInternacionalizacionHandler handler) {
        this.mensajeHandler = handler;
        setContentPane(rootPane);
        setTitle("Eliminar Producto");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        modelo = new DefaultTableModel();
        Object[] columnas = {"Codigo", "Nombre"};
        modelo.setColumnIdentifiers(columnas);
        table1.setModel(modelo);

        actualizarTextos();
    }
    public void actualizarTextos() {
        setTitle(mensajeHandler.get("producto.eliminar.titulo"));
        lblProductos.setText(mensajeHandler.get("producto.eliminar.lbl.productos"));
        lblCodigo.setText(mensajeHandler.get("producto.eliminar.lbl.codigo"));
        lblNombre.setText(mensajeHandler.get("producto.eliminar.lbl.nombre"));
        btnBuscar.setText(mensajeHandler.get("producto.eliminar.btn.buscar"));
        btnEliminar.setText(mensajeHandler.get("producto.eliminar.btn.eliminar"));

        modelo.setColumnIdentifiers(new Object[]{
                mensajeHandler.get("producto.eliminar.tabla.codigo"),
                mensajeHandler.get("producto.eliminar.tabla.nombre")
        });
        modelo.fireTableStructureChanged();
    }


    public JTextField getTxtIngreseProducto() {
    return txtIngreseProducto;
    }

    public void setTxtIngreseProducto(JTextField txtIngreseProducto) {
    this.txtIngreseProducto = txtIngreseProducto;
    }

    public JButton getBtnBuscar() {
    return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
    this.btnBuscar = btnBuscar;
    }

    public JTable getTable1() {
    return table1;
    }

    public void setTable1(JTable table1) {
    this.table1 = table1;
    }

    public JButton getBtnEliminar() {
    return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
    this.btnEliminar = btnEliminar;
    }

    public JLabel getLblProductos() {
    return lblProductos;
    }

    public void setLblProductos(JLabel lblProductos) {
        this.lblProductos = lblProductos;
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
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
    public DefaultTableModel getModelo() {
        return modelo;
    }

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }
    public void cargarDatos(String codigo, String nombre) {
        Object[] fila = {
                codigo,
                nombre
        };
        modelo.addRow(fila);
    }
}


