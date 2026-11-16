package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UbicacionTest {

    @Test
    public void testConstructorVacio() {
        Ubicacion ubicacion = new Ubicacion();

        assertNotNull(ubicacion);
        assertEquals(0, ubicacion.getIdUbicacion());
        assertNull(ubicacion.getNombreZona());
        assertEquals(0.0, ubicacion.getLatitud(), 0.0001);
        assertEquals(0.0, ubicacion.getLongitud(), 0.0001);
        assertNull(ubicacion.getTipoZona());
        assertEquals(0, ubicacion.getIdIncidente());
    }

    @Test
    public void testConstructorConParametros() {
        Ubicacion ubicacion = new Ubicacion(1, "Quito", -0.1807, -78.4678, "Urbana", 10);

        assertEquals(1, ubicacion.getIdUbicacion());
        assertEquals("Quito", ubicacion.getNombreZona());
        assertEquals(-0.1807, ubicacion.getLatitud(), 0.0001);
        assertEquals(-78.4678, ubicacion.getLongitud(), 0.0001);
        assertEquals("Urbana", ubicacion.getTipoZona());
        assertEquals(10, ubicacion.getIdIncidente());
    }

    @Test
    public void testGettersYSetters() {
        Ubicacion ubicacion = new Ubicacion();

        ubicacion.setIdUbicacion(4);
        ubicacion.setNombreZona("Calderon");
        ubicacion.setLatitud(-0.0833);
        ubicacion.setLongitud(-78.4167);
        ubicacion.setTipoZona("Rural");
        ubicacion.setIdIncidente(30);

        assertEquals(4, ubicacion.getIdUbicacion());
        assertEquals("Calderon", ubicacion.getNombreZona());
        assertEquals(-0.0833, ubicacion.getLatitud(), 0.0001);
        assertEquals(-78.4167, ubicacion.getLongitud(), 0.0001);
        assertEquals("Rural", ubicacion.getTipoZona());
        assertEquals(30, ubicacion.getIdIncidente());
    }

    @Test
    public void testToString() {
        Ubicacion ubicacion = new Ubicacion(1, "Quito", -0.1807, -78.4678, "Urbana", 10);

        assertEquals("Ubicacion{zona='Quito'}", ubicacion.toString());
    }
}
