package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;

import java.util.List;

public class UsuarioDAOBinario implements UsuarioDAO {
    private String rutaArchivo;
    public UsuarioDAOBinario(String rutaArchivo) { this.rutaArchivo = rutaArchivo; }

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
