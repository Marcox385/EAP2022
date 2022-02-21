package Parte4;

public class Borrego implements Comparable<Borrego> {
    private int kilos;
    private String nombre;
    
    // Constructor
    public Borrego(int kilos, String nombre) {
        this.kilos = kilos;
        this.nombre = nombre;
    }

    @Override
    public String toString() { // Formateo de cadena
        return String.format("%d kilos: borrego %s. ¡Mbaaah!",
        kilos, nombre);
    }

    // Minimizado a ternario
    public int compareTo(Borrego borrego) {
        return (this.kilos > borrego.kilos) ? 1 :
        (this.kilos < borrego.kilos) ? -1 : 0;

        // Previo a inciso 4, se debe implementar comparación
        // de cadenas (nombre)
    }
}