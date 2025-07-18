package ec.edu.ups.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String username;
    private String contrasenia;
    private Rol rol;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private String telefono;
    private String[] preguntasSeguridad;
    private String[] respuestasSeguridad;


    public Usuario(String nombreDeUsuario, String contrasenia, Rol rol, String nombreCompleto, LocalDate fechaNacimiento, String correoElectronico, String telefono, String[] respuestasSeguridad) {
        this.username = nombreDeUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.respuestasSeguridad = respuestasSeguridad;
    }


    public String[] getRespuestasSeguridad() {
        return respuestasSeguridad;
    }

    public void setRespuestasSeguridad(String[] respuestasSeguridad) {
        this.respuestasSeguridad = respuestasSeguridad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreDeUsuario='" + username + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", rol=" + rol + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono='" + telefono + '\'' +
                ", preguntasSeguridad=" + preguntasSeguridad +
                ", respuestasSeguridad=" + respuestasSeguridad +
                '}';
    }
}