package uce.edu.ec.dominio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import uce.edu.ec.dominio.modelo.Incidente;

public class IncidenteTest {

    @Test
    public void testRegistrar() {
        Incidente incidente = new Incidente();
        incidente.registrar();

        assertEquals("PENDIENTE", incidente.getEstado());
        assertNotNull(incidente.getFechaHoraReporte());
        assertNotNull(incidente.getFechaHoraActualizacion());
    }

    @Test
    public void testActualizarYHistorico() {
        Incidente incidente = new Incidente(1, new Date(), new Date(), "PENDIENTE", "Robo", "Asalto en la zona", "ALTO", 101, 2);
        incidente.actualizar();

        assertEquals(1, incidente.obtenerHistorico().size());
        assertEquals("Robo", incidente.obtenerHistorico().get(0).getTitulo());
    }

    @Test
    public void testEliminar() {
        Incidente incidente = new Incidente();
        incidente.eliminar();

        assertEquals("ELIMINADO", incidente.getEstado());
        assertNotNull(incidente.getFechaHoraActualizacion());
    }

    @Test
    public void testVerificarIncidenteValido() {
        Incidente incidente = new Incidente(1, new Date(), new Date(), "PENDIENTE", "Incendio", "Fuego en laboratorios", "MEDIO", 101, 1);
        assertTrue(incidente.verificarIncidente());
    }

    @Test
    public void testVerificarIncidenteInvalido() {
        Incidente incidente = new Incidente();
        incidente.setTitulo("");
        incidente.setDescripcion("");
        incidente.setNivelGravedad(null);

        assertFalse(incidente.verificarIncidente());
    }
}