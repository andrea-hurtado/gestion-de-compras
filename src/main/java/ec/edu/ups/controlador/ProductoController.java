package ec.edu.ups.controlador;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.vista.*;
import ec.edu.ups.vista.ProductoAnadirView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoController {

    private final ProductoAnadirView productoAñadirView;
    private final ProductoListaView productoListaView;
    private final CarritoAnadirView carritoAñadirView;
    private final ProductoEliminarView productoEliminarView;
    private final ProductoActualizarView productoActualizarView;
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
        this.productoEliminarView = productoEliminarView;
        this.productoActualizarView = productoActualizarView;
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
        productoActualizarView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        productoEliminarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoParaEliminar();
            }
        });

        productoEliminarView.getBtnEliminar().addActionListener(e -> eliminarProductoSeleccionado());

        configurarSeleccionTablaEliminar();
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
    private void actualizarProducto() {
        try {
            int codigo = Integer.parseInt(productoActualizarView.getTxtCodigo().getText());
            String nombre = productoActualizarView.getTxtNombre().getText();

            Producto productoActualizado = new Producto(codigo, nombre);
            productoDAO.actualizar(productoActualizado);

            productoActualizarView.mostrarMensaje("Producto actualizado correctamente");

            productoActualizarView.cargarDatos(productoDAO.listarTodos());

            productoListaView.cargarDatos(productoDAO.listarTodos());

        } catch (NumberFormatException e) {
            productoActualizarView.mostrarMensaje("Error: formato numérico inválido");
        } catch (Exception e) {
            productoActualizarView.mostrarMensaje("Error al actualizar el producto");
        }
    }

    private void buscarProductoParaEliminar() {
        String nombre = productoEliminarView.getTxtNombre().getText();
        List<Producto> productos = productoDAO.buscarPorNombre(nombre);

        productoEliminarView.getModelo().setRowCount(0);

        for (Producto producto : productos) {
            Object[] fila = {
                    producto.getCodigo(),
                    producto.getNombre()
            };
            productoEliminarView.getModelo().addRow(fila);
        }

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(productoEliminarView, "No se encontraron productos con ese nombre.");
        }
    }

    private void configurarSeleccionTablaEliminar() {
        productoEliminarView.getTable1().getSelectionModel().addListSelectionListener(e -> {
            int fila = productoEliminarView.getTable1().getSelectedRow();
            if (fila != -1) {
                String codigo = productoEliminarView.getTable1().getValueAt(fila, 0).toString();
                String nombre = productoEliminarView.getTable1().getValueAt(fila, 1).toString();

                productoEliminarView.getTxtCodigo().setText(codigo);
                productoEliminarView.getTxtNombre().setText(nombre);
            }
        });
    }

    private void eliminarProductoSeleccionado() {
        try {
            int codigo = Integer.parseInt(productoEliminarView.getTxtCodigo().getText());

            int confirmacion = JOptionPane.showConfirmDialog(
                    productoEliminarView,
                    "¿Está seguro que desea eliminar este producto?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                productoDAO.eliminar(codigo);

                productoEliminarView.getTxtNombre().setText("");
                productoEliminarView.getTxtCodigo().setText("");
                productoEliminarView.getModelo().setRowCount(0);

                productoListaView.cargarDatos(productoDAO.listarTodos());
                productoActualizarView.cargarDatos(productoDAO.listarTodos());


                JOptionPane.showMessageDialog(productoEliminarView, "Producto eliminado correctamente.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(productoEliminarView, "Ingrese un código válido.");
        }
    }

}