package uce.edu.ec.dominio.consola;

import java.util.Scanner;

public class Menu {
    private static boolean sesionIniciada = false;

    public static void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n=============================================");
            System.out.println("   SISTEMA FACUALERTA - MENU PRINCIPAL (N0)  ");
            System.out.println("=============================================");
            System.out.println("1. Iniciar sesion (H1)");
            System.out.println("2. Gestionar usuarios (H2)");
            System.out.println("3. Gestionar incidente (H3)");
            System.out.println("4. Gestionar evidencias (H4)");
            System.out.println("5. Gestionar categorias (H5)");
            System.out.println("6. Gestionar ubicaciones (H6)");
            System.out.println("7. Gestionar recomendaciones (H7)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty() || !entrada.matches("\\d+")) {
                System.out.println("Ingrese una opcion valida.");
                continue;
            }
            opcion = Integer.parseInt(entrada);

            if (opcion >= 2 && opcion <= 7 && !sesionIniciada) {
                System.out.println("Inicie sesion");
                continue;
            }

            switch (opcion) {
                case 1:
                    sesionIniciada = SubMenu.subMenuIniciarSesion(scanner);
                    break;
                case 2:
                    SubMenu.subMenuGestionarUsuarios(scanner);
                    break;
                case 3:
                    SubMenu.subMenuGestionarIncidente(scanner);
                    break;
                case 4:
                    SubMenu.subMenuGestionarEvidencias(scanner);
                    break;
                case 5:
                    SubMenu.subMenuGestionarCategorias(scanner);
                    break;
                case 6:
                    SubMenu.subMenuGestionarUbicaciones(scanner);
                    break;
                case 7:
                    SubMenu.subMenuGestionarRecomendaciones(scanner);
                    break;
                case 0:
                    System.out.println("Cerrando el sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}