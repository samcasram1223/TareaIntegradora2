package model;

public class Profesor {
    private String id;
    private String tipoId;
    private String nombre;
    private String email;

    public Profesor(String id, String tipoId, String nombre, String email) {
        this.id = id;
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.email = email;
    }
}