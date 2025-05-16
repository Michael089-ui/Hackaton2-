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
            int tam = scanner.nextInt();
            scanner.nextLine();
            agenda = new Agenda(tam);
        } else {
            agenda = new Agenda();
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
                    int telefono = Integer.parseInt(scanner.nextLine());
                    Contacto nuevo = new Contacto(nombre, apellido, telefono);
//                    agenda.agregarContacto(nuevo);
                    break;

                case 2:
                    agenda.listarContactos();
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nombreBusq = scanner.nextLine();
                    System.out.print("Apellido a buscar: ");
                    String apellidoBusq = scanner.nextLine();
                    agenda.buscarContacto(nombreBusq, apellidoBusq);
                    break;

                case 4:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreElim = scanner.nextLine();
                    System.out.print("Apellido del contacto a eliminar: ");
                    String apellidoElim = scanner.nextLine();
//                    Contacto eliminar = new Contacto(nombreElim, apellidoElim, "");
//                    agenda.eliminarContacto(eliminar);
                    break;

                case 5:
                    System.out.print("Nombre del contacto a modificar: ");
                    String nombreMod = scanner.nextLine();
                    System.out.print("Apellido del contacto a modificar: ");
                    String apellidoMod = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    int nuevoTel = scanner.nextInt();
                    scanner.nextLine();
                    agenda.modificarTelefono(nombreMod, apellidoMod, nuevoTel);
                    break;

                case 6:
                    agenda.espaciosLibres();
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
