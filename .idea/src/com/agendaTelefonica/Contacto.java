package com.agendaTelefonica;

public class Contacto {
    String nombre;
    String apellido;
    int telefono;

    public Contacto() { // Método constructor vacio
    }

    public Contacto(String nombre, String apellido, int telefono) { // Método constructor con validaciones
        if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()){
            System.out.println("Nombres y apellidos no pueden quedar vacíos"); // Oocional poner un thorow new Illegal
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
}
