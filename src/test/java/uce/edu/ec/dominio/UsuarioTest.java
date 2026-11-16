package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testConstructorVacio() {
        Usuario usuario = new Usuario();

        assertNotNull(usuario);
        assertEquals(0, usuario.getIdUsuario());
        assertNull(usuario.getNombreUsuario());
        assertNull(usuario.getCorreo());
        assertNull(usuario.getContrasenaHash());
        assertNull(usuario.getTipoUsuario());
    }

    @Test
    public void testConstructorConParametros() {
        Usuario usuario = new Usuario(1, "Carlos", "carlos@uce.edu.ec", "hash123", "Estudiante");

        assertEquals(1, usuario.getIdUsuario());
        assertEquals("Carlos", usuario.getNombreUsuario());
        assertEquals("carlos@uce.edu.ec", usuario.getCorreo());
        assertEquals("hash123", usuario.getContrasenaHash());
        assertEquals("Estudiante", usuario.getTipoUsuario());
    }

    @Test
    public void testGettersYSetters() {
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(2);
        usuario.setNombreUsuario("Maria");
        usuario.setCorreo("maria@uce.edu.ec");
        usuario.setContrasenaHash("hash456");
        usuario.setTipoUsuario("Trabajador");

        assertEquals(2, usuario.getIdUsuario());
        assertEquals("Maria", usuario.getNombreUsuario());
        assertEquals("maria@uce.edu.ec", usuario.getCorreo());
        assertEquals("hash456", usuario.getContrasenaHash());
        assertEquals("Trabajador", usuario.getTipoUsuario());
    }

    @Test
    public void testToString() {
        Usuario usuario = new Usuario(1, "Carlos", "carlos@uce.edu.ec", "hash123", "Estudiante");

        assertEquals("Usuario{idUsuario=1, nombreUsuario='Carlos', correo='carlos@uce.edu.ec'}",
                usuario.toString());
        assertFalse(usuario.toString().contains("hash123"));
    }
}
