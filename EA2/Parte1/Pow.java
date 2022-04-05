public class Pow {
    // Se asume que x >= 1, y >= 0
    public static int pow(int x, int y) {
        if (y <= 0) return 1;
        else if (y % 2 == 0) return pow(x * x, y / 2);
        else return x * pow(x * x, y / 2);

        // return (y <= 0) ? 1 : (y % 2 == 0) ?
        // pow(x * x, y / 2) : x * pow(x * x, y / 2);
    }

    public static void main(String[] args) {
        System.out.println(pow(3, 3));
    }
}