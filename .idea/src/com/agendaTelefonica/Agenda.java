package com.agendaTelefonica;

import java.util.ArrayList;

public class Agenda {

    private int maxContactos;

    //Array
    private ArrayList<Contacto> contactos;

    // Constructores
    public Agenda() {
        this.maxContactos = 10;
        this.contactos = new ArrayList<>();
    }

    public Agenda(int maxContactos) {
        this.maxContactos = maxContactos;
        this.contactos = new ArrayList<>();
    }

    // Metodos

    //añadir contacto
    public void agregarContacto(Contacto nuevo) {
        if (nuevo.getNombre().isEmpty() || nuevo.getApellido().isEmpty()) {
            System.out.println("El nombre y el apellido no pueden estar vacíos.");
            return;
        }

        if (contactos.size() >= maxContactos) {
            System.out.println("La agenda está llena. No puedes agregar más contactos.");
            return;
        }

        if (existeContacto(nuevo)) {
            System.out.println("Este contacto ya existe en la agenda.");
            return;
        }

        contactos.add(nuevo);
        System.out.println("Contacto agregado correctamente.");
    }

    // Si ya existe
    public boolean existeContacto(Contacto contacto) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(contacto.getNombre()) &&
                    c.getApellido().equalsIgnoreCase(contacto.getApellido())) {
                return true;
            }
        }
        return false;
    }

    // Para listar
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
            return;
        }

        System.out.println("Contactos en la agenda:");
        for (Contacto c : contactos) {
            System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }
    }

    // Buscar por nombre y apellido
    public void buscarContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono de " + nombre + " " + apellido + ": " + c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Eliminar
    public void eliminarContacto(Contacto contacto) {
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            if (c.getNombre().equalsIgnoreCase(contacto.getNombre()) &&
                    c.getApellido().equalsIgnoreCase(contacto.getApellido())) {
                contactos.remove(i);
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado. No se pudo eliminar.");
    }

    // Modificar el teléfono
    public void modificarTelefono(String nombre, String apellido, int nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado correctamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Verificar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= maxContactos;
    }

    // Mostrar cuántos espacios quedan
    public void espaciosLibres() {
        int libres = maxContactos - contactos.size();
        System.out.println("Espacios disponibles: " + libres);
    }
}