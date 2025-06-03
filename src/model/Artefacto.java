package model;

public class Artefacto extends Entregable {
    private String tipo;

    public Artefacto(String fase, String tipo) {
        super(fase);
        this.tipo = tipo;
    }

    @Override
    public boolean validar() {
        return tipo != null && !tipo.isEmpty();
    }
}