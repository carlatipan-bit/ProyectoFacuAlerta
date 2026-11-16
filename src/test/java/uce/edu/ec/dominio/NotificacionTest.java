package uce.edu.ec.dominio.modelo;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class NotificacionTest {

    @Test
    public void testConstructorVacio() {
        Notificacion notificacion = new Notificacion();

        assertNotNull(notificacion);
        assertEquals(0, notificacion.getIdNotificacion());
        assertNull(notificacion.getMensajeAlerta());
        assertNull(notificacion.getFechaHoraEnvio());
        assertNull(notificacion.getTipoNotificacion());
        assertEquals(0, notificacion.getIdIncidente());
    }

    @Test
    public void testConstructorConParametros() {
        Date envio = new Date(1000L);

        Notificacion notificacion = new Notificacion(1, "Alerta de incendio en bloque A", envio, "URGENTE", 101);

        assertEquals(1, notificacion.getIdNotificacion());
        assertEquals("Alerta de incendio en bloque A", notificacion.getMensajeAlerta());
        assertEquals(envio, notificacion.getFechaHoraEnvio());
        assertEquals("URGENTE", notificacion.getTipoNotificacion());
        assertEquals(101, notificacion.getIdIncidente());
    }

    @Test
    public void testGettersYSetters() {
        Notificacion notificacion = new Notificacion();
        Date envio = new Date(2000L);

        notificacion.setIdNotificacion(9);
        notificacion.setMensajeAlerta("Revision de tuberias");
        notificacion.setFechaHoraEnvio(envio);
        notificacion.setTipoNotificacion("INFORMATIVA");
        notificacion.setIdIncidente(33);

        assertEquals(9, notificacion.getIdNotificacion());
        assertEquals("Revision de tuberias", notificacion.getMensajeAlerta());
        assertEquals(envio, notificacion.getFechaHoraEnvio());
        assertEquals("INFORMATIVA", notificacion.getTipoNotificacion());
        assertEquals(33, notificacion.getIdIncidente());
    }

    @Test
    public void testToString() {
        Date envio = new Date(1000L);
        Notificacion notificacion = new Notificacion(1, "Alerta de incendio en bloque A", envio, "URGENTE", 101);

        assertEquals("Notificacion{idNotificacion=1, mensajeAlerta='Alerta de incendio en bloque A',"
                        + " fechaHoraEnvio=" + envio + ", tipoNotificacion='URGENTE', idIncidente=101}",
                notificacion.toString());
    }
}

