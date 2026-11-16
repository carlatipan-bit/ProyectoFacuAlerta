package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModeradorTest {

    @Test
    public void testConstructorVacio() {
        Moderador moderador = new Moderador();

        assertNotNull(moderador);
        assertEquals(0, moderador.getIdUsuario());
        assertEquals(0, moderador.getIdModerador());
        assertNull(moderador.getPermisos());
    }

    @Test
    public void testConstructorConParametros() {
        Moderador moderador = new Moderador(2, "Maria", "maria@uce.edu.ec", "hash456",
                15, "Administrar incidentes");

        assertEquals(2, moderador.getIdUsuario());
        assertEquals("Maria", moderador.getNombreUsuario());
        assertEquals("maria@uce.edu.ec", moderador.getCorreo());
        assertEquals("hash456", moderador.getContrasenaHash());
        assertEquals("Moderador", moderador.getTipoUsuario());
        assertEquals(15, moderador.getIdModerador());
        assertEquals("Administrar incidentes", moderador.getPermisos());
    }

    @Test
    public void testGettersYSetters() {
        Moderador moderador = new Moderador();

        moderador.setIdModerador(25);
        moderador.setPermisos("Validar reportes");

        assertEquals(25, moderador.getIdModerador());
        assertEquals("Validar reportes", moderador.getPermisos());
    }

    @Test
    public void testToString() {
        Moderador moderador = new Moderador(2, "Maria", "maria@uce.edu.ec", "hash456",
                15, "Administrar incidentes");

        assertEquals("Usuario{idUsuario=2, nombreUsuario='Maria', correo='maria@uce.edu.ec'}"
                        + " Moderador{idModerador=15, permisos='Administrar incidentes'}",
                moderador.toString());
        assertFalse(moderador.toString().contains("hash456"));
    }
}

