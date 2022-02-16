public class insertionSort {
    public static void sort(int[] arr) {
        for (int p = 0 + 1; p < arr.length; p += 1) {
            int pivot = arr[p];
            int i = p - 1;

            while (i >= 0 && arr[i] > pivot) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }

            arr[i + 1] = pivot;
        }
    }

    public static void printArr(int[] arr) {
        for(int i : arr) System.out.printf("%d ", i);
        System.out.println();
    }

    public static void main(String[] args) {
        // Ejemplo
        int[] arr = {10, 9, 8, 7, 6, 5, 3, 4, 2, 1};
        printArr(arr); sort(arr); printArr(arr);
    }
}