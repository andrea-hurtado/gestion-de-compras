package ec.edu.ups.modelo;

public class PreguntasSeguridad {
    private String pregunta;
    private String respuesta;

    public PreguntasSeguridad(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
