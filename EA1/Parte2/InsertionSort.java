public class InsertionSort {
    static double comparaciones, movimientos;

    public static int randomInt(int min, int max) {
		return (int)(min + (max - min) * Math.random());
	}
	
	public static int[] randomArray(int n, int min, int max) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = randomInt(min, max);
		}
		
		return arr;
	}

    static int[] generateRangeArr(int limInf, int limSup, boolean reverse) { // límites inclusivos [limInf, limSup]
        int[] arr = new int[limSup + 1 - limInf];

        for (int i = limInf; i <= limSup; i++) {
            arr[i - limInf] = (reverse) ? limSup - i + 1 : i;
        }

        return arr;
    }

    public static void sort(int[] arr) {
        comparaciones = 0; movimientos = 0;

        for (int p = 1; p < arr.length; p++) {
            int pivot = arr[p]; // c_2
            movimientos++;
            int i = p - 1;

            while (i >= 0 && arr[i] > pivot) { // c_2
                comparaciones++;
                arr[i + 1] = arr[i]; // c_3
                movimientos++;
                i--;
            } comparaciones++;
            
            arr[i + 1] = pivot; // c_3
            movimientos++;
        }
    }

    public static void main(String[] args) {
        for (int n = 1000; n <= 5000; n += 100) {
            double promCompAleatorio = 0, promMovAleatorio = 0;

            sort(generateRangeArr(1, n, false));
            double movOrdenado = movimientos;
            double compOrdenado = comparaciones;

            sort(generateRangeArr(1, n, true));
            double movInverso = movimientos;
            double compInverso = comparaciones;

            for (int i = 0; i < (n / 10); i++) {
                sort(randomArray(n, -n, n));
                promCompAleatorio += comparaciones;
                promMovAleatorio += movimientos;
            }

            promCompAleatorio /= (n / 10);
            promMovAleatorio /= (n / 10);

            System.out.printf("%d\t%f\t%f\t%f\t%f\t%.3f\t%.3f\n",
            n,compOrdenado, movOrdenado, compInverso, movInverso,
            promCompAleatorio, promMovAleatorio);
            // n, compOrdenado, movOrdenado, compInverso, movInverso, promCompAleatorio, promMovAleatorio
        }
    }
}