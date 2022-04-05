public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) { 
        int index = partition(arr, left, right);
        if (left < index - 1) quickSort(arr, left, index - 1);
        if (index < right) quickSort(arr, index, right);
    }

    public static void swap(int[] arr, int left, int right) {
        int holder = arr[left];
        arr[left] = arr[right];
        arr[right] = holder;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right - 1];

        while (left < right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--; 
        
            if (left <= right) { 
                swap(arr, left, right);
                left++; 
                right--; 
            } 
        } 

        return left; 
    }

    public static int findSadisticN(int[] arr, int n, int left, int right) {
        int pivot = partition(arr, left, right);

        return (pivot == n - 1) ? arr[pivot] : 
               (n - 1 < pivot) ? findSadisticN(arr, n, left, pivot - 1) :
               findSadisticN(arr, n, pivot + 1, right);
    }

    public static void printArr(int[] a) {
        for(int i : a) System.out.printf("%d ", i);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[100];

        for (int i = 0; i < 100; i++) a[i] = (i % 2 == 0) ? i : 100 - i;

        System.out.println(findSadisticN(a, 7, 0, a.length - 1));
        printArr(a);
    }
}