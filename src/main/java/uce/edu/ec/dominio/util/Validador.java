package uce.edu.ec.dominio.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

public class Validador {
    private static final Pattern PATRON_CORREO_UCE =
            Pattern.compile("^[A-Za-z0-9._%+-]+@uce\\.edu\\.ec$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATRON_GRAVEDAD =
            Pattern.compile("^(BAJO|MEDIO|ALTO|CRITICO)$", Pattern.CASE_INSENSITIVE);
    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm").withResolverStyle(ResolverStyle.STRICT);

    public static boolean esVacia(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean esCorreoInstitucionalValido(String correo) {
        if (esVacia(correo)) return false;
        return PATRON_CORREO_UCE.matcher(correo.trim()).matches();
    }

    public static boolean esNivelGravedadValido(String gravedad) {
        if (esVacia(gravedad)) return false;
        return PATRON_GRAVEDAD.matcher(gravedad.trim()).matches();
    }

    // Formato esperado: yyyy-MM-dd HH:mm, y además debe ser una fecha real (rechaza 2026-13-45 99:99)
    public static boolean esFechaHoraValida(String fechaHora) {
        if (esVacia(fechaHora)) return false;
        try {
            LocalDateTime.parse(fechaHora.trim(), FORMATO_FECHA);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean esOpcionValida(int opcion, int min, int max) {
        return opcion >= min && opcion <= max;
    }
}