public class BinarySearch {
    public static boolean search(int[] arr, int n) { // Iterativo
        int t = arr.length - 1, b = 0, m;

        while (b <= t) {
            m = b + ((t - b) / 2);

            if (arr[m] > n) t = m - 1;
            else if (arr[m] < n) b = m + 1;
            else return true;
        }

        return false;
    }

    public static boolean searchR(int[] arr, int n, int b, int t) { // Recursivo
        if (t < b) return false;

        int m = b + ((t - b) / 2);

        if (n > arr[m]) return searchR(arr, n, m + 1, t);
        else if (n < arr[m]) return searchR(arr, n, b, m - 1);
        else return true;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(searchR(a, 1, 0, a.length - 1));
    }
}