package model;

public abstract class Entregable {
    protected String fase;

    public Entregable(String fase) {
        this.fase = fase;
    }

    public abstract boolean validar();
}