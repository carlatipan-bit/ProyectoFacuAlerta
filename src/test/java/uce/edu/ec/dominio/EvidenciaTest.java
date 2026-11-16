package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvidenciaTest {

    @Test
    public void testConstructorVacio() {
        Evidencia evidencia = new Evidencia();

        assertNotNull(evidencia);
        assertEquals(0, evidencia.getIdEvidencia());
        assertEquals(0, evidencia.getIdIncidente());
        assertNull(evidencia.getTipoEvidencia());
        assertNull(evidencia.getUrlArchivo());
    }

    @Test
    public void testConstructorConParametros() {
        Evidencia evidencia = new Evidencia(1, 10, "Imagen", "https://ejemplo.com/foto.jpg");

        assertEquals(1, evidencia.getIdEvidencia());
        assertEquals(10, evidencia.getIdIncidente());
        assertEquals("Imagen", evidencia.getTipoEvidencia());
        assertEquals("https://ejemplo.com/foto.jpg", evidencia.getUrlArchivo());
    }

    @Test
    public void testGettersYSetters() {
        Evidencia evidencia = new Evidencia();

        evidencia.setIdEvidencia(5);
        evidencia.setIdIncidente(20);
        evidencia.setTipoEvidencia("Video");
        evidencia.setUrlArchivo("https://ejemplo.com/video.mp4");

        assertEquals(5, evidencia.getIdEvidencia());
        assertEquals(20, evidencia.getIdIncidente());
        assertEquals("Video", evidencia.getTipoEvidencia());
        assertEquals("https://ejemplo.com/video.mp4", evidencia.getUrlArchivo());
    }

    @Test
    public void testToString() {
        Evidencia evidencia = new Evidencia(1, 10, "Imagen", "https://ejemplo.com/foto.jpg");

        assertEquals("Evidencia{id=1, tipo='Imagen'}", evidencia.toString());
    }
}
