public class prueba { // driver para probar heapSort junto con Borrego
    static float promedioMovimientos, promedioComparaciones;

    public static <T> void printArr(T[] arr) {
        for (T elem : arr) System.out.println(elem);
    }

    public static Borrego generarBorrego(int min, int max) { // mínimo y máximo de edad (inclusivo)
        return new Borrego((int)(min + (max - min + 1) * Math.random()), "genérico");
    }

    public static Borrego generarBorrego(int max) { // valore desde 0 hasta máximo (inclusivo) para edad
        return new Borrego((int)((max + 1) * Math.random()), "genérico");
    }

    public static void procesarArreglo(Borrego[][] borregos, int n) {
        for (int i = 0; i < n / 10; i++) {
            for (int j = 0; j < n; j++) {
                borregos[i][j] = generarBorrego(20);
            }
            Heapsort.heapsort(borregos[i]);
            promedioMovimientos += Heapsort.movimientos;
            promedioComparaciones += Heapsort.comparaciones;
        }
    }

    public static void main(String[] args) {
        for (int n = 1000; n <= 5000; n += 10) {
            promedioMovimientos = 0; promedioComparaciones = 0;

            Borrego[][] borregos = new Borrego[n / 10][n];
            
            procesarArreglo(borregos, n);

            promedioMovimientos /= (n / 10); promedioComparaciones /= (n/10);

            System.out.printf("%d\t%.1f\t%d\t%.1f\n", n, promedioMovimientos, n, promedioComparaciones);
        }
    }
}