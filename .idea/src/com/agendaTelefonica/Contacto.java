package com.agendaTelefonica;

public class Contacto {
    private String nombre;
    private String apellido;
    private int telefono;

    public Contacto(String nombre, String apellido, String telefono) { // Método constructor vacio
    }

    public Contacto(String nombre, String apellido, int telefono) { // Método constructor con validaciones
        if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()){
            System.out.println("Nombres y apellidos no pueden quedar vacíos"); // Oocional poner un thorow new Illegal
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
