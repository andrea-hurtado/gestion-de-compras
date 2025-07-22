package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOBinario implements UsuarioDAO {

    private String rutaArchivo;
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioDAOBinario() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("admin", "12345", Rol.ADMINISTRADOR, "Andrea Hurtado", LocalDate.parse("2007-01-07"), "2007andreahurtado@gmail.com", "0995700101", "0150394138", new String[]{"Remigio", "Sushi", "YOU"} ));
        usuarios.add(new Usuario("user", "12345", Rol.USUARIO, "Tatiana Hurtado", LocalDate.parse("2000-08-03"), "tatianahurtado@gmail.com", "0995700100", "0910083088", new String[]{"David", "Pizza", "Arcane"} ));
    }

    public UsuarioDAOBinario(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        cargar();
    }
    private void cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (Exception e) {
            usuarios = new ArrayList<>();
        }
    }
    private void guardarArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void guardar(Usuario usuario) {
        usuarios.add(usuario);
        guardarArchivo();
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
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
    public List<Usuario> listarPorRol(Rol rol) {
        return List.of();
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return null;
    }
}
