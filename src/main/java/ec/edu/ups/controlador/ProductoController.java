package ec.edu.ups.controlador;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.vista.*;
import ec.edu.ups.vista.ProductoAnadirView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoController {

    private final ProductoAnadirView productoAñadirView;
    private final ProductoListaView productoListaView;
    private final CarritoAnadirView carritoAñadirView;

    private final ProductoDAO productoDAO;

    public ProductoController(ProductoDAO productoDAO,
                              ProductoAnadirView productoAñadirView,
                              ProductoListaView productoListaView,
                              CarritoAnadirView carritoAñadirView,
                              ProductoActualizarView productoActualizarView,
                              ProductoEliminarView productoEliminarView) {

        this.productoDAO = productoDAO;
        this.productoAñadirView = productoAñadirView;
        this.productoListaView = productoListaView;
        this.carritoAñadirView = carritoAñadirView;
        this.configurarEventosEnVistas();
    }

    private void configurarEventosEnVistas() {
        productoAñadirView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        productoListaView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        productoListaView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProductos();
            }
        });

        carritoAñadirView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoPorCodigo();
            }
        });
    }

    private void guardarProducto() {
        int codigo = Integer.parseInt(productoAñadirView.getTxtCodigo().getText());
        String nombre = productoAñadirView.getTxtNombre().getText();
        double precio = Double.parseDouble(productoAñadirView.getTxtPrecio().getText());

        productoDAO.crear(new Producto(codigo, nombre, precio));
        productoAñadirView.mostrarMensaje("Producto guardado correctamente");
        productoAñadirView.limpiarCampos();
        productoAñadirView.mostrarProductos(productoDAO.listarTodos());
    }

    private void buscarProducto() {
        String nombre = productoListaView.getTxtBuscar().getText();

        List<Producto> productosEncontrados = productoDAO.buscarPorNombre(nombre);
        productoListaView.cargarDatos(productosEncontrados);
    }

    private void listarProductos() {
        List<Producto> productos = productoDAO.listarTodos();
        productoListaView.cargarDatos(productos);
    }

    private void buscarProductoPorCodigo() {
        int codigo = Integer.parseInt(carritoAñadirView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        if (producto == null) {
            carritoAñadirView.mostrarMensaje("No se encontro el producto");
            carritoAñadirView.getTxtNombre().setText("");
            carritoAñadirView.getTxtPrecio().setText("");
        } else {
            carritoAñadirView.getTxtNombre().setText(producto.getNombre());
            carritoAñadirView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }

    }
}