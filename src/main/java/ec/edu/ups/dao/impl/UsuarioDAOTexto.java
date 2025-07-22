package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOTexto implements UsuarioDAO {
    private String rutaArchivo;

    private List<Usuario> usuarios;
    public UsuarioDAOTexto() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("admin", "12345", Rol.ADMINISTRADOR, "Andrea Hurtado", LocalDate.parse("2007-01-07"), "2007andreahurtado@gmail.com", "0995700101", "0150394138", new String[]{"Remigio", "Sushi", "YOU"} ));
        usuarios.add(new Usuario("user", "12345", Rol.USUARIO, "Tatiana Hurtado", LocalDate.parse("2000-08-03"), "tatianahurtado@gmail.com", "0995700100", "0910083088", new String[]{"David", "Pizza", "Arcane"} ));
    }

    public UsuarioDAOTexto(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardar(Usuario usuario) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {

            writer.println(usuario.getUsername() + ";" +
                    usuario.getContrasenia() + ";" +
                    usuario.getCedula() + ";" +
                    usuario.getRol().name() + ";" +
                    usuario.getCorreoElectronico());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario autenticar(String username, String contrasenia) {
        return null;
    }

    @Override
    public void crear(Usuario usuario) {

    }

    @Override
    public Usuario buscarPorUsername(String username) {
        return null;
    }

    @Override
    public void eliminar(String username) {

    }

    @Override
    public void actualizar(Usuario usuario) {

    }

    @Override
    public List<Usuario> listarTodos() {
        return List.of();
    }

    @Override
    public List<Usuario> listarPorRol(Rol rol) {
        return List.of();
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return null;
    }
}
