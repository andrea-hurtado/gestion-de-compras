package ec.edu.ups.modelo;

public enum Rol {
    ADMINISTRADOR("rol.admin"),
    USUARIO("rol.user");

    private final String key;

    Rol(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}