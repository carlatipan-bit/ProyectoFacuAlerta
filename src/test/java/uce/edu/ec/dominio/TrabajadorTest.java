package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrabajadorTest {

    @Test
    public void testConstructorVacio() {
        Trabajador trabajador = new Trabajador();

        assertNotNull(trabajador);
        assertEquals(0, trabajador.getIdUsuario());
        assertEquals(0, trabajador.getIdTrabajador());
        assertNull(trabajador.getDepartamento());
        assertNull(trabajador.getCargo());
    }

    @Test
    public void testConstructorConParametros() {
        Trabajador trabajador = new Trabajador(1, "Carlos", "carlos@uce.edu.ec", "hash123",
                10, "Sistemas", "Tecnico");

        assertEquals(1, trabajador.getIdUsuario());
        assertEquals("Carlos", trabajador.getNombreUsuario());
        assertEquals("carlos@uce.edu.ec", trabajador.getCorreo());
        assertEquals("hash123", trabajador.getContrasenaHash());
        assertEquals("Trabajador", trabajador.getTipoUsuario());
        assertEquals(10, trabajador.getIdTrabajador());
        assertEquals("Sistemas", trabajador.getDepartamento());
        assertEquals("Tecnico", trabajador.getCargo());
    }

    @Test
    public void testGettersYSetters() {
        Trabajador trabajador = new Trabajador();

        trabajador.setIdTrabajador(20);
        trabajador.setDepartamento("Administracion");
        trabajador.setCargo("Coordinador");

        assertEquals(20, trabajador.getIdTrabajador());
        assertEquals("Administracion", trabajador.getDepartamento());
        assertEquals("Coordinador", trabajador.getCargo());
    }

    @Test
    public void testToString() {
        Trabajador trabajador = new Trabajador(1, "Carlos", "carlos@uce.edu.ec", "hash123",
                10, "Sistemas", "Tecnico");

        assertEquals("Usuario{idUsuario=1, nombreUsuario='Carlos', correo='carlos@uce.edu.ec'}"
                        + " Trabajador{idTrabajador=10, departamento='Sistemas', cargo='Tecnico'}",
                trabajador.toString());
        assertFalse(trabajador.toString().contains("hash123"));
    }
}
