public class moda {
    static double comparaciones, movimientos;

    static int mode(int[] array) {
        int maxCount = 0, mode = -1;
        comparaciones = 0; movimientos = 0;

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                comparaciones++;
                if (array[i] == array[j]) count++; // c_3
            }

            comparaciones++;
            if (count > maxCount) { // c_3
                maxCount = count; // c_2
                mode = array[i]; // c_2
                movimientos += 2;
            }
        }

        return mode;
    }

    static int[] fillArr(int n, int val) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = val;
        }

        return arr;
    }

    static int randomInt(int min, int max) {
		return (int)(min + (max - min) * Math.random());
	}
	
	static int[] randomArray(int n, int min, int max) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = randomInt(min, max);
		}
		
		return arr;
	}

    static int[] generateRangeArr(int limInf, int limSup) { // límites inclusivos [limInf, limSup]
        int[] arr = new int[limSup + 1 - limInf];

        for (int i = limInf; i <= limSup; i++) {
            arr[i - limInf] = i;
        }

        return arr;
    }

    public static void main(String[] args) {
        for (int n = 1000; n <= 5000; n += 100) {
            double promCompAleatorio = 0, promMovAleatorio = 0;

            mode(fillArr(n, n));
            double movIgual = movimientos;
            double compIgual = comparaciones;

            mode(generateRangeArr(1, n));
            double movDistinto = movimientos;
            double compDistinto = comparaciones;

            for (int i = 0; i < (n / 10); i++) {
                mode(randomArray(n, -n, n));
                promCompAleatorio += comparaciones;
                promMovAleatorio += movimientos;
            }

            promCompAleatorio /= (n / 10);
            promMovAleatorio /= (n / 10);

            System.out.printf("%d\t%f\t%f\t%f\t%f\t%.3f\t%.3f\n",
            n,compIgual, movIgual, compDistinto, movDistinto,
            promCompAleatorio, promMovAleatorio);
            // n, compIgual, movIgual, compDistinto, movDistinto, promCompAleatorio, promMovAleatorio
        }
    }
}
