public class CarPlate implements Hashable {
    // ejemplo XPC9361
    private String plate;

    public CarPlate(String plate) {
        // TODO
        // Validar placa; en caso de fallo, utilizar placa predefinida
        this.plate = plate;
    }

    public String toString() {
        return plate;
    }

    public int hashCode(int c) {
        int[] weights = {26, 26, 10, 10, 10, 10, 1};
        int code = 0;

        // Método de Horner -- X's son weights
        for (int i = 0; i < 7; i++) {
            char symbol = plate.charAt(i);
            code += symbol - ((i >= 3) ? '0' : 'A');
            code %= c;
            code *= weights[i];
            code %= c;
        }

        return code;
    }

    public boolean equals(Object o) {
        if(!(o instanceof CarPlate)) return false;

        CarPlate cp = (CarPlate)o;

        return this.plate.equals(cp.plate);
    }
}