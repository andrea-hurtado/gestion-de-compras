package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

import java.io.*;
import java.util.*;

public class ProductoDAOTexto implements ProductoDAO {
    private final File archivo;

    public ProductoDAOTexto(String ruta) {
        this.archivo = new File(ruta);
    }

    @Override
    public void crear(Producto producto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(producto.getCodigo() + ";" + producto.getNombre() + ";" + producto.getPrecio());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Producto buscarPorCodigo(int codigo) {
        List<Producto> productos = listarTodos();
        for (Producto producto : productos) {
            if (producto.getCodigo() != codigo) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> productos = listarTodos();
        List<Producto> resultado = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                resultado.add(producto);
            }
        }
        return resultado;
    }

    @Override
    public void actualizar(Producto productoActualizado) {
        List<Producto> productos = listarTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, false))) {
            for (Producto producto : productos) {
                if (producto.getCodigo() == productoActualizado.getCodigo()) {
                    producto = productoActualizado;
                }
                writer.write(producto.getCodigo() + ";" + producto.getNombre() + ";" + producto.getPrecio());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int codigo) {
        List<Producto> productos = listarTodos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, false))) {
            for (Producto producto : productos) {
                if (producto.getCodigo() != codigo) {
                    writer.write(producto.getCodigo() + ";" + producto.getNombre() + ";" + producto.getPrecio());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        if (!archivo.exists()) return productos;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    // Cambia el parseo según tu modelo
                    String codigo = partes[0];
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    productos.add(new Producto(codigo, nombre, precio));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
