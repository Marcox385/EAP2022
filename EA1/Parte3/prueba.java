package Parte3;

public class prueba {

    public static boolean checkSortedArr(int[] arr, boolean asc) {

        for (int i = 0; i < arr.length - 1; i++) {
            if ((asc && arr[i] > arr[i + 1]) || (!asc && arr[i] < arr[i + 1])) {
                return false;
            }
        }

        return true;
    }

    public static void printIntArr(int[] arr) {
        for (int elem : arr) System.out.printf("%d ", elem);
        System.out.println();
    }

    public static int[] generateRandArr(int limInf, int limSup, int size) { // límites inclusivos [limInf, limSup]
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int)(limInf + (limSup - limInf + 1) * Math.random());
        }

        return arr;
    }

    public static void showBubbleSort(int[] arr) {
        System.out.println("Arreglo original: "); printIntArr(arr);
        BubbleSort.sort(arr);
        System.out.println("\nArreglo ordenado: "); printIntArr(arr);
    }

    public static void main(String[] args) {
        // int[] arr = {3, 1, 2, 5, 4, 8, 7, 6};
        // showBubbleSort(arr);

        // showBubbleSort(generateRandArr(-100, 100, 40));

        int[] arr = generateRandArr(10, 1000, 40);
        showBubbleSort(arr);
        System.out.println("\n" + checkSortedArr(arr, true));
    }
}
