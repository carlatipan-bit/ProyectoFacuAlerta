package uce.edu.ec.dominio.modelo;

public class Recomendacion {
    private int idRecomendacion;
    private String titulo;
    private String descripcion;
    private int idCategoria;
    private String nivelPeligro;
    private boolean activa;

    public Recomendacion() {
        this.activa = true;
    }

    public Recomendacion(int idRecomendacion, String titulo, String descripcion, int idCategoria, String nivelPeligro, boolean activa) {
        this.idRecomendacion = idRecomendacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.nivelPeligro = nivelPeligro;
        this.activa = activa;
    }

    public int getIdRecomendacion() { return idRecomendacion; }
    public void setIdRecomendacion(int idRecomendacion) { this.idRecomendacion = idRecomendacion; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public String getNivelPeligro() { return nivelPeligro; }
    public void setNivelPeligro(String nivelPeligro) { this.nivelPeligro = nivelPeligro; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    public void desactivar() {
        this.activa = false;
    }

    @Override
    public String toString() {
        return "Recomendacion{id=" + idRecomendacion + ", titulo='" + titulo + "', nivelPeligro='" + nivelPeligro + "', activa=" + activa + "}";
    }
}