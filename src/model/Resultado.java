package model;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
    private String idResultado;
    private String fecha;
    private String grupo;
    private List<Entregable> entregables;

    public Resultado(String idResultado, String fecha, String grupo) {
        this.idResultado = idResultado;
        this.fecha = fecha;
        this.grupo = grupo;
        this.entregables = new ArrayList<>();
    }

    public void agregarEntregable(Entregable e) {
        entregables.add(e);
    }

    public String getIdResultado() {
        return idResultado;
    }

    public List<Entregable> getEntregables() {
        return entregables;
    }
}