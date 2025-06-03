package ui;

import java.util.List;
import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        GestorProyectos gestor = new GestorProyectos();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        gestor.cargarDemo(); // carga datos demo

        while (running) {
            System.out.println("\n--- MENÚ DE GESTIÓN DE PROYECTOS ---");
            System.out.println("1. Registrar Curso");
            System.out.println("2. Registrar Profesor");
            System.out.println("3. Registrar Proyecto");
            System.out.println("4. Registrar Resultado a Proyecto");
            System.out.println("5. Consultar Proyecto por ID");
            System.out.println("6. Consultar Proyectos sin Resultados");
            System.out.println("7. Editar Proyecto");
            System.out.println("8. Eliminar Entregable (borrado lógico)");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Código del curso: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre del curso: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción corta: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Numero de créditos: ");
                    int creditos = Integer.parseInt(scanner.nextLine());
                    gestor.registrarCurso(new Curso(codigo, nombre, descripcion, creditos));
                    System.out.println("Curso registrado exitosamente.");
                    break;

                case "2":
                    System.out.print("ID del profesor: ");
                    String id = scanner.nextLine();
                    System.out.print("Tipo de identificación: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String profeNombre = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    gestor.registrarProfesor(new Profesor(id, tipo, profeNombre, email));
                    System.out.println("Profesor registrado exitosamente.");
                    break;

                case "3":
                    System.out.print("ID del proyecto: ");
                    String idProyecto = scanner.nextLine();
                    System.out.print("Nombre del proyecto: ");
                    String nombreProyecto = scanner.nextLine();
                    System.out.print("Tipo de proyecto: ");
                    String tipoProyecto = scanner.nextLine();
                    System.out.print("Semestre: ");
                    String semestre = scanner.nextLine();
                    System.out.print("Descripción corta: ");
                    String desc = scanner.nextLine();
                    System.out.print("Palabras clave: ");
                    String keywords = scanner.nextLine();
                    System.out.print("Enlace al enunciado: ");
                    String enlace = scanner.nextLine();
                    System.out.print("Codigo del curso: ");
                    String codCurso = scanner.nextLine();
                    System.out.print("Empresa beneficiaria (una sola o separadas por coma): ");
                    String empresasRaw = scanner.nextLine();
                    List<String> empresas = List.of(empresasRaw.split(","));
                    gestor.registrarProyecto(new Proyecto(idProyecto, nombreProyecto, tipoProyecto, semestre,
                        desc, keywords, enlace, codCurso, empresas));
                    System.out.println("Proyecto registrado.");
                    break;

                case "4":
                    System.out.print("ID del proyecto: ");
                    String projID = scanner.nextLine();
                    System.out.print("Fecha del resultado: ");
                    String fecha = scanner.nextLine();
                    System.out.print("Grupo: ");
                    String grupo = scanner.nextLine();
                    String resultadoID = projID + "-R" + System.currentTimeMillis() + "-" + grupo;
                    Resultado r = new Resultado(resultadoID, fecha, grupo);
                    gestor.agregarResultadoAProyecto(projID, r);
                    System.out.println("Resultado agregado.");
                    break;

                case "5":
                    System.out.print("ID del proyecto: ");
                    String buscarID = scanner.nextLine();
                    Proyecto p = gestor.consultarProyectoPorID(buscarID);
                    if (p != null) {
                        System.out.println("Proyecto: " + p.getNombre());
                        System.out.println("Resultados: " + p.getResultados().size());
                    } else {
                        System.out.println("Proyecto no encontrado.");
                    }
                    break;

                case "6":
                    List<Proyecto> sinResultados = gestor.obtenerProyectosSinResultados();
                    for (Proyecto proj : sinResultados) {
                        System.out.println(proj.getIdProyecto() + ": " + proj.getNombre());
                    }
                    break;

                case "7":
                    System.out.print("ID del proyecto a editar: ");
                    String editID = scanner.nextLine();
                    System.out.print("Nuevo nombre (ENTER para omitir): ");
                    String newName = scanner.nextLine();
                    gestor.editarNombreProyecto(editID, newName);
                    System.out.println("Proyecto editado.");
                    break;

                case "8":
                    System.out.print("ID del proyecto: ");
                    String delPID = scanner.nextLine();
                    System.out.print("ID del resultado: ");
                    String delRID = scanner.nextLine();
                    System.out.print("Indice entregable (0, 1 o 2): ");
                    int index = Integer.parseInt(scanner.nextLine());
                    gestor.eliminarEntregable(delPID, delRID, index);
                    System.out.println("Entregable marcado como eliminado.");
                    break;

                case "9":
                    running = false;
                    break;

                default:
                    System.out.println("Opcion inválida.");
            }
        }
        scanner.close();
    }
}