package uce.edu.ec.dominio.modelo;

public class Moderador extends Usuario {

    private int idModerador;
    private String permisos;

    public Moderador() {
        super();
    }

    public Moderador(int idUsuario, String nombreUsuario, String correo, String contrasenaHash, int idModerador, String permisos) {
        super(idUsuario, nombreUsuario, correo, contrasenaHash, "Moderador");
        this.idModerador = idModerador;
        this.permisos = permisos;
    }

    public int getIdModerador() {
        return idModerador;
    }

    public void setIdModerador(int idModerador) {
        this.idModerador = idModerador;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public boolean validarIncidente(Incidente incidente) {
        return incidente != null;
    }

    @Override
    public String toString() {
        return super.toString() + " Moderador{" + "idModerador=" + idModerador
                + ", permisos='" + permisos + '\'' + '}';
    }
}
