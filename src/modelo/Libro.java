package modelo;

public class Libro {
    private static int contadorLibros = 1;
    private int id;
    private String titulo;
    private String autor;
    private int ejemplaresDisponibles;
    private int ejemplaresPrestados;

    public Libro(String titulo, String autor, int ejemplaresDisponibles) {
        this.id = contadorLibros++;
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
        this.ejemplaresPrestados = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public boolean estaDisponible() {
        return ejemplaresDisponibles > 0;
    }

    public boolean hayPrestados() {
        return ejemplaresPrestados > 0;
    }

    public void prestar() {
        if (estaDisponible()) {
            ejemplaresDisponibles--;
            ejemplaresPrestados++;
        } else {
            System.out.println("No hay ejemplares disponibles para préstamo de este libro.");
        }
    }

    public void devolver() {
        if (ejemplaresPrestados > 0) {
            ejemplaresPrestados--;
            ejemplaresDisponibles++;
        } else {
            System.out.println("No hay ejemplares prestados de este libro.");
        }
    }
}

