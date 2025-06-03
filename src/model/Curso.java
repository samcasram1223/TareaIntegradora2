package model;

public class Curso {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int creditos;

    public Curso(String codigo, String nombre, String descripcion, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
    }
}