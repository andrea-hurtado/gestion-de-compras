package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.LoginView;
import ec.edu.ups.vista.UsuarioAdminView;
import ec.edu.ups.vista.UsuarioRegistroView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioController {

    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private final LoginView loginView;
    private final UsuarioRegistroView usuarioRegistroView;
    private final UsuarioAdminView usuarioAdminView;


    public UsuarioController(UsuarioDAO usuarioDAO, LoginView loginView, UsuarioRegistroView usuarioRegistroView, UsuarioAdminView usuarioAdminView) {
        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
        this.usuarioRegistroView = usuarioRegistroView;
        this.usuarioAdminView = usuarioAdminView;
        this.usuario = null;

        configurarEventosEnVistas();
    }

    private void configurarEventosEnVistas(){
        loginView.getBtnIniciarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticar();
            }
        });
        loginView.getBtnRegistrarse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ffff");
                mostrarRegistro();
            }
        });
    }
    private void mostrarRegistro() {
        usuarioRegistroView.setVisible(true);
    }
    private void autenticar(){
        String username = loginView.getTxtUsername().getText();
        String contrasenia = loginView.getTxtContrasenia().getText();

        usuario = usuarioDAO.autenticar(username, contrasenia);
        if(usuario == null){
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        }else{
            loginView.dispose();
        }
    }

    public Usuario getUsuarioAutenticado(){
        return usuario;
    }
    
}