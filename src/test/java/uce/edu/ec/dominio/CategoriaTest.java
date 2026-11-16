package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {

    @Test
    public void testConstructorVacio() {
        Categoria categoria = new Categoria();

        assertNotNull(categoria);
        assertEquals(0, categoria.getIdCategoria());
        assertNull(categoria.getNombreCategoria());
        assertNull(categoria.getDescripcion());
    }

    @Test
    public void testConstructorConParametros() {
        Categoria categoria = new Categoria(3, "Infraestructura", "Danos en edificios y servicios");

        assertEquals(3, categoria.getIdCategoria());
        assertEquals("Infraestructura", categoria.getNombreCategoria());
        assertEquals("Danos en edificios y servicios", categoria.getDescripcion());
    }

    @Test
    public void testGettersYSetters() {
        Categoria categoria = new Categoria();

        categoria.setIdCategoria(7);
        categoria.setNombreCategoria("Seguridad");
        categoria.setDescripcion("Robos y amenazas");

        assertEquals(7, categoria.getIdCategoria());
        assertEquals("Seguridad", categoria.getNombreCategoria());
        assertEquals("Robos y amenazas", categoria.getDescripcion());
    }

    @Test
    public void testToString() {
        Categoria categoria = new Categoria(3, "Infraestructura", "Danos en edificios y servicios");

        assertEquals("Categoria{id=3, nombre='Infraestructura'}", categoria.toString());
    }
}
