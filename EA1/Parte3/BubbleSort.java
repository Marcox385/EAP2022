package Parte3;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {          // N : se recorre todo el arreglo - compensación de comprobación
            for (int j = 0; j < arr.length - i - 1; j++) {  // (N^2 - N) / 2) : se recorre el arreglo a partir de [1] - compensación de comprobación
                if (arr[j] > arr[j + 1]) {                  // c_2 : comparación entre datos | N * (N -1)
                    int temp = arr[j];                      // c_1 : movimiento / copia entre datos | Depende de los datos
                    arr[j] = arr[j + 1];                    // c_1 : movimiento / copia entre datos | Depende de los datos
                    arr[j + 1] = temp;                      // c_1 : movimiento / copia entre datos | Depende de los datos
                }
            }
        }
    }
}