public class Cambio {
    public static int min(int a, int b) {
        return (a > b || a == b) ? b : a; 
    }

    public static int solve(int[] monedas, int cantidad) {
        int[] sols = new int[cantidad + 1];
        sols[0] = 0;
        for (int i = 1; i < cantidad + 1; i++) sols[i] = Integer.MAX_VALUE;

        for (int i = 1; i < cantidad + 1; i++) {
            for (int moneda : monedas) {
                if (i - moneda >= 0) {
                    sols[i] = min(sols[i], 1 + sols[i - moneda]);
                }
            }
        }

        return (sols[cantidad] != cantidad + 1) ? sols[cantidad] : -1;
    }

    public static void main(String[] args) {
        int cantidad = 9;
        int[] monedas = {1, 4, 6};

        System.out.println(solve(monedas, cantidad));
    }
}