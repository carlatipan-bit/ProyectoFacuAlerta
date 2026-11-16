package uce.edu.ec.dominio.modelo;

public class GestorDeRiesgo extends Usuario {
    private int idGestorRiesgo;
    private String departamento;
    private String cargoInstitucional;
    private String matrizEvaluacion;

    public GestorDeRiesgo() {
        super();
    }

    public GestorDeRiesgo(int idUsuario, String nombreUsuario, String correo, String contrasenaHash,
                          int idGestorRiesgo, String departamento, String cargoInstitucional, String matrizEvaluacion) {
        super(idUsuario, nombreUsuario, correo, contrasenaHash, "GESTOR_RIESGO");
        this.idGestorRiesgo = idGestorRiesgo;
        this.departamento = departamento;
        this.cargoInstitucional = cargoInstitucional;
        this.matrizEvaluacion = matrizEvaluacion;
    }

    public int getIdGestorRiesgo() {
        return idGestorRiesgo;
    }

    public void setIdGestorRiesgo(int idGestorRiesgo) {
        this.idGestorRiesgo = idGestorRiesgo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargoInstitucional() {
        return cargoInstitucional;
    }

    public void setCargoInstitucional(String cargoInstitucional) {
        this.cargoInstitucional = cargoInstitucional;
    }

    public String getMatrizEvaluacion() {
        return matrizEvaluacion;
    }

    public void setMatrizEvaluacion(String matrizEvaluacion) {
        this.matrizEvaluacion = matrizEvaluacion;
    }

    // Método del diagrama: evaluarNivelRiesgo(inc: Incidente): String
    public String evaluarNivelRiesgo(Incidente incidente) {
        if (incidente == null || incidente.getNivelGravedad() == null) {
            return "SIN_EVALUAR";
        }
        return incidente.getNivelGravedad();
    }

    // Método del diagrama: definirGravedadCategoria(cat: Categoria, n: String): void
    public void definirGravedadCategoria(Categoria categoria, String nivel) {
        if (categoria == null || nivel == null || nivel.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría y el nivel no pueden ser nulos ni vacíos");
        }
        categoria.definirGravedad();
        System.out.println("Gravedad de la categoría " + categoria.getNombreCategoria() + ": " + nivel);
    }

    // Método del diagrama: emitirRecomendacionSeguridad(inc: Incidente): void
    public void emitirRecomendacionSeguridad(Incidente incidente) {
        if (incidente == null) {
            throw new IllegalArgumentException("El incidente no puede ser nulo");
        }
        System.out.println("Recomendación de seguridad para el incidente " + incidente.getIdIncidente()
                + " (riesgo: " + evaluarNivelRiesgo(incidente) + ")");
    }

    @Override
    public String toString() {
        return super.toString() + " GestorDeRiesgo{" + "idGestorRiesgo=" + idGestorRiesgo
                + ", departamento='" + departamento + '\''
                + ", cargoInstitucional='" + cargoInstitucional + '\''
                + ", matriz='" + matrizEvaluacion + '\'' + '}';
    }
}
