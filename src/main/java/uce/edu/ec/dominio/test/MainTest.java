package uce.edu.ec.dominio.test;

import uce.edu.ec.dominio.modelo.*;
import java.util.Date;

public class MainTest {
    public static void main(String[] args) {
        // 1. Usuario
        Usuario usuario = new Usuario(1, "jperez", "jperez@uce.edu.ec", "hash123", "ESTUDIANTE");
        System.out.println("Autenticar Usuario: " + usuario.autenticar());

        // 2. Estudiante
        Estudiante estudiante = new Estudiante(2, "mgarcia", "mgarcia@uce.edu.ec", "hash456", 10, "Sistemas", 4);
        estudiante.reportarIncidente();

        // 3. Trabajador
        Trabajador trabajador = new Trabajador(3, "clopez", "clopez@uce.edu.ec", "hash789", 20, "TI", "Analista");
        trabajador.reportarIncidente();

        // 4. Moderador
        Moderador moderador = new Moderador(4, "admin", "admin@uce.edu.ec", "hash000", 1, "TOTAL");
        Incidente incidente = new Incidente(1, new Date(), new Date(), "PENDIENTE", "Fuga", "Agua", "ALTO", 2, 1);
        System.out.println("Validar Incidente: " + moderador.validarIncidente(incidente));

        // 5. GestorDeRiesgo
        GestorDeRiesgo gestor = new GestorDeRiesgo(5, "rgomez", "rgomez@uce.edu.ec", "hash111", 5, "Seguridad", "Jefe", "M1");
        Categoria categoria = new Categoria(1, "Infraestructura", "Danos fisicos");
        System.out.println("Evaluar Riesgo: " + gestor.evaluarNivelRiesgo(incidente));
        gestor.definirGravedadCategoria(categoria, "CRITICO");
        gestor.emitirRecomendacionSeguridad(incidente);

        // 6. Incidente
        incidente.registrar();
        incidente.actualizar();
        System.out.println("Verificar Incidente: " + incidente.verificarIncidente());
        System.out.println("Historico: " + incidente.obtenerHistorico().size());
        incidente.eliminar();

        // 7. Categoria
        categoria.definirGravedad();

        // 8. Ubicacion
        Ubicacion ubicacion = new Ubicacion(1, "Facultad Ingenieria", -0.19, -78.50, "Academica", 1);
        ubicacion.registrarZona();
        ubicacion.actualizarZona();

        // 9. Evidencia
        Evidencia evidencia = new Evidencia(1, 1, "Foto", "evidencia.jpg");
        System.out.println("Verificar Evidencia: " + evidencia.verificar());
        evidencia.adjuntar();

        // 10. Notificacion
        Notificacion notificacion = new Notificacion(1, "Alerta", new Date(), "", 1);
        notificacion.configurarPreferencias();
        notificacion.enviar();

        // 11. Recomendacion
        Recomendacion recomendacion = new Recomendacion(1, "Evacuar", "Salir en orden", 1, "ALTO", true);
        recomendacion.desactivar();
        System.out.println(recomendacion);
    }
}