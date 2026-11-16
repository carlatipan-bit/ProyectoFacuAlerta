package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorDeRiesgoTest {

    @Test
    public void testConstructorVacio() {
        GestorDeRiesgo gestor = new GestorDeRiesgo();

        assertNotNull(gestor);
        assertEquals(0, gestor.getIdUsuario());
        assertEquals(0, gestor.getIdGestorRiesgo());
        assertNull(gestor.getDepartamento());
        assertNull(gestor.getCargoInstitucional());
        assertNull(gestor.getMatrizEvaluacion());
    }

    @Test
    public void testConstructorConParametros() {
        GestorDeRiesgo gestor = new GestorDeRiesgo(1, "CarlosP", "carlos.perez@uce.edu.ec", "hash12345",
                100, "Seguridad Ocupacional", "Coordinador de Riesgos", "Matriz_2026_v1");

        assertEquals(1, gestor.getIdUsuario());
        assertEquals("CarlosP", gestor.getNombreUsuario());
        assertEquals("carlos.perez@uce.edu.ec", gestor.getCorreo());
        assertEquals("hash12345", gestor.getContrasenaHash());
        assertEquals("GESTOR_RIESGO", gestor.getTipoUsuario());
        assertEquals(100, gestor.getIdGestorRiesgo());
        assertEquals("Seguridad Ocupacional", gestor.getDepartamento());
        assertEquals("Coordinador de Riesgos", gestor.getCargoInstitucional());
        assertEquals("Matriz_2026_v1", gestor.getMatrizEvaluacion());
    }

    @Test
    public void testGettersYSetters() {
        GestorDeRiesgo gestor = new GestorDeRiesgo();

        gestor.setIdGestorRiesgo(50);
        gestor.setDepartamento("Gestion Ambiental");
        gestor.setCargoInstitucional("Analista de Riesgos");
        gestor.setMatrizEvaluacion("Matriz_Ambiental_2026");

        assertEquals(50, gestor.getIdGestorRiesgo());
        assertEquals("Gestion Ambiental", gestor.getDepartamento());
        assertEquals("Analista de Riesgos", gestor.getCargoInstitucional());
        assertEquals("Matriz_Ambiental_2026", gestor.getMatrizEvaluacion());
    }

    @Test
    public void testToString() {
        GestorDeRiesgo gestor = new GestorDeRiesgo(2, "AnaG", "ana.gomez@uce.edu.ec", "hash987",
                205, "Infraestructura", "Especialista", "Matriz_Infra_v2");

        assertEquals("Usuario{idUsuario=2, nombreUsuario='AnaG', correo='ana.gomez@uce.edu.ec'}"
                        + " GestorDeRiesgo{idGestorRiesgo=205, departamento='Infraestructura',"
                        + " cargoInstitucional='Especialista', matriz='Matriz_Infra_v2'}",
                gestor.toString());
        assertFalse(gestor.toString().contains("hash987"));
    }
}
