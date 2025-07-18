package ec.edu.ups.controlador;

import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.*;
import ec.edu.ups.util.FormateadorUtils;
import ec.edu.ups.vista.CarritoAnadirView;
import ec.edu.ups.vista.CarritoListaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

public class CarritoController {

    private final CarritoDAO carritoDAO;
    private final ProductoDAO productoDAO;
    private final CarritoAnadirView carritoAnadirView;
    private final CarritoListaView carritoListaView;
    private Carrito carrito;
    private final Usuario usuarioAutenticado;

    public CarritoController(CarritoDAO carritoDAO,
                             ProductoDAO productoDAO,
                             CarritoAnadirView carritoAnadirView,
                             CarritoListaView carritoListaView,
                             Usuario usuarioAutenticado) {

        this.carritoDAO = carritoDAO;
        this.productoDAO = productoDAO;
        this.carritoAnadirView = carritoAnadirView;
        this.usuarioAutenticado = usuarioAutenticado;
        this.carritoListaView = carritoListaView;
        this.carrito = new Carrito();
        this.carrito.setUsuario(usuarioAutenticado);
        configurarEventosEnVistas();
    }

    private void configurarEventosEnVistas() {
        carritoAnadirView.getBtnAnadir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anadirProducto();
            }
        });

        carritoAnadirView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCarrito();
            }
        });
        carritoAnadirView.getBtnBuscar().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buscarProductoPorCodigo();
            }
        });
        carritoAnadirView.getBtnEliminar().addActionListener(e -> eliminarItem());
        carritoAnadirView.getBtnActualizar().addActionListener(e -> actualizarCantidad());
        carritoListaView.getBtnListar().addActionListener(e -> cargarCarritosEnTabla());


    }

    private void anadirProducto() {

        int codigo = Integer.parseInt(carritoAnadirView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        if (producto == null) {
            carritoAnadirView.mostrarMensaje("Producto no encontrado");
            return;
        }
        int cantidad =  Integer.parseInt(carritoAnadirView.getCbxCantidad().getSelectedItem().toString());
        carrito.agregarProducto(producto, cantidad);

        cargarProductos();
        mostrarTotales();

    }
    private void guardarCarrito() {
        carritoDAO.crear(carrito);
        carritoAnadirView.mostrarMensaje("Carrito creado correctamente");
        System.out.println(carritoDAO.listarTodos());
        carrito.setUsuario(usuarioAutenticado);
        limpiarTablaProductos();
        mostrarTotales();
    }

    private void cargarProductos(){
        Locale locale = carritoAnadirView.getMensajeInternacionalizacion().getLocale();


        List<ItemCarrito> items = carrito.obtenerItems();
        DefaultTableModel modelo = (DefaultTableModel) carritoAnadirView.getTblProductos().getModel();
        modelo.setNumRows(0);
        for (ItemCarrito item : items) {
            modelo.addRow(new Object[]{ item.getProducto().getCodigo(),
                    item.getProducto().getNombre(),
                    item.getProducto().getPrecio(),
                    FormateadorUtils.formatearMoneda(item.getProducto().getPrecio(), locale),
                    item.getCantidad(),
                    FormateadorUtils.formatearMoneda(item.getProducto().getPrecio() * item.getCantidad(), locale)
            });
        }
    }

    private void mostrarTotales(){
        Locale locale = carritoAnadirView.getMensajeInternacionalizacion().getLocale();
        String subtotal = FormateadorUtils.formatearMoneda(carrito.calcularSubtotal(), locale);
        String iva = String.valueOf(carrito.calcularIVA());
        String total = String.valueOf(carrito.calcularTotal());

        System.out.println(FormateadorUtils.formatearFecha(carrito.getFechaCreacion().getTime(), locale));

        carritoAnadirView.getTxtSubtotal().setText(subtotal);
        carritoAnadirView.getTxtIva().setText(iva);
        carritoAnadirView.getTxtTotal().setText(total);
    }
    private void cargarCarritosEnTabla() {
        List<Carrito> carritos;

        if (usuarioAutenticado.getRol().equals(Rol.ADMINISTRADOR)) {
            carritos = carritoDAO.listarTodos();
        } else {
            carritos = carritoDAO.listarTodos().stream()
                    .filter(c -> c.getUsuario().getUsername().equals(usuarioAutenticado.getUsername()))
                    .toList();
        }

        Locale locale = Locale.getDefault();
        carritoListaView.cargarDatos(carritos, locale);
    }
    private void eliminarItem() {
        int fila = carritoAnadirView.getTblProductos().getSelectedRow();
        if (fila >= 0) {
            int codigo = Integer.parseInt(carritoAnadirView.getTblProductos().getValueAt(fila, 0).toString());
            carrito.eliminarProducto(codigo);
            cargarProductos();
            mostrarTotales();
            carritoAnadirView.mostrarMensaje("Ítem eliminado correctamente.");
        } else {
            carritoAnadirView.mostrarMensaje("Seleccione un ítem para eliminar.");
        }
    }

    private void actualizarCantidad() {
        int fila = carritoAnadirView.getTblProductos().getSelectedRow();
        if (fila >= 0) {
            int codigo = Integer.parseInt(carritoAnadirView.getTblProductos().getValueAt(fila, 0).toString());
            String nuevaCantidadStr = JOptionPane.showInputDialog("Nueva cantidad:");
            if (nuevaCantidadStr != null && !nuevaCantidadStr.isEmpty()) {
                int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
                carrito.actualizarCantidadProducto(codigo, nuevaCantidad);
                cargarProductos();
                mostrarTotales();
                carritoAnadirView.mostrarMensaje("Cantidad actualizada correctamente.");
            }
        } else {
            carritoAnadirView.mostrarMensaje("Seleccione un ítem para actualizar.");
        }
    }

    private void limpiarTablaProductos() {
        var modelo = (javax.swing.table.DefaultTableModel) carritoAnadirView.getTblProductos().getModel();
        modelo.setRowCount(0);
    }

    private void buscarProductoPorCodigo() {
        int codigo = Integer.parseInt(carritoAnadirView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        if (producto == null) {
            carritoAnadirView.mostrarMensaje("No se encontro el producto");
            carritoAnadirView.getTxtNombre().setText("");
            carritoAnadirView.getTxtPrecio().setText("");
        } else {
            carritoAnadirView.getTxtNombre().setText(producto.getNombre());
            carritoAnadirView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }

    }


}