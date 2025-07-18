package ec.edu.ups.dao;

import ec.edu.ups.modelo.PreguntasSeguridad;

import java.util.List;

public interface PreguntasSeguridadDAO {
    List<PreguntasSeguridad> obtenerPreguntasBase();
    void guardarPreguntasPorUsuario(String username, List<PreguntasSeguridad> preguntas);
    boolean usuarioExiste(String username);
//    List<PreguntasSeguridad> obtenerPreguntasAleatorias(String username, int cantidad);
}
