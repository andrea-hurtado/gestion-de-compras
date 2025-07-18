package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {

    private MensajeInternacionalizacionHandler mensajeHandler;

    private JMenuBar menuBar;

    private JMenu menuProducto;
    private JMenu menuCarrito;
    private JMenu menuIdioma;
    private JMenu menuSalir;
    private JMenu menuUsuario;

    private JMenuItem menuItemCrearProducto;
    private JMenuItem menuItemEliminarProducto;
    private JMenuItem menuItemActualizarProducto;
    private JMenuItem menuItemBuscarProducto;

    private JMenuItem menuItemCrearCarrito;
    private JMenuItem menuItemListarCarritos;
    private JMenuItem menuItemGestionarUsuarios;

    private JMenuItem menuItemIdiomaEspanol;
    private JMenuItem menuItemIdiomaIngles;
    private JMenuItem menuItemIdiomaFrances;

    private JMenuItem menuItemSalir;
    private JMenuItem menuItemCerrarSesion;

    private MiJDesktopPane jDesktopPane;

    public MenuPrincipalView(MensajeInternacionalizacionHandler mensajeHandler) {
        this.mensajeHandler = mensajeHandler;
        initComponents();
    }

    public MensajeInternacionalizacionHandler getMensajeHandler() {
        return mensajeHandler;
    }

    private void initComponents() {
        jDesktopPane = new MiJDesktopPane();
        menuBar = new JMenuBar();

        menuProducto = new JMenu(mensajeHandler.get("menu.producto"));
        menuCarrito = new JMenu(mensajeHandler.get("menu.carrito"));
        menuIdioma = new JMenu(mensajeHandler.get("menu.idiomas"));
        menuSalir = new JMenu(mensajeHandler.get("menu.salir"));
        menuUsuario = new JMenu(mensajeHandler.get("menu.usuario"));

        menuItemCrearProducto = new JMenuItem(mensajeHandler.get("menu.producto.crear"));
        menuItemEliminarProducto = new JMenuItem(mensajeHandler.get("menu.producto.eliminar"));
        menuItemActualizarProducto = new JMenuItem(mensajeHandler.get("menu.producto.actualizar"));
        menuItemBuscarProducto = new JMenuItem(mensajeHandler.get("menu.producto.buscar"));

        menuItemCrearCarrito = new JMenuItem(mensajeHandler.get("menu.carrito.crear"));
        menuItemListarCarritos = new JMenuItem(mensajeHandler.get("menu.carrito.listar"));

        menuItemGestionarUsuarios = new JMenuItem(mensajeHandler.get("menu.usuario.gestionar"));

        menuItemIdiomaEspanol = new JMenuItem(mensajeHandler.get("menu.idioma.es"));
        menuItemIdiomaIngles = new JMenuItem(mensajeHandler.get("menu.idioma.en"));
        menuItemIdiomaFrances = new JMenuItem(mensajeHandler.get("menu.idioma.fr"));

        menuItemSalir = new JMenuItem(mensajeHandler.get("menu.salir.salir"));
        menuItemCerrarSesion = new JMenuItem(mensajeHandler.get("menu.salir.cerrar"));

        menuBar.add(menuProducto);
        menuBar.add(menuCarrito);
        menuBar.add(menuIdioma);
        menuBar.add(menuSalir);

        menuProducto.add(menuItemCrearProducto);
        menuProducto.add(menuItemEliminarProducto);
        menuProducto.add(menuItemActualizarProducto);
        menuProducto.add(menuItemBuscarProducto);

        menuCarrito.add(menuItemCrearCarrito);
        menuCarrito.add(menuItemListarCarritos);

        menuUsuario.add(menuItemGestionarUsuarios);

        menuIdioma.add(menuItemIdiomaEspanol);
        menuIdioma.add(menuItemIdiomaIngles);
        menuIdioma.add(menuItemIdiomaFrances);

        menuSalir.add(menuItemSalir);
        menuSalir.add(menuItemCerrarSesion);

        menuBar.add(menuProducto);
        menuBar.add(menuCarrito);
        menuBar.add(menuUsuario);
        menuBar.add(menuIdioma);
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);
        setContentPane(jDesktopPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(mensajeHandler.get("app.titulo"));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void deshabilitarMenusAdministrador() {
        getMenuItemCrearProducto().setEnabled(false);
        getMenuItemBuscarProducto().setEnabled(false);
        getMenuItemActualizarProducto().setEnabled(false);
        getMenuItemEliminarProducto().setEnabled(false);
    }



    public void cambiarIdioma(String lenguaje, String pais) {
        mensajeHandler.setLenguaje(lenguaje, pais);

        setTitle(mensajeHandler.get("app.titulo"));

        menuProducto.setText(mensajeHandler.get("menu.producto"));
        menuCarrito.setText(mensajeHandler.get("menu.carrito"));
        menuIdioma.setText(mensajeHandler.get("menu.idiomas"));
        menuSalir.setText(mensajeHandler.get("menu.salir"));
        menuUsuario.setText(mensajeHandler.get("menu.usuario"));

        menuItemCrearProducto.setText(mensajeHandler.get("menu.producto.crear"));
        menuItemEliminarProducto.setText(mensajeHandler.get("menu.producto.eliminar"));
        menuItemActualizarProducto.setText(mensajeHandler.get("menu.producto.actualizar"));
        menuItemBuscarProducto.setText(mensajeHandler.get("menu.producto.buscar"));

        menuItemCrearCarrito.setText(mensajeHandler.get("menu.carrito.crear"));
        menuItemListarCarritos.setText(mensajeHandler.get("menu.carrito.listar"));

        menuItemGestionarUsuarios.setText(mensajeHandler.get("menu.usuario.gestionar"));

        menuItemIdiomaEspanol.setText(mensajeHandler.get("menu.idioma.es"));
        menuItemIdiomaIngles.setText(mensajeHandler.get("menu.idioma.en"));
        menuItemIdiomaFrances.setText(mensajeHandler.get("menu.idioma.fr"));

        menuItemSalir.setText(mensajeHandler.get("menu.salir.salir"));
        menuItemCerrarSesion.setText(mensajeHandler.get("menu.salir.cerrar"));
    }
    public JMenuItem getMenuItemCrearProducto() {
        return menuItemCrearProducto;
    }

    public JMenuItem getMenuItemEliminarProducto() {
        return menuItemEliminarProducto;
    }

    public JMenuItem getMenuItemActualizarProducto() {
        return menuItemActualizarProducto;
    }

    public JMenuItem getMenuItemBuscarProducto() {
        return menuItemBuscarProducto;
    }

    public JMenuItem getMenuItemCrearCarrito() {
        return menuItemCrearCarrito;
    }

    public JMenuItem getMenuItemListarCarritos() {
        return menuItemListarCarritos;
    }
    public JMenuItem getMenuItemGestionarUsuarios() {
        return menuItemGestionarUsuarios;
    }

    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public JMenuItem getMenuItemIdiomaEspanol() {
        return menuItemIdiomaEspanol;
    }

    public JMenuItem getMenuItemIdiomaIngles() {
        return menuItemIdiomaIngles;
    }

    public JMenuItem getMenuItemIdiomaFrances() {
        return menuItemIdiomaFrances;
    }

    public JMenuItem getMenuItemSalir() {
        return menuItemSalir;
    }

    public JMenuItem getMenuItemCerrarSesion() {
        return menuItemCerrarSesion;
    }



}
