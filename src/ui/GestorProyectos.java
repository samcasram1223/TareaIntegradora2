package ui;

import java.util.*;
import model.*;

public class GestorProyectos {
    private List<Curso> cursos;
    private List<Profesor> profesores;
    private List<Proyecto> proyectos;

    public GestorProyectos() {
        cursos = new ArrayList<>();
        profesores = new ArrayList<>();
        proyectos = new ArrayList<>();
    }

    public void cargarDemo() {
        cursos.add(new Curso("09782", "Algoritmos I", "Curso de programación", 3));
        profesores.add(new Profesor("1001", "CC", "Ana Torres", "ana@example.com"));
    }

    public void registrarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void registrarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void registrarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    public void agregarResultadoAProyecto(String idProyecto, Resultado resultado) {
        Proyecto proyecto = consultarProyectoPorID(idProyecto);
        if (proyecto != null) {
            proyecto.agregarResultado(resultado);
        }
    }

    public Proyecto consultarProyectoPorID(String idProyecto) {
        for (Proyecto p : proyectos) {
            if (p.getIdProyecto().equals(idProyecto)) {
                return p;
            }
        }
        return null;
    }

    public List<Proyecto> obtenerProyectosSinResultados() {
        List<Proyecto> sinResultados = new ArrayList<>();
        for (Proyecto p : proyectos) {
            if (p.getResultados().isEmpty()) {
                sinResultados.add(p);
            }
        }
        return sinResultados;
    }

    public void editarNombreProyecto(String idProyecto, String nuevoNombre) {
        Proyecto proyecto = consultarProyectoPorID(idProyecto);
        if (proyecto != null && !nuevoNombre.isEmpty()) {
            proyecto.setNombre(nuevoNombre);
        }
    }

    public void eliminarEntregable(String idProyecto, String idResultado, int index) {
        Proyecto proyecto = consultarProyectoPorID(idProyecto);
        if (proyecto != null) {
            for (Resultado r : proyecto.getResultados()) {
                if (r.getIdResultado().equals(idResultado)) {
                    if (index >= 0 && index < r.getEntregables().size()) {
                        r.getEntregables().set(index, null); // borrado lógico
                    }
                }
            }
        }
    }
}