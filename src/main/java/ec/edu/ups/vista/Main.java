package ec.edu.ups.vista;

import ec.edu.ups.controlador.ProductoController;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.impl.ProductoDAOMemoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                PrincipalView principalView = new PrincipalView();
                ProductoDAO productoDAO = new ProductoDAOMemoria();

                principalView.getMenuItemCrearProducto().addActionListener(new ActionListener(){
                    @Override
                            public void actionPerformed(ActionEvent e){
                        if(productoAñadir)
                         principalView.getMenuItemCrearProducto().setVisible(true);
                    }
                });

                ProductoAnadirView productoView = new ProductoAnadirView();
                ProductoListaView productoListaView = new ProductoListaView();
                ProductoDAO productoDAO = new ProductoDAOMemoria();

                new ProductoController(productoDAO, productoView, productoListaView);
            }
        });
    }
}
