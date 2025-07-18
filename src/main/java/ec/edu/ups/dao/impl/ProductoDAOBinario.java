package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOBinario implements ProductoDAO {

    private final File archivo;

    public ProductoDAOBinario(String ruta) {
        this.archivo = new File(ruta);
    }

    @Override
    public void crear(Producto producto) {
        List<Producto> productos = listarTodos();
        productos.add(producto);
        guardarLista(productos);
    }

    @Override
    public Producto buscarPorCodigo(int codigo) {for (Producto p : listarTodos()) {
        if (p.getCodigo() == codigo) return p;
    }
        return null;
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : listarTodos()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    @Override
    public void actualizar(Producto productoActualizado) {
        List<Producto> productos = listarTodos();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == productoActualizado.getCodigo()) {
                productos.set(i, productoActualizado);
                break;
            }
        }
        guardarLista(productos);

    }

    @Override
    public void eliminar(int codigo) {
        List<Producto> productos = listarTodos();
        productos.removeIf(p -> p.getCodigo() == codigo);
        guardarLista(productos);

    }

    @Override
    public List<Producto> listarTodos() {
        if (!archivo.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Producto>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    private void guardarLista(List<Producto> productos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
