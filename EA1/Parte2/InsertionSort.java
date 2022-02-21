package Parte2;

public class InsertionSort {
    public static void sort(int[] arr) {
        for (int p = 1; p < arr.length; p++) {
            int pivot = arr[p];
            int i = p - 1;

            while (i >= 0 && arr[i] > pivot) {
                arr[i + 1] = arr[i];
                i--;
            }
            
            arr[i + 1] = pivot;
        }
    }
}