package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarritoAnadirView extends JInternalFrame {
    private JButton btnBuscar;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnAnadir;
    private JTable tblProductos;
    private JTextField txtSubtotal;
    private JTextField txtIva;
    private JTextField txtTotal;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JComboBox cbxCantidad;
    private JPanel panelPrincipal;
    private JLabel lblIVA;
    private JLabel lblTotal;
    private JLabel lblSubtotal;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblPrecio;
    private JLabel lblCantidad;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private MensajeInternacionalizacionHandler mensajeHandler;

    public CarritoAnadirView(MensajeInternacionalizacionHandler mensajeHandler){
        super("Carrito de Compras", true, true, false, true);
        this.mensajeHandler = mensajeHandler;
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        DefaultTableModel modelo = new DefaultTableModel();
        Object[] columnas = {"Codigo", "Nombre", "Precio", "Cantidad", "Subtotal"};
        modelo.setColumnIdentifiers(columnas);
        tblProductos.setModel(modelo);

        cargarDatos();

    }
    public void actualizarTextos() {
        setTitle(mensajeHandler.get("carrito.anadir.titulo"));
        lblCodigo.setText(mensajeHandler.get("producto.lbl.codigo"));
        lblNombre.setText(mensajeHandler.get("producto.lbl.nombre"));
        lblPrecio.setText(mensajeHandler.get("producto.lbl.precio"));
        lblCantidad.setText(mensajeHandler.get("carrito.lbl.cantidad"));
        lblSubtotal.setText(mensajeHandler.get("carrito.lbl.subtotal"));
        lblIVA.setText(mensajeHandler.get("carrito.lbl.iva"));
        lblTotal.setText(mensajeHandler.get("carrito.lbl.total"));
        btnBuscar.setText(mensajeHandler.get("carrito.btn.buscar"));
        btnAnadir.setText(mensajeHandler.get("carrito.btn.anadir"));
        btnGuardar.setText(mensajeHandler.get("carrito.btn.guardar"));
        btnLimpiar.setText(mensajeHandler.get("carrito.btn.limpiar"));
        btnEliminar.setText(mensajeHandler.get("carrito.btn.eliminar"));
        btnActualizar.setText(mensajeHandler.get("carrito.btn.actualizar"));
    }


    private void cargarDatos(){
        cbxCantidad.removeAllItems();
        for(int i = 0; i < 20; i++){
            cbxCantidad.addItem(String.valueOf(i + 1));
        }
    }
    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JButton getBtnAnadir() {
        return btnAnadir;
    }

    public JTable getTblProductos() {
        return tblProductos;
    }

    public JTextField getTxtSubtotal() {
        return txtSubtotal;
    }

    public JTextField getTxtIva() {
        return txtIva;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JComboBox getCbxCantidad() {
        return cbxCantidad;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public MensajeInternacionalizacionHandler getMensajeInternacionalizacion() {
        return mensajeHandler;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnActualizar() {return btnActualizar;}

    public JLabel getLblSubtotal() {
        return lblSubtotal;
    }

    public void setLblSubtotal(JLabel lblSubtotal) {
        this.lblSubtotal = lblSubtotal;
    }

    public JLabel getLblTotal() {
        return lblTotal;
    }

    public void setLblTotal(JLabel lblTotal) {
        this.lblTotal = lblTotal;
    }

    public JLabel getLblIVA() {
        return lblIVA;
    }

    public void setLblIVA(JLabel lblIVA) {
        this.lblIVA = lblIVA;
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

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    public JLabel getLblCantidad() {
        return lblCantidad;
    }

    public void setLblCantidad(JLabel lblCantidad) {
        this.lblCantidad = lblCantidad;
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

}
