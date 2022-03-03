public class Heapsort {
    private static <T extends Comparable<? super T>> boolean greaterThan(T a, T b) {
       return (a.compareTo(b) == 1) ? true : false;
    }

    private static int left(int k) { return (2*k) + 1; }

    private static int right(int k) { return (2*k) + 2; }

    private static <T extends Comparable<? super T>> void swap(T a[], int A, int B) {
        T temp = a[A]; a[A] = a[B]; a[B] = temp;
    }

    private static <T extends Comparable<? super T>> void buildMaxHeap(T a[]) { // {5, 8, 7, 9, 1, 3}
        for (int root = (int)Math.floor(a.length/2); root >= 0; root--) {
            maxHeapify(a, root, a.length);
        }
    }

    private static <T extends Comparable<? super T>> void maxHeapify(T a[], int root, int heapSize) {
        int left = left(root);
        int right = right(root);
        int max = root;

        if (left < heapSize && greaterThan(a[left], a[max])) max = left;  
        if (right < heapSize && greaterThan(a[right], a[max])) max = right; 
        if (max != root) {
            swap(a, root, max);
            maxHeapify(a, max, heapSize);
        }
    }

    public static <T extends Comparable<? super T>> void heapsort(T a[]) {
        buildMaxHeap(a);

        for (int heapSize = a.length; heapSize > 1; heapSize--) {
            swap(a, 0, heapSize - 1);
            maxHeapify(a, 0, heapSize - 1);
        }
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (greaterThan(a[i], a[i + 1])) return false;
        }

        return true;
    }
}
