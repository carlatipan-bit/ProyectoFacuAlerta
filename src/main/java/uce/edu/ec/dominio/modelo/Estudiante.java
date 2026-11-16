package uce.edu.ec.dominio.modelo;

public class Estudiante extends Usuario {
    private int idEstudiante;
    private String carrera;
    private int semestre;

    public Estudiante() {
        super();
    }

    public Estudiante(int idUsuario, String nombreUsuario, String correo, String contrasenaHash, int idEstudiante,
                      String carrera, int semestre) {
        super(idUsuario, nombreUsuario, correo, contrasenaHash, "ESTUDIANTE");
        this.idEstudiante = idEstudiante;
        setCarrera(carrera);   // valida
        setSemestre(semestre); // valida
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (carrera == null || carrera.trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede ser nula ni vacía");
        }
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        if (semestre < 1) {
            throw new IllegalArgumentException("El semestre debe ser mayor o igual a 1");
        }
        this.semestre = semestre;
    }

    // Método del diagrama: reportarIncidente(): void
    public void reportarIncidente() {
        System.out.println("El estudiante " + getNombreUsuario() + " está reportando un incidente");
    }

    @Override
    public String toString() {
        return super.toString() + " Estudiante{" + "idEstudiante=" + idEstudiante
                + ", carrera='" + carrera + '\'' + ", semestre=" + semestre + '}';
    }
}

