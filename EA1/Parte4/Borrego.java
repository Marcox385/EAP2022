public class Borrego implements Comparable<Borrego> {
    private int kilos;
    private String nombre;
    
    // Constructor
    public Borrego(int kilos, String nombre) {
        try {
            setKilos(kilos);
            setNombre(nombre);
        } catch (BorregoException e) {
            System.out.printf("No fue posible crear al borrego {%d, \"%s\"}.\nError: %s",
                              kilos, nombre, e.getMessage());
        }
    }

    // Setters
    private void setKilos(int kilos) throws BorregoException {
        if (kilos < 0) throw new BorregoException("Kilos inválidos.");
        this.kilos = kilos;
    }

    private void setNombre(String nombre) throws BorregoException {
        if (nombre.length() == 0) throw new BorregoException("Nombre inválido.");
        this.nombre = nombre;
    }

    // Impresión de borrego
    @Override
    public String toString() { // Formateo de cadena
        return String.format("%d kilos: borrego %s. ¡Mbaaah!",
        kilos, nombre);
    }

    // Minimizado a ternario
    public int compareTo(Borrego borrego) {
        return (this.kilos > borrego.kilos) ? 1 :
               (this.kilos < borrego.kilos) ? -1 : 
               (this.nombre.compareTo(borrego.nombre) > 0) ? 1 :
               (this.nombre.compareTo(borrego.nombre) < 0) ? -1 : 0;
    }
}

// compareTo original
// return (this.kilos > borrego.kilos) ? 1 :
//        (this.kilos < borrego.kilos) ? -1 : 0;

// Previo a inciso 4, se debe implementar comparación
// de cadenas (nombre)