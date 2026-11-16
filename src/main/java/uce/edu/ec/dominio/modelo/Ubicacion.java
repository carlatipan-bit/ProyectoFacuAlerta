package uce.edu.ec.dominio.modelo;

public class Ubicacion {
    private int idUbicacion;
    private String nombreZona;
    private double latitud;
    private double longitud;
    private String tipoZona;
    private int idIncidente;

    public Ubicacion() {}

    public Ubicacion(
            int idUbicacion,
            String nombreZona,
            double latitud,
            double longitud,
            String tipoZona,
            int idIncidente) {
        this.idUbicacion = idUbicacion;
        this.nombreZona = nombreZona;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipoZona = tipoZona;
        this.idIncidente = idIncidente;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    // Método del diagrama: registrarZona(): void
    public void registrarZona() {
        if (nombreZona == null || nombreZona.trim().isEmpty()
                || tipoZona == null || tipoZona.trim().isEmpty()) {
            throw new IllegalStateException("La zona debe tener nombre y tipo para registrarse");
        }
        System.out.println("Zona registrada: " + nombreZona);
    }

    // Método del diagrama: actualizarZona(): void
    public void actualizarZona() {
        if (idUbicacion <= 0) {
            throw new IllegalStateException("Solo se puede actualizar una zona ya registrada (id mayor a 0)");
        }
        System.out.println("Zona actualizada: " + nombreZona);
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "zona='" + nombreZona + "'}";
    }
}
