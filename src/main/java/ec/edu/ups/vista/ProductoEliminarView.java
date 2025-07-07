package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class ProductoEliminarView extends JInternalFrame {
    private JTextField txtIngreseProducto;
    private JButton btnBuscar;
    private JTable table1;
    private JButton btnEliminar;
    private JLabel lblProductos;
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

}


