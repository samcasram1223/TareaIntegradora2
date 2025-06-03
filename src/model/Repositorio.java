package model;

public class Repositorio extends Entregable {
    private String url;
    private int numArchivos;

    public Repositorio(String fase, String url, int numArchivos) {
        super(fase);
        this.url = url;
        this.numArchivos = numArchivos;
    }

    @Override
    public boolean validar() {
        return url != null && url.contains("github.com");
    }
}
