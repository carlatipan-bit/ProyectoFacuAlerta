package uce.edu.ec.dominio.consola;

import uce.edu.ec.dominio.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubMenu {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Incidente> incidentes = new ArrayList<>();
    private static final List<Evidencia> evidencias = new ArrayList<>();
    private static final List<Categoria> categorias = new ArrayList<>();
    private static final List<Ubicacion> ubicaciones = new ArrayList<>();
    private static final List<Recomendacion> recomendaciones = new ArrayList<>();

    static {
        usuarios.add(new Moderador(1, "admin", "admin@uce.edu.ec", "1234", 1, "TOTAL"));
    }

    // Valida texto no vacío sin regresar al menú
    private static String leerCampoObligatorio(Scanner scanner, String etiqueta, String mensajeError) {
        String valor;
        while (true) {
            System.out.print(etiqueta);
            valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println(mensajeError);
        }
    }

    // Valida números enteros sin que el programa se caiga con letras
    private static int leerEnteroObligatorio(Scanner scanner, String etiqueta, String mensajeError) {
        while (true) {
            System.out.print(etiqueta);
            String entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty() && entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }
            System.out.println(mensajeError);
        }
    }

    // Valida formato básico de correo institucional
    private static String leerCorreoValido(Scanner scanner, String etiqueta) {
        while (true) {
            String correo = leerCampoObligatorio(scanner, etiqueta, "Completar campos");
            if (correo.contains("@") && correo.contains(".")) {
                return correo;
            }
            System.out.println("Formato de correo invalido, intente de nuevo.");
        }
    }

    // Valida nivel de gravedad/peligro
    private static String leerNivelValido(Scanner scanner, String etiqueta) {
        while (true) {
            String nivel = leerCampoObligatorio(scanner, etiqueta, "Completar campos").toUpperCase();
            if (nivel.equals("BAJO") || nivel.equals("MEDIO") || nivel.equals("ALTO")) {
                return nivel;
            }
            System.out.println("Nivel no valido. Debe ingresar BAJO, MEDIO o ALTO.");
        }
    }

    // ================= H1: INICIAR SESION =================
    public static boolean subMenuIniciarSesion(Scanner scanner) {
        System.out.println("\n--- H1: INICIAR SESION ---");
        while (true) {
            String correo = leerCampoObligatorio(scanner, "Ingrese correo (o '0' para volver): ", "Ingrese los campos validos");
            if (correo.equals("0")) return false;
            String clave = leerCampoObligatorio(scanner, "Ingrese contrasena: ", "Ingrese los campos validos");

            for (Usuario u : usuarios) {
                if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasenaHash().equals(clave)) {
                    System.out.println("Inicio de sesion exitoso");
                    return true;
                }
            }
            System.out.println("Usuario o contrasena incorrectos");
        }
    }

    // ================= H2: GESTIONAR USUARIOS =================
    public static void subMenuGestionarUsuarios(Scanner scanner) {
        int op;
        do {
            System.out.println("\n--- H2: GESTIONAR USUARIOS ---");
            System.out.println("1. Anadir Usuario (H2.1)");
            System.out.println("2. Deshabilitar Usuario (H2.2)");
            System.out.println("3. Buscar Usuario (H2.3)");
            System.out.println("4. Modificar Usuario (H2.4)");
            System.out.println("0. Volver");
            op = leerEnteroObligatorio(scanner, "Opcion: ", "Ingrese los campos validos");

            switch (op) {
                case 1:
                    String nombre = leerCampoObligatorio(scanner, "Nombre: ", "Completar campos");
                    String correo = leerCorreoValido(scanner, "Correo: ");
                    String pass = leerCampoObligatorio(scanner, "Contrasena: ", "Completar campos");
                    if (usuarios.stream().anyMatch(u -> u.getCorreo().equalsIgnoreCase(correo))) {
                        System.out.println("Correo registrado");
                    } else {
                        Usuario nuevo = new Usuario(usuarios.size() + 1, nombre, correo, pass, "ESTUDIANTE");
                        usuarios.add(nuevo);
                        System.out.println("Correo registrado exitosamente. ID asignado: " + nuevo.getIdUsuario());
                    }
                    break;
                case 2:
                    String correoDes = leerCampoObligatorio(scanner, "Correo a deshabilitar: ", "Completar campos");
                    if (usuarios.removeIf(u -> u.getCorreo().equalsIgnoreCase(correoDes))) {
                        System.out.println("Cuenta deshabilitada");
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 3:
                    String b = leerCampoObligatorio(scanner, "Correo a buscar: ", "Ingrese los campos validos");
                    Usuario encontradoBus = usuarios.stream()
                            .filter(u -> u.getCorreo().equalsIgnoreCase(b))
                            .findFirst()
                            .orElse(null);
                    if (encontradoBus != null) {
                        System.out.println(encontradoBus);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 4:
                    String mod = leerCampoObligatorio(scanner, "Correo a modificar: ", "Completar campos");
                    boolean encontradoMod = false;
                    for (Usuario u : usuarios) {
                        if (u.getCorreo().equalsIgnoreCase(mod)) {
                            u.setNombreUsuario(leerCampoObligatorio(scanner, "Nuevo nombre: ", "Completar campos"));
                            System.out.println("Guardado exitosamente");
                            encontradoMod = true;
                            break;
                        }
                    }
                    if (!encontradoMod) {
                        System.out.println("Usuario no encontrado, ingrese un correo valido.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    // ================= H3: GESTIONAR INCIDENTE =================
    public static void subMenuGestionarIncidente(Scanner scanner) {
        int op;
        do {
            System.out.println("\n--- H3: GESTIONAR INCIDENTE ---");
            System.out.println("1. Registrar nuevo incidente con facultad (H3.1)");
            System.out.println("2. Eliminar reporte (H3.2)");
            System.out.println("3. Modificar incidente y gravedad (H3.3)");
            System.out.println("4. Buscar incidente por ID (H3.4)");
            System.out.println("5. Enviar alerta (H3.5)");
            System.out.println("0. Volver");
            op = leerEnteroObligatorio(scanner, "Opcion: ", "Ingrese los campos validos");

            switch (op) {
                case 1:
                    String titulo = leerCampoObligatorio(scanner, "Titulo: ", "Datos deben corregirse: complete el titulo");
                    String desc = leerCampoObligatorio(scanner, "Descripcion: ", "Datos deben corregirse: complete la descripcion");
                    String gravedad = leerNivelValido(scanner, "Gravedad (BAJO/MEDIO/ALTO): ");
                    String facultad = leerCampoObligatorio(scanner, "Facultad donde ocurrio el incidente: ", "Datos deben corregirse: complete la facultad");
                    int idCat = leerEnteroObligatorio(scanner, "ID de Categoria asociada: ", "Ingrese un ID numerico valido");

                    Incidente inc = new Incidente();
                    inc.setIdIncidente(incidentes.size() + 1);
                    inc.setTitulo(titulo + " [" + facultad + "]");
                    inc.setDescripcion(desc);
                    inc.setNivelGravedad(gravedad);
                    inc.setIdUsuarioReporta(1);
                    inc.setIdCategoria(idCat);
                    inc.registrar();
                    incidentes.add(inc);
                    System.out.println("Confirmacion: Incidente registrado exitosamente en la facultad " + facultad + " con ID: " + inc.getIdIncidente());
                    break;
                case 2:
                    int idElim = leerEnteroObligatorio(scanner, "ID del incidente a eliminar: ", "Ingrese los campos validos");
                    boolean encElim = false;
                    for (Incidente i : incidentes) {
                        if (i.getIdIncidente() == idElim) {
                            i.eliminar();
                            System.out.println("Reporte marcado como eliminado: " + i);
                            encElim = true;
                            break;
                        }
                    }
                    if (!encElim) System.out.println("Incidente no encontrado.");
                    break;
                case 3:
                    int idEdit = leerEnteroObligatorio(scanner, "ID del incidente a modificar: ", "Ingrese los campos validos");
                    boolean encEdit = false;
                    for (Incidente i : incidentes) {
                        if (i.getIdIncidente() == idEdit) {
                            i.actualizar();
                            i.setTitulo(leerCampoObligatorio(scanner, "Nuevo titulo: ", "Completar campos"));
                            i.setDescripcion(leerCampoObligatorio(scanner, "Nueva descripcion: ", "Completar campos"));
                            i.setNivelGravedad(leerNivelValido(scanner, "Nueva gravedad (BAJO, MEDIO, ALTO): "));
                            System.out.println("Guardado exitosamente");
                            encEdit = true;
                            break;
                        }
                    }
                    if (!encEdit) System.out.println("Incidente no encontrado.");
                    break;
                case 4:
                    int idBus = leerEnteroObligatorio(scanner, "Ingrese el ID del incidente a buscar: ", "Ingrese los campos validos");
                    boolean encontrado = false;
                    for (Incidente i : incidentes) {
                        if (i.getIdIncidente() == idBus) {
                            System.out.println(i);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Incidente no encontrado con ese ID.");
                    }
                    break;
                case 5:
                    int idIncAlerta = leerEnteroObligatorio(scanner, "ID del incidente para enviar alerta: ", "Ingrese un ID valido");
                    Notificacion n = new Notificacion(1, "Alerta de incidente #" + idIncAlerta, null, "URGENTE", idIncAlerta);
                    n.enviar();
                    System.out.println("Alerta enviada: " + n);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    // ================= H4: GESTIONAR EVIDENCIAS =================
    public static void subMenuGestionarEvidencias(Scanner scanner) {
        int op;
        do {
            System.out.println("\n--- H4: GESTIONAR EVIDENCIAS ---");
            System.out.println("1. Adjuntar fotografia (H4.1)");
            System.out.println("2. Verificar evidencia (H4.2)");
            System.out.println("3. Buscar evidencia por ID de Incidente (H4.3)");
            System.out.println("0. Volver");
            op = leerEnteroObligatorio(scanner, "Opcion: ", "Ingrese los campos validos");

            switch (op) {
                case 1:
                    int idInc = leerEnteroObligatorio(scanner, "ID del incidente: ", "El sistema solicita seleccionar incidente, no guarda evidencia");
                    if (incidentes.stream().noneMatch(i -> i.getIdIncidente() == idInc)) {
                        System.out.println("El sistema solicita seleccionar incidente valido, no guarda evidencia.");
                        break;
                    }
                    String url;
                    while (true) {
                        url = leerCampoObligatorio(scanner, "Archivo (.jpg/.png): ", "Ingrese un archivo valido");
                        if (url.toLowerCase().endsWith(".jpg") || url.toLowerCase().endsWith(".png")) {
                            break;
                        }
                        System.out.println("Archivo incompatible, intente de nuevo");
                    }
                    Evidencia ev = new Evidencia(evidencias.size() + 1, idInc, "Imagen", url);
                    ev.adjuntar();
                    evidencias.add(ev);
                    System.out.println("Cargado exitosamente");
                    break;
                case 2:
                    if (evidencias.isEmpty()) {
                        System.out.println("No existen evidencias registradas para verificar.");
                    } else {
                        evidencias.forEach(e -> System.out.println(e + " -> Verificacion registrada: " + e.verificar()));
                    }
                    break;
                case 3:
                    int idBusEv = leerEnteroObligatorio(scanner, "Ingrese el ID del incidente para buscar su evidencia: ", "Ingrese los campos validos");
                    boolean hayEv = false;
                    for (Evidencia evObj : evidencias) {
                        if (evObj.getIdIncidente() == idBusEv) {
                            System.out.println(evObj);
                            hayEv = true;
                        }
                    }
                    if (!hayEv) System.out.println("No hay evidencias para ese ID de incidente.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    // ================= H5: GESTIONAR CATEGORIAS =================
    public static void subMenuGestionarCategorias(Scanner scanner) {
        int op;
        do {
            System.out.println("\n--- H5: GESTIONAR CATEGORIAS ---");
            System.out.println("1. Crear categoria (H5.1)");
            System.out.println("2. Eliminar categoria (H5.2)");
            System.out.println("3. Buscar categoria por ID (H5.3)");
            System.out.println("0. Volver");
            op = leerEnteroObligatorio(scanner, "Opcion: ", "Ingrese los campos validos");

            switch (op) {
                case 1:
                    String nom = leerCampoObligatorio(scanner, "Nombre: ", "Completar campos");
                    String desc = leerCampoObligatorio(scanner, "Descripcion: ", "Completar campos");
                    if (categorias.stream().anyMatch(c -> c.getNombreCategoria().equalsIgnoreCase(nom))) {
                        System.out.println("Sistema indica el error: la categoria ya existe y no se registra.");
                    } else {
                        Categoria c = new Categoria(categorias.size() + 1, nom, desc);
                        categorias.add(c);
                        System.out.println("Categoria registrada exitosamente: " + c);
                        categorias.forEach(System.out::println);
                    }
                    break;
                case 2:
                    int idC = leerEnteroObligatorio(scanner, "ID de categoria a eliminar: ", "Ingrese los campos validos");
                    boolean asoc = incidentes.stream().anyMatch(i -> i.getIdCategoria() == idC);
                    if (asoc) {
                        System.out.println("Advertencia: La categoria esta asociada a incidentes existentes. No se elimino para evitar perdida de reportes.");
                    } else if (categorias.removeIf(c -> c.getIdCategoria() == idC)) {
                        System.out.println("Categoria eliminada/desactivada.");
                    } else {
                        System.out.println("Categoria no encontrada.");
                    }
                    break;
                case 3:
                    int idBuscCat = leerEnteroObligatorio(scanner, "Ingrese el ID de la categoria a buscar: ", "Ingrese los campos validos");
                    boolean encontradaCat = false;
                    for (Categoria catObj : categorias) {
                        if (catObj.getIdCategoria() == idBuscCat) {
                            System.out.println(catObj);
                            encontradaCat = true;
                            break;
                        }
                    }
                    if (!encontradaCat) {
                        System.out.println("Categoria no encontrada con ese ID.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    // ================= H6: GESTIONAR UBICACIONES =================
    public static void subMenuGestionarUbicaciones(Scanner scanner) {
        int op;
        do {
            System.out.println("\n--- H6: GESTIONAR UBICACIONES ---");
            System.out.println("1. Registrar zona (H6.1)");
            System.out.println("2. Actualizar zona (H6.2)");
            System.out.println("3. Anadir facultad (H6.3)");
            System.out.println("4. Buscar zona por ID (H6.4)");
            System.out.println("0. Volver");
            op = leerEnteroObligatorio(scanner, "Opcion: ", "Ingrese los campos validos");

            switch (op) {
                case 1:
                case 3:
                    String zona = leerCampoObligatorio(scanner, "Nombre de la zona/facultad: ", "El sistema solicita llenar los campos obligatorios");
                    String tipo = leerCampoObligatorio(scanner, "Tipo de zona: ", "El sistema solicita llenar los campos obligatorios");
                    if (ubicaciones.stream().anyMatch(u -> u.getNombreZona().equalsIgnoreCase(zona))) {
                        System.out.println("El sistema informa que la zona ya existe");
                    } else {
                        int nuevoId = ubicaciones.size() + 1;
                        Ubicacion ub = new Ubicacion(nuevoId, zona, -0.19, -78.50, tipo, 1);
                        ub.registrarZona();
                        ubicaciones.add(ub);
                        System.out.println("Zona guardada con exito. ID generado automaticamente: " + nuevoId);
                        System.out.println(ub);
                    }
                    break;
                case 2:
                    int idU = leerEnteroObligatorio(scanner, "ID de zona a actualizar: ", "Ingrese los campos validos");
                    boolean encZ = false;
                    for (Ubicacion u : ubicaciones) {
                        if (u.getIdUbicacion() == idU) {
                            u.setNombreZona(leerCampoObligatorio(scanner, "Nuevo nombre: ", "El sistema solicita llenar los campos obligatorios"));
                            u.setTipoZona(leerCampoObligatorio(scanner, "Nuevo tipo de zona: ", "El sistema solicita llenar los campos obligatorios"));
                            u.actualizarZona();
                            encZ = true;
                            break;
                        }
                    }
                    if (!encZ) System.out.println("Zona no encontrada.");
                    break;
                case 4:
                    int idBusZ = leerEnteroObligatorio(scanner, "Ingrese el ID de la zona a buscar: ", "Ingrese los campos validos");
                    boolean encontradaZ = false;
                    for (Ubicacion ubObj : ubicaciones) {
                        if (ubObj.getIdUbicacion() == idBusZ) {
                            System.out.println(ubObj);
                            encontradaZ = true;
                            break;
                        }
                    }
                    if (!encontradaZ) {
                        System.out.println("Zona no encontrada con ese ID.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    // ================= H7: GESTIONAR RECOMENDACIONES =================
    public static void subMenuGestionarRecomendaciones(Scanner scanner) {
        int op;
        do {
            System.out.println("\n--- H7: GESTIONAR RECOMENDACIONES ---");
            System.out.println("1. Consultar recomendacion (H7.1)");
            System.out.println("2. Modificar recomendacion (H7.2)");
            System.out.println("3. Desactivar recomendacion (H7.3)");
            System.out.println("4. Buscar recomendacion por ID (H7.4)");
            System.out.println("5. Anadir recomendacion (H7.5)");
            System.out.println("0. Volver");
            op = leerEnteroObligatorio(scanner, "Opcion: ", "Ingrese los campos validos");

            switch (op) {
                case 5:
                    String tit = leerCampoObligatorio(scanner, "Titulo: ", "Complete los campos obligatorios");
                    String des = leerCampoObligatorio(scanner, "Descripcion: ", "Complete los campos obligatorios");
                    String niv = leerNivelValido(scanner, "Nivel de peligro (BAJO/MEDIO/ALTO): ");
                    int catId = leerEnteroObligatorio(scanner, "ID Categoria: ", "Complete los campos obligatorios");

                    boolean duplicada = recomendaciones.stream().anyMatch(r ->
                            r.getIdCategoria() == catId && r.getNivelPeligro().equalsIgnoreCase(niv));
                    if (duplicada) {
                        System.out.println("Advertencia de posible duplicidad: ya existe una recomendacion equivalente para esa categoria y nivel de peligro.");
                    } else {
                        Recomendacion nuevaRec = new Recomendacion(recomendaciones.size() + 1, tit, des, catId, niv, true);
                        recomendaciones.add(nuevaRec);
                        System.out.println("Recomendacion creada con exito:");
                        System.out.println(nuevaRec);
                    }
                    break;
                case 2:
                    while (true) {
                        int idMod = leerEnteroObligatorio(scanner, "ID Recomendacion a modificar (o 0 para cancelar): ", "Ingrese los campos validos");
                        if (idMod == 0) break;
                        Recomendacion recMod = recomendaciones.stream()
                                .filter(r -> r.getIdRecomendacion() == idMod)
                                .findFirst()
                                .orElse(null);
                        if (recMod != null) {
                            recMod.setTitulo(leerCampoObligatorio(scanner, "Nuevo titulo: ", "Ingrese los campos validos"));
                            recMod.setDescripcion(leerCampoObligatorio(scanner, "Nueva descripcion: ", "Ingrese los campos validos"));
                            recMod.setIdCategoria(leerEnteroObligatorio(scanner, "Nueva ID Categoria: ", "Ingrese los campos validos"));
                            recMod.setNivelPeligro(leerNivelValido(scanner, "Nuevo nivel de peligro (BAJO/MEDIO/ALTO): "));
                            System.out.println("Informacion actualizada y guardada correctamente.");
                            break;
                        } else {
                            System.out.println("Recomendacion inexistente, ingrese otro ID");
                        }
                    }
                    break;
                case 3:
                    int idDes = leerEnteroObligatorio(scanner, "ID Recomendacion a desactivar: ", "Ingrese los campos validos");
                    boolean encDes = false;
                    for (Recomendacion r : recomendaciones) {
                        if (r.getIdRecomendacion() == idDes) {
                            r.desactivar();
                            System.out.println("Recomendacion cambiada a estado inactivo conservando el registro.");
                            encDes = true;
                            break;
                        }
                    }
                    if (!encDes) System.out.println("Recomendacion inexistente, ingrese otro ID");
                    break;
                case 4:
                    int idBusRec = leerEnteroObligatorio(scanner, "Ingrese el ID de la recomendacion a buscar: ", "Ingrese los campos validos");
                    boolean encBus = false;
                    for (Recomendacion r : recomendaciones) {
                        if (r.getIdRecomendacion() == idBusRec) {
                            System.out.println(r);
                            encBus = true;
                            break;
                        }
                    }
                    if (!encBus) {
                        System.out.println("Recomendacion inexistente, ingrese otro ID");
                    }
                    break;
                case 1:
                    recomendaciones.stream().filter(Recomendacion::isActiva).forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }
}