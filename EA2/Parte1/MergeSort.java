public class MergeSort {
    public static void sort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;

            mergesort(array, helper, low, middle); // Ordenar mitad izquierda
            mergesort(array, helper, middle + 1, high); // Ordenar mitad derecha
            merge(array, helper, low, middle, high); // MERGEARLOS
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            } current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static void printArr(int[] a) {
        for(int i : a) System.out.printf("%d ", i);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1, 120, 1, 2145, 314};
        printArr(a);
        sort(a);
        printArr(a);
    }
}