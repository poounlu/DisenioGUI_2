package modelo;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Libro> listaDeLibros;

    public Libreria() {
        listaDeLibros = new ArrayList<>();
    }

    public List<Libro> obtenerTodosLosLibros() {
        return listaDeLibros;
    }

    public Libro obtenerLibroPorId(int id) {
        for (Libro libro : listaDeLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null; // Devolver null si no se encuentra el libro
    }

    public Libro agregarLibro(Libro libro) {
        listaDeLibros.add(libro);
        return libro;
    }

    public List<Libro> buscarLibrosPorTitulo(String parteDelTitulo) {
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : listaDeLibros) {
            if (libro.getTitulo().toLowerCase().contains(parteDelTitulo.toLowerCase())) {
                librosEncontrados.add(libro);
            }
        }

        return librosEncontrados;
    }

    // Puedes agregar más métodos según las operaciones necesarias, como buscar, prestar, devolver, etc.

}
