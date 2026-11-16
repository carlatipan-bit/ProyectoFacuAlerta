package uce.edu.ec.dominio.modelo;

import java.util.Date;

public class Notificacion {
    private int idNotificacion;
    private String mensajeAlerta;
    private Date fechaHoraEnvio;
    private String tipoNotificacion;
    private int idIncidente;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String mensajeAlerta, Date fechaHoraEnvio,
                        String tipoNotificacion, int idIncidente) {
        this.idNotificacion = idNotificacion;
        this.mensajeAlerta = mensajeAlerta;
        this.fechaHoraEnvio = fechaHoraEnvio;
        this.tipoNotificacion = tipoNotificacion;
        this.idIncidente = idIncidente;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    public void setMensajeAlerta(String mensajeAlerta) {
        this.mensajeAlerta = mensajeAlerta;
    }

    public Date getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public void setFechaHoraEnvio(Date fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    // Método del diagrama: configurarPreferencias(): void (asigna un tipo por defecto si no hay uno)
    public void configurarPreferencias() {
        if (tipoNotificacion == null || tipoNotificacion.trim().isEmpty()) {
            tipoNotificacion = "GENERAL";
        }
    }

    // Método del diagrama: enviar(): void
    public void enviar() {
        this.fechaHoraEnvio = new Date();
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "idNotificacion=" + idNotificacion +
                ", mensajeAlerta='" + mensajeAlerta + '\'' +
                ", fechaHoraEnvio=" + fechaHoraEnvio +
                ", tipoNotificacion='" + tipoNotificacion + '\'' +
                ", idIncidente=" + idIncidente +
                '}';
    }
}
