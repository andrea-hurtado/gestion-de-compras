package ec.edu.ups.vista;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Locale;

public class CarritoListaView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JButton btnListar;
    private JButton btnEliminar;
    private JPanel panel1;
    private JTable tblCarrito;
    private MensajeInternacionalizacionHandler mensajeHandler;
    private DefaultTableModel modelo;


    public CarritoListaView(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
        setContentPane(panelPrincipal);
        setTitle("Listado de Carritos");
        setSize(600, 400);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        modelo = new DefaultTableModel();
        tblCarrito.setModel(modelo);
        actualizarTextos();

        DefaultTableModel modelo = new DefaultTableModel();
        Object[] columnas = {"ID", "Usuario", "Subtotal", "IVA", "Total"};
        modelo.setColumnIdentifiers(columnas);
    }
    public void actualizarTextos() {
        setTitle(mensajeHandler.get("carritos.lista.titulo"));
        btnListar.setText(mensajeHandler.get("carritos.lista.btn.listar"));
        btnEliminar.setText(mensajeHandler.get("carritos.lista.btn.eliminar"));

        Object[] columnas = {
                mensajeHandler.get("carritos.lista.columna.codigo"),
                mensajeHandler.get("carritos.lista.columna.fecha"),
                mensajeHandler.get("carritos.lista.columna.usuario"),
                mensajeHandler.get("carritos.lista.columna.subtotal"),
                mensajeHandler.get("carritos.lista.columna.iva"),
                mensajeHandler.get("carritos.lista.columna.total"),
        };
        modelo.setColumnIdentifiers(columnas);
        tblCarrito.setModel(modelo);
        modelo.fireTableStructureChanged();
    }
    public void cargarDatos(List<Carrito> listaCarritos, Locale locale) {
        modelo.setRowCount(0);

        for (Carrito c : listaCarritos) {
            modelo.addRow(new Object[]{
                    c.getCodigo(),
                    ec.edu.ups.util.FormateadorUtils.formatearFecha(c.getFechaCreacion().getTime(), locale),
                    ec.edu.ups.util.FormateadorUtils.formatearMoneda(c.calcularSubtotal(), locale),
                    ec.edu.ups.util.FormateadorUtils.formatearMoneda(c.calcularIVA(), locale),
                    ec.edu.ups.util.FormateadorUtils.formatearMoneda(c.calcularTotal(), locale),
                    c.getUsuario().getUsername()
            });
        }
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }


    public JButton getBtnListar() {
        return btnListar;
    }

    public void setBtnListar(JButton btnListar) {
        this.btnListar = btnListar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTable getTable1() {
        return tblCarrito;
    }

    public void setTable1(JTable table1) {
        this.tblCarrito = table1;
    }

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    public void setMensajeHandler(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
    }

}
