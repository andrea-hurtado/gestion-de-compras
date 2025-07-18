package ec.edu.ups.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MensajeInternacionalizacionHandler {
    private ResourceBundle bundle;
    private Locale locale;

    public static String obtenerTexto(String clave) {
        ResourceBundle bundle = ResourceBundle.getBundle("mensajes");
        return bundle.getString(clave);
    }


    public MensajeInternacionalizacionHandler(String lenguaje, String pais) {
        this.locale = new Locale(lenguaje, pais);
        this.bundle = ResourceBundle.getBundle("mensajes", locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

    public void setLenguaje(String lenguaje, String pais) {
        this.locale = new Locale(lenguaje, pais);
        this.bundle = ResourceBundle.getBundle("mensajes", locale);
    }

    public Locale getLocale() {
        return locale;
    }
    public String getMensaje(String clave) {
        return  this.bundle.getString(clave);
    }




}