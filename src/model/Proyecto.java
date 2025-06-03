package model;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String idProyecto;
    private String nombre;
    private String tipo;
    private String semestre;
    private String descripcion;
    private String palabrasClave;
    private String enlaceEnunciado;
    private String cursoCodigo;
    private List<String> empresasBeneficiarias;
    private List<Resultado> resultados;

    public Proyecto(String id, String nombre, String tipo, String semestre, String descripcion,
                    String palabrasClave, String enlace, String cursoCodigo, List<String> empresas) {
        this.idProyecto = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.semestre = semestre;
        this.descripcion = descripcion;
        this.palabrasClave = palabrasClave;
        this.enlaceEnunciado = enlace;
        this.cursoCodigo = cursoCodigo;
        this.empresasBeneficiarias = empresas;
        this.resultados = new ArrayList<>();
    }

    public void agregarResultado(Resultado r) {
        if (resultados.size() < 3) {
            resultados.add(r);
        }
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }
}