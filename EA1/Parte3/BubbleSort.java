public class BubbleSort {
    public static int comparaciones, movimientos;

    public static void sort(int[] arr) {
        comparaciones = 0; movimientos = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {  // (N^2 - N) / 2) caso promedio
                comparaciones++;
                if (arr[j] > arr[j + 1]) {                  // c_2 : comparación entre datos | N * (N -1)
                    int temp = arr[j];                      // c_1 : movimiento / copia entre datos | Depende de los datos
                    arr[j] = arr[j + 1];                    // c_1 : movimiento / copia entre datos | Depende de los datos
                    arr[j + 1] = temp;                      // c_1 : movimiento / copia entre datos | Depende de los datos
                    swapped = true;
                    movimientos += 3;
                }
            }
            if (!swapped) break;
        }
    }
}