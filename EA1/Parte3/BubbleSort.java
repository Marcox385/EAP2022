public class BubbleSort {
    public static int n = 0;

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {  // (N^2 - N) / 2) caso promedio
                if (arr[j] > arr[j + 1]) {                  // c_2 : comparación entre datos | N * (N -1)
                    int temp = arr[j];                      // c_1 : movimiento / copia entre datos | Depende de los datos
                    arr[j] = arr[j + 1];                    // c_1 : movimiento / copia entre datos | Depende de los datos
                    arr[j + 1] = temp;                      // c_1 : movimiento / copia entre datos | Depende de los datos
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}