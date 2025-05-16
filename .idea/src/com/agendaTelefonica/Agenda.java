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
    
}