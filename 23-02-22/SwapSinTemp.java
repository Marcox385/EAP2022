public class SwapSinTemp {
    private static int a, b;

    private static void setVals(int valA, int valB) {
        a = valA;
        b = valB;
    }

    private static void reflect() {
        System.out.printf("a = %d; b = %d\n", a, b);
    }

    public static void swap() {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }

    public static void swapShow(int valA, int valB) {
        setVals(valA, valB);
        reflect(); swap(); reflect();
    }

    public static void main(String[] args) {
        swapShow(111,203);
    }
}