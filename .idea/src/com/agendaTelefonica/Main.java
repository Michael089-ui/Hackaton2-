package com.agendaTelefonica;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda;

        System.out.println("¿Desea crear agenda con tamaño personalizado? (S/N): ");
        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("S")) {
            System.out.print("Ingrese tamaño máximo: ");
            int tamano = scanner.nextInt();
            scanner.nextLine();
            agenda = new Agenda(tamano);
        } else {
            agenda = new Agenda(); // tamaño por defecto 10
        }

        boolean salir = false;

        while (!salir) {
            System.out.println("--- Menú Agenda Telefónica ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Mostrar espacio libre");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            int opcionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMenu) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevo = new Contacto(nombre, apellido, telefono);
                    agenda.añadirContacto(nuevo);
                    break;

                case 2:
                    agenda.listarContactos();
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    System.out.print("Apellido a buscar: ");
                    String apellidoBusqueda = scanner.nextLine();
                    agenda.buscaContacto(nombreBusqueda, apellidoBusqueda);
                    break;

                case 4:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    System.out.print("Apellido del contacto a eliminar: ");
                    String apellidoEliminar = scanner.nextLine();
                    Contacto eliminar = new Contacto(nombreEliminar, apellidoEliminar, "");
                    agenda.eliminarContacto(eliminar);
                    break;

                case 5:
                    System.out.print("Nombre del contacto a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Apellido del contacto a modificar: ");
                    String apellidoModificar = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTel = scanner.nextLine();
                    agenda.modificarTelefono(nombreModificar, apellidoModificar, nuevoTel);
                    break;

                case 6:
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    }
                    break;

                case 7:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();


    }
}
