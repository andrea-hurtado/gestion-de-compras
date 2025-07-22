package ec.edu.ups.dao;

import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

import java.util.List;

public interface ProductoDAO {

    void guardar(Producto producto);

    void crear(Producto producto);

    Producto buscarPorCodigo(int codigo);

    List<Producto> buscarPorNombre(String nombre);

    void actualizar(Producto producto);

    void eliminar(int codigo);

    List<Producto> listarTodos();

}