package model;

public class Documento extends Entregable {
    private String url;

    public Documento(String fase, String url) {
        super(fase);
        this.url = url;
    }

    @Override
    public boolean validar() {
        return url.contains("drive.google.com") || url.contains("sharepoint.com")
            || url.contains("onedrive.com") || url.contains("dropbox.com");
    }
}