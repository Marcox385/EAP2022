import java.util.ArrayList;
import java.util.List;

public class maxSum {
    private static float promedioComparaciones;

    private static class Pair<K, V> {
        public K a; public V b;

        public Pair(K a, V b) {
            this.a = a;
            this.b = b;
        }

        public K getA() {return a;}
        public V getB() {return b;}
    }

    private static List<Integer> parseInput(String values) {
        List<Integer> parsed = new ArrayList<>();
        String[] newValues = values.split(" ");

        for(int i = 0; i < newValues.length; i++) {
            parsed.add(Integer.parseInt(newValues[i]));
        }

        return parsed;
    }

    private static List<Integer> getDifferences(List<Integer> arr) {
        List<Integer> differences = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            differences.add(arr.get(i) - arr.get(i - 1));
        }

        return differences;
    }

    private static Pair<Integer, Integer> getIndex(List<Integer> arr) {
        int currMax = 0, prevMax = 0, start = 0, i1 = 0, i2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            currMax += arr.get(i);

            if (currMax < 0) {
                promedioComparaciones++;
                start = i + 1;
                currMax = 0;
            } else if (currMax > prevMax) {
                promedioComparaciones++;
                i2 = i;
                i1 = start;
                prevMax = currMax;
            }
        }

        return new Pair(i1, i2);
    }

    private static void printList(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("%d ", arr.get(i));
        }

        System.out.println();
    }

    private static int generarRandom(int min, int max) { // mínimo y máximo de edad (inclusivo)
        return (int)(min + (max - min + 1) * Math.random());
    }

    private static void procesarArreglo(List<List<Integer>> arreglos, int n) {
        for (int i = 0; i < n / 10; i++) {
            arreglos.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                arreglos.get(i).add(generarRandom(-n/2, n/2));
            }
            
            getIndex(getDifferences(arreglos.get(i)));
        }
    }

    public static void main(String[] args) {
        /* Pruba inicial
        // Entrada de tamaño de datos (no se necesita para Java)
        int n = 17;
        // Datos de entrada separados por espacios
        String data = "100 113 110 85 105 102 86 63 81 101 94 106 101 79 94 90 97";
        
        Pair<Integer, Integer> res = getIndex(getDifferences(parseInput(data)));

        System.out.printf("Selena debe comprar las piñas el día %d.\n", res.a);
        System.out.printf("Selena debe revender las piñas el día %d.\n", res.b + 1); */

        for (int n = 10_000_000; n <= 200_000_000; n += 10_000_000) {
            promedioComparaciones = 0;

            List<List<Integer>> arreglos = new ArrayList<>(n/10);

            procesarArreglo(arreglos, n);

            promedioComparaciones /= 10;

            System.out.printf("%d\t%.2f\n", n, promedioComparaciones);
        }
    }
}