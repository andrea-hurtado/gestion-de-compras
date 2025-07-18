package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.PreguntasSeguridadDAO;
import ec.edu.ups.modelo.PreguntasSeguridad;
import java.util.*;

public class PreguntaSeguridadDAOMemoria implements PreguntasSeguridadDAO {

    private final List<PreguntasSeguridad> preguntasBase;
    private final Map<String, List<PreguntasSeguridad>> preguntasPorUsuario;
    private final Set<String> usuariosRegistrados;

    public PreguntaSeguridadDAOMemoria() {
        preguntasBase = new ArrayList<>();
        preguntasPorUsuario = new HashMap<>();
        usuariosRegistrados = new HashSet<>();

        preguntasBase.add(new PreguntasSeguridad("¿Cuál es el primer nombre de su padre?", ""));
        preguntasBase.add(new PreguntasSeguridad("¿Cuál es su comida favorita?", ""));
        preguntasBase.add(new PreguntasSeguridad("¿Cuál es su película o serie favorita?", ""));
    }

    @Override
    public List<PreguntasSeguridad> obtenerPreguntasBase() {
        return preguntasBase;
    }

    @Override
    public void guardarPreguntasPorUsuario(String username, List<PreguntasSeguridad> preguntas) {
        usuariosRegistrados.add(username);
        preguntasPorUsuario.put(username, preguntas);
    }

    @Override
    public boolean usuarioExiste(String username) {
        return preguntasPorUsuario.containsKey(username);
    }

}
