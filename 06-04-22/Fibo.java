class Fibo {
    static int fibo(int n) { // Usual || unsigned int únicamente
        if (n == 0 || n == 1) return n;

        int prev1 = 0, prev2 = 1, act = -1;

        for (int i = 1; i < n; i++) {
            act = prev1 + prev2;
            prev1 = prev2;
            prev2 = act;
        }

        return act;
    }

    static int fiboR(int n) { // Recursivo || unsigned int únicamente
        if (n == 0 || n == 1) return n;
        else return fiboR(n - 1) + fiboR(n - 2);
    }

    static int fiboDin(int n) { // Programación dinámica || unsigned int únicamente
        int[] f = new int[n + 1];
        f[0] = 0;

        if (n == 0) return f[0];
        else {
            f[1] = 1;

            for (int i = 2; i <= n; i++) f[i] = f[i-1] + f[i-2];

            return f[n];
        }
    }

    /* Memoization || unsigned int únicamente */
    static int fiboM(int n, int[] f) {
        if (n > 0 && f[n] != 0) return f[n];
        else if (n == 0) return f[0];
        else if (n == 1) return f[1] = 1;
        else {
            f[n] = fiboM(n - 1) + fibo(n - 2);
            return f[n];
        }
    }

    static int fiboM(int n) {
        int[] f = new int[n + 1];
        return fiboM(n, f);
    }
    /* ------------------------------------- */

    public static void main(String[] args) {
        System.out.println(fiboM(1));
    }
}