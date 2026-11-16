package uce.edu.ec.dominio.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Incidente implements Serializable {
    private int idIncidente;
    private Date fechaHoraReporte;
    private Date fechaHoraActualizacion;
    private String estado;
    private String titulo;
    private String descripcion;
    private String nivelGravedad;
    private int idUsuarioReporta;
    private int idCategoria;
    private final List<Incidente> historico = new ArrayList<>();

    public Incidente() {
    }

    public Incidente(int idIncidente, Date fechaHoraReporte, Date fechaHoraActualizacion, String estado,
                     String titulo, String descripcion, String nivelGravedad, int idUsuarioReporta, int idCategoria) {
        this.idIncidente = idIncidente;
        this.fechaHoraReporte = fechaHoraReporte;
        this.fechaHoraActualizacion = fechaHoraActualizacion;
        this.estado = estado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nivelGravedad = nivelGravedad;
        this.idUsuarioReporta = idUsuarioReporta;
        this.idCategoria = idCategoria;
    }

    public int getIdIncidente() { return idIncidente; }
    public void setIdIncidente(int idIncidente) { this.idIncidente = idIncidente; }

    public Date getFechaHoraReporte() { return fechaHoraReporte; }
    public void setFechaHoraReporte(Date fechaHoraReporte) { this.fechaHoraReporte = fechaHoraReporte; }

    public Date getFechaHoraActualizacion() { return fechaHoraActualizacion; }
    public void setFechaHoraActualizacion(Date fechaHoraActualizacion) { this.fechaHoraActualizacion = fechaHoraActualizacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getNivelGravedad() { return nivelGravedad; }
    public void setNivelGravedad(String nivelGravedad) { this.nivelGravedad = nivelGravedad; }

    public int getIdUsuarioReporta() { return idUsuarioReporta; }
    public void setIdUsuarioReporta(int idUsuarioReporta) { this.idUsuarioReporta = idUsuarioReporta; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public void registrar() {
        Date ahora = new Date();
        this.fechaHoraReporte = ahora;
        this.fechaHoraActualizacion = ahora;
        this.estado = "PENDIENTE";
    }

    public void actualizar() {
        historico.add(new Incidente(idIncidente, fechaHoraReporte, fechaHoraActualizacion, estado,
                titulo, descripcion, nivelGravedad, idUsuarioReporta, idCategoria));
        this.fechaHoraActualizacion = new Date();
    }

    public void eliminar() {
        this.estado = "ELIMINADO";
        this.fechaHoraActualizacion = new Date();
    }

    public boolean verificarIncidente() {
        return titulo != null && !titulo.trim().isEmpty()
                && descripcion != null && !descripcion.trim().isEmpty()
                && nivelGravedad != null && !nivelGravedad.trim().isEmpty();
    }

    public List<Incidente> obtenerHistorico() {
        return new ArrayList<>(historico);
    }

    @Override
    public String toString() {
        return "Incidente{" + "id=" + idIncidente + ", titulo='" + titulo + '\''
                + ", estado='" + estado + '\'' + ", nivelGravedad='" + nivelGravedad + '\'' + '}';
    }
}