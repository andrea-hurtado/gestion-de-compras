package ec.edu.ups;

import ec.edu.ups.controlador.CarritoController;
import ec.edu.ups.controlador.ProductoController;
import ec.edu.ups.controlador.UsuarioController;
import ec.edu.ups.controlador.UsuarioRegistroController;
import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.dao.PreguntasSeguridadDAO;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.dao.impl.*;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import ec.edu.ups.vista.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {

            MensajeInternacionalizacionHandler mensajeHandler = new MensajeInternacionalizacionHandler("es", "EC");

            String[] opciones = {"memoria", "texto", "binario"};
            String opcionUsuario = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el tipo de almacenamiento para USUARIOS",
                    "Tipo de almacenamiento",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            String rutaUsuario = null;
            if ("texto".equals(opcionUsuario) || "binario".equals(opcionUsuario)) {
                rutaUsuario = JOptionPane.showInputDialog(null, "Ingrese la ruta del archivo para USUARIOS:");
            }
            UsuarioDAO usuarioDAO;
            switch (opcionUsuario) {
                case "memoria":
                    usuarioDAO = new UsuarioDAOMemoria();
                    break;
                case "texto":
                    usuarioDAO = new UsuarioDAOTexto(rutaUsuario);
                    break;
                case "binario":
                    usuarioDAO = new UsuarioDAOBinario(rutaUsuario);
                    break;
                default:
                    usuarioDAO = new UsuarioDAOMemoria();
            }

            String opcionProducto = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el tipo de almacenamiento para PRODUCTOS",
                    "Tipo de almacenamiento",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            String rutaProducto = null;
            if ("texto".equals(opcionProducto) || "binario".equals(opcionProducto)) {
                rutaProducto = JOptionPane.showInputDialog(null, "Ingrese la ruta del archivo para PRODUCTOS:");
            }
            ProductoDAO productoDAO;
            switch (opcionProducto) {
                case "memoria":
                    productoDAO = new ProductoDAOMemoria();
                    break;
                case "texto":
                    productoDAO = new ProductoDAOTexto(rutaProducto);
                    break;
                case "binario":
                    productoDAO = new ProductoDAOBinario(rutaProducto);
                    break;
                default:
                    productoDAO = new ProductoDAOMemoria();
            }

            String opcionCarrito = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el tipo de almacenamiento para CARRITOS",
                    "Tipo de almacenamiento",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            String rutaCarrito = null;
            if ("texto".equals(opcionCarrito) || "binario".equals(opcionCarrito)) {
                rutaCarrito = JOptionPane.showInputDialog(null, "Ingrese la ruta del archivo para CARRITOS:");
            }
            CarritoDAO carritoDAO;
            switch (opcionCarrito) {
                case "memoria":
                    carritoDAO = new CarritoDAOMemoria();
                    break;
                case "texto":
                    carritoDAO = new CarritoDAOTexto(rutaCarrito);
                    break;
                case "binario":
                    carritoDAO = new CarritoDAOBinario(rutaCarrito);
                    break;
                default:
                    carritoDAO = new CarritoDAOMemoria();
            }


            LoginView loginView = new LoginView(mensajeHandler);
            UsuarioRegistroView usuarioRegistroView = new UsuarioRegistroView(mensajeHandler);
            UsuarioAdminView usuarioAdminView = new UsuarioAdminView(mensajeHandler);
            RecuperarContraseniaView recuperarContraseniaView = new RecuperarContraseniaView(mensajeHandler);
            ResourceBundle bundle = ResourceBundle.getBundle("mensajes");

            MenuPrincipalView principalView = new MenuPrincipalView(mensajeHandler);
            ProductoAnadirView productoAnadirView = new ProductoAnadirView(mensajeHandler);
            ProductoListaView productoListaView = new ProductoListaView(mensajeHandler);
            ProductoActualizarView productoActualizarView = new ProductoActualizarView(mensajeHandler);
            ProductoEliminarView productoEliminarView = new ProductoEliminarView(mensajeHandler);
            CarritoAnadirView carritoAnadirView = new CarritoAnadirView(mensajeHandler);
            CarritoListaView carritoListaView = new CarritoListaView(mensajeHandler);

            PreguntasSeguridadDAO preguntasSeguridadDAO = new PreguntaSeguridadDAOMemoria();

            ProductoController productoController = new ProductoController(
                    productoDAO,
                    productoAnadirView,
                    productoListaView,
                    carritoAnadirView,
                    productoActualizarView,
                    productoEliminarView
            );


            UsuarioController usuarioController = new UsuarioController(
                    usuarioDAO,
                    loginView,
                    usuarioRegistroView,
                    usuarioAdminView,
                    recuperarContraseniaView
            );

            loginView.setVisible(true);

            loginView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {

                    Usuario usuarioAutenticado = usuarioController.getUsuarioAutenticado();
                    if (usuarioAutenticado != null) {
                        CarritoController carritoController = new CarritoController(
                                carritoDAO,
                                productoDAO,
                                carritoAnadirView,
                                carritoListaView,
                                usuarioAutenticado
                        );

                        principalView.mostrarMensaje("Bienvenido: " + usuarioAutenticado.getUsername());
                        if (usuarioAutenticado.getRol().equals(Rol.USUARIO)) {
                            principalView.deshabilitarMenusAdministrador();
                        }
                        principalView.setVisible(true);
                    }
                }
            });
            principalView.getMenuItemCrearProducto().addActionListener(ev -> {
                if (!productoAnadirView.isVisible()) {
                    principalView.getjDesktopPane().add(productoAnadirView);
                    productoAnadirView.setVisible(true);
                }
            });

            principalView.getMenuItemBuscarProducto().addActionListener(ev -> {
                if (!productoListaView.isVisible()) {
                    principalView.getjDesktopPane().add(productoListaView);
                    productoListaView.setVisible(true);
                }
            });

            principalView.getMenuItemActualizarProducto().addActionListener(ev -> {
                if (!productoActualizarView.isVisible()) {
                    principalView.getjDesktopPane().add(productoActualizarView);
                    productoActualizarView.setVisible(true);
                }
            });

            principalView.getMenuItemEliminarProducto().addActionListener(ev -> {
                if (!productoEliminarView.isVisible()) {
                    principalView.getjDesktopPane().add(productoEliminarView);
                    productoEliminarView.setVisible(true);
                }
            });

            principalView.getMenuItemCrearCarrito().addActionListener(ev -> {
                if (!carritoAnadirView.isVisible()) {
                    principalView.getjDesktopPane().add(carritoAnadirView);
                    carritoAnadirView.setVisible(true);
                }
            });

            principalView.getMenuItemListarCarritos().addActionListener(ev -> {
                if (!carritoListaView.isVisible()) {
                    principalView.getjDesktopPane().add(carritoListaView);
                    carritoListaView.setVisible(true);
                }
            });

            principalView.getMenuItemGestionarUsuarios().addActionListener(ev -> {
                if (!usuarioAdminView.isVisible()) {
                    principalView.getjDesktopPane().add(usuarioAdminView);
                    usuarioAdminView.setVisible(true);
                    usuarioController.buscarUsuarios();
                }
            });

            principalView.getMenuItemCerrarSesion().addActionListener(ev -> {
                principalView.setVisible(false);

                usuarioController.setUsuarioAutenticado(null);

                loginView.limpiarCampos();
                loginView.setVisible(true);
            });

            principalView.getMenuItemSalir().addActionListener(ev -> {
                System.exit(0);
            });

            principalView.getMenuItemIdiomaEspanol().addActionListener(ev -> {
                mensajeHandler.setLenguaje("es", "EC");
                principalView.cambiarIdioma("es", "EC");

                usuarioAdminView.actualizarTextos();
                usuarioRegistroView.actualizarTextos();
                carritoAnadirView.actualizarTextos();
                carritoListaView.actualizarTextos();
                productoActualizarView.actualizarTextos();
                productoAnadirView.actualizarTextos();
                productoEliminarView.actualizarTextos();
                productoListaView.actualizarTextos();

                carritoAnadirView.setMensajeHandler(mensajeHandler);
                carritoAnadirView.actualizarTextos();

                productoActualizarView.setMensajeHandler(mensajeHandler);
                productoActualizarView.actualizarTextos();

                productoAnadirView.setMensajeHandler(mensajeHandler);
                productoAnadirView.actualizarTextos();

                productoEliminarView.setMensajeHandler(mensajeHandler);
                productoEliminarView.actualizarTextos();

                productoListaView.setMensajeHandler(mensajeHandler);
                productoListaView.actualizarTextos();
            });

            principalView.getMenuItemIdiomaIngles().addActionListener(ev -> {
                mensajeHandler.setLenguaje("en", "US");
                principalView.cambiarIdioma("en", "US");

                usuarioAdminView.actualizarTextos();
                usuarioRegistroView.actualizarTextos();
                carritoAnadirView.actualizarTextos();
                carritoListaView.actualizarTextos();
                productoActualizarView.actualizarTextos();
                productoAnadirView.actualizarTextos();
                productoEliminarView.actualizarTextos();
                productoListaView.actualizarTextos();

                carritoAnadirView.setMensajeHandler(mensajeHandler);
                carritoAnadirView.actualizarTextos();

                carritoListaView.setMensajeHandler(mensajeHandler);
                carritoListaView.actualizarTextos();

                productoActualizarView.setMensajeHandler(mensajeHandler);
                productoActualizarView.actualizarTextos();

                productoAnadirView.setMensajeHandler(mensajeHandler);
                productoAnadirView.actualizarTextos();

                productoEliminarView.setMensajeHandler(mensajeHandler);
                productoEliminarView.actualizarTextos();

                productoListaView.setMensajeHandler(mensajeHandler);
                productoListaView.actualizarTextos();
                        });

            principalView.getMenuItemIdiomaFrances().addActionListener(ev -> {
                mensajeHandler.setLenguaje("fr", "FR");
                principalView.cambiarIdioma("fr", "FR");

                usuarioAdminView.actualizarTextos();
                usuarioRegistroView.actualizarTextos();
                carritoAnadirView.actualizarTextos();
                carritoListaView.actualizarTextos();
                productoActualizarView.actualizarTextos();
                productoAnadirView.actualizarTextos();
                productoEliminarView.actualizarTextos();
                productoListaView.actualizarTextos();

                carritoAnadirView.setMensajeHandler(mensajeHandler);
                carritoAnadirView.actualizarTextos();

                carritoListaView.setMensajeHandler(mensajeHandler);
                carritoListaView.actualizarTextos();

                productoActualizarView.setMensajeHandler(mensajeHandler);
                productoActualizarView.actualizarTextos();

                productoAnadirView.setMensajeHandler(mensajeHandler);
                productoAnadirView.actualizarTextos();

                productoEliminarView.setMensajeHandler(mensajeHandler);
                productoEliminarView.actualizarTextos();

                productoListaView.setMensajeHandler(mensajeHandler);
                productoListaView.actualizarTextos();
            });
        });
    }
}