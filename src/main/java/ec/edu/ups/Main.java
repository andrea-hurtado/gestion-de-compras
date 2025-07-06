package ec.edu.ups;

import ec.edu.ups.controlador.CarritoController;
import ec.edu.ups.controlador.ProductoController;
import ec.edu.ups.controlador.UsuarioController;
import ec.edu.ups.controlador.UsuarioRegistroController;
import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.dao.impl.CarritoDAOMemoria;
import ec.edu.ups.dao.impl.ProductoDAOMemoria;
import ec.edu.ups.dao.impl.UsuarioDAOMemoria;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import ec.edu.ups.vista.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MensajeInternacionalizacionHandler mensajeHandler = new MensajeInternacionalizacionHandler("es", "EC");
            UsuarioDAO usuarioDAO = new UsuarioDAOMemoria();
            LoginView loginView = new LoginView(mensajeHandler);
            UsuarioController usuarioController = new UsuarioController(usuarioDAO, loginView);
            UsuarioRegistroView registroView = new UsuarioRegistroView();
            UsuarioRegistroController registroController = new UsuarioRegistroController(registroView, usuarioDAO);

            loginView.getBtnRegistrarse().addActionListener(ev -> {
                registroView.setVisible(true);
                loginView.getLayeredPane().add(registroView); // O tu contenedor principal
            });


            loginView.setVisible(true);

            loginView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    Usuario usuarioAutenticado = usuarioController.getUsuarioAutenticado();
                    if (usuarioAutenticado != null) {
                        // Instanciar DAOs y vistas principales
                        ProductoDAO productoDAO = new ProductoDAOMemoria();
                        CarritoDAO carritoDAO = new CarritoDAOMemoria();

                        MenuPrincipalView principalView = new MenuPrincipalView(mensajeHandler);
                        ProductoAnadirView productoAnadirView = new ProductoAnadirView();
                        ProductoListaView productoListaView = new ProductoListaView();
                        CarritoAnadirView carritoAnadirView = new CarritoAnadirView(mensajeHandler);

                        ProductoController productoController = new ProductoController(
                                productoDAO, productoAnadirView, productoListaView, carritoAnadirView);
                        CarritoController carritoController = new CarritoController(
                                carritoDAO, productoDAO, carritoAnadirView);

                        principalView.mostrarMensaje("Bienvenido: " + usuarioAutenticado.getUsername());
                        if (usuarioAutenticado.getRol().equals(Rol.USUARIO)) {
                            principalView.deshabilitarMenusAdministrador();
                        }

                        // Listeners de cambio de idioma en el menú principal
                        principalView.getMenuItemIdiomaEspanol().addActionListener(ev -> {
                            mensajeHandler.setLenguaje("es", "EC");
                            //principalView.actualizarTextos();
                            //productoAnadirView.actualizarTextos();
                            //productoListaView.actualizarTextos();
                            //carritoAnadirView.actualizarTextos();
                        });
                        principalView.getMenuItemIdiomaIngles().addActionListener(ev -> {
                            mensajeHandler.setLenguaje("en", "US");
                            //principalView.actualizarTextos();
                            //productoAnadirView.actualizarTextos();
                            //productoListaView.actualizarTextos();
                            //carritoAnadirView.actualizarTextos();
                        });
                        principalView.getMenuItemIdiomaFrances().addActionListener(ev -> {
                            mensajeHandler.setLenguaje("fr", "FR");
                            //principalView.actualizarTextos();
                            //productoAnadirView.actualizarTextos();
                            //productoListaView.actualizarTextos();
                            //carritoAnadirView.actualizarTextos();
                        });

                        // Menú productos y carrito
                        principalView.getMenuItemCrearProducto().addActionListener(ev -> {
                            if (!productoAnadirView.isVisible()) {
                                productoAnadirView.setVisible(true);
                                principalView.getjDesktopPane().add(productoAnadirView);
                            }
                        });

                        principalView.getMenuItemBuscarProducto().addActionListener(ev -> {
                            if (!productoListaView.isVisible()) {
                                productoListaView.setVisible(true);
                                principalView.getjDesktopPane().add(productoListaView);
                            }
                        });

                        principalView.getMenuItemCrearCarrito().addActionListener(ev -> {
                            if (!carritoAnadirView.isVisible()) {
                                carritoAnadirView.setVisible(true);
                                principalView.getjDesktopPane().add(carritoAnadirView);
                            }
                        });

                        principalView.setVisible(true);
                    }
                }
            });
        });
    }
}
