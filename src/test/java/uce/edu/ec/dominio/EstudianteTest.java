package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {

    @Test
    public void testConstructorVacio() {
        Estudiante estudiante = new Estudiante();

        assertNotNull(estudiante);
        assertEquals(0, estudiante.getIdUsuario());
        assertEquals(0, estudiante.getIdEstudiante());
        assertNull(estudiante.getCarrera());
        assertEquals(0, estudiante.getSemestre());
    }

    @Test
    public void testConstructorConParametros() {
        Estudiante estudiante = new Estudiante(1, "jperez", "jperez@uce.edu.ec", "hash123",
                10, "Ingenieria en Sistemas", 5);

        assertEquals(1, estudiante.getIdUsuario());
        assertEquals("jperez", estudiante.getNombreUsuario());
        assertEquals("jperez@uce.edu.ec", estudiante.getCorreo());
        assertEquals("hash123", estudiante.getContrasenaHash());
        assertEquals("ESTUDIANTE", estudiante.getTipoUsuario());
        assertEquals(10, estudiante.getIdEstudiante());
        assertEquals("Ingenieria en Sistemas", estudiante.getCarrera());
        assertEquals(5, estudiante.getSemestre());
    }

    @Test
    public void testGettersYSetters() {
        Estudiante estudiante = new Estudiante();

        estudiante.setIdEstudiante(20);
        estudiante.setCarrera("Medicina");
        estudiante.setSemestre(8);

        assertEquals(20, estudiante.getIdEstudiante());
        assertEquals("Medicina", estudiante.getCarrera());
        assertEquals(8, estudiante.getSemestre());
    }

    @Test
    public void testToString() {
        Estudiante estudiante = new Estudiante(1, "jperez", "jperez@uce.edu.ec", "hash123",
                10, "Ingenieria en Sistemas", 5);

        assertEquals("Usuario{idUsuario=1, nombreUsuario='jperez', correo='jperez@uce.edu.ec'}"
                        + " Estudiante{idEstudiante=10, carrera='Ingenieria en Sistemas', semestre=5}",
                estudiante.toString());
        assertFalse(estudiante.toString().contains("hash123"));
    }
}
