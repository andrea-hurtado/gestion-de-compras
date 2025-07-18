package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.modelo.Carrito;
import java.io.*;
import java.util.*;

public class CarritoDAOTexto implements CarritoDAO {
    private final File archivo;

    public CarritoDAOTexto(String ruta) {
        this.archivo = new File(ruta);
    }

    @Override
    public void crear(Carrito carrito) {

    }

    @Override
    public Carrito buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public void actualizar(Carrito carrito) {

    }

    @Override
    public void eliminar(int codigo) {

    }

    @Override
    public List<Carrito> listarTodos() {
        return List.of();
    }
}