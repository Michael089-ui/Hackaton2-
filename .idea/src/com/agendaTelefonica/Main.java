package com.agendaTelefonica;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda(5);

        int menu;

        do {
            System.out.println("---Menú Agenda ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. ¿Agenda llena?");
            System.out.println("7. Espacios libres");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            menu = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (menu) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine().trim();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine().trim();

                    Contacto nuevo = new Contacto(nombre, apellido, telefono);
                    agenda.añadirContacto(nuevo);
                    break;

                case 2:
                    agenda.listarContactos();
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombreBusqueda = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoBusqueda = scanner.nextLine();
                    agenda.buscaContacto(nombreBusqueda, apellidoBusqueda);
                    break;

                case 4:
                    System.out.print("Nombre: ");
                    String nombreElim = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoElim = scanner.nextLine();
                    Contacto cEliminar = new Contacto(nombreElim, apellidoElim, "");
                    agenda.eliminarContacto(cEliminar);
                    break;

                case 5:
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String ape = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTel = scanner.nextLine();
                    agenda.modificarTelefono(nom, ape, nuevoTel);
                    break;

                case 6:
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("Aún hay espacio en la agenda.");
                    }
                    break;

                case 7:
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (menu != 0);

        scanner.close();


    }
}
