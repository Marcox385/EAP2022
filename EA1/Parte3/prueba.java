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

    public static int[] generateRangeArr(int limInf, int limSup) { // límites inclusivos [limInf, limSup]
        int[] arr = new int[limSup + 1 - limInf];

        for (int i = limInf; i <= limSup; i++) {
            arr[i - limInf] = i;
        }

        return arr;
    }

    public static void showBubbleSort(int[] arr) {
        System.out.println("Arreglo original: "); printIntArr(arr);
        BubbleSort.sort(arr);
        System.out.println("\nArreglo ordenado: "); printIntArr(arr);
    }

    public static void main(String[] args) {
        for (int n = 1000; n <= 5000; n+= 100) {
            int[] muestra = generateRandArr(-n, n, n);
            BubbleSort.sort(muestra);
            System.out.printf("%d\t%d\t%d\t%d\n",
                n, BubbleSort.comparaciones, n, BubbleSort.movimientos);
        }
    }
}
