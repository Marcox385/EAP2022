import java.util.ArrayList;

public class Backtracking {

    private static int sols;

    public static boolean isFeasible(int sol[], int i, int x) {
        for (int j = 0; j < i; j++) {
            if (sol[j] == x || Math.abs(x - sol[j]) == Math.abs(i - j))
                return false;
        }

        return true;
    }

    public static void ochoReinas(int sol[], int i, int n) {
        for (int x = 0; x < n; x++) {
            if (isFeasible(sol, i, x)) {
                if (i == n - 1) sols++;
                else {
                    sol[i] = x;
                    ochoReinas(sol, i + 1, n);
                }
            }
        }
    }

    public static long ochoReinas(int n) {
        sols = 0;
        ochoReinas(new int[n], 0, n);
        return sols;
    }

    public static void imprimirSolucion(ArrayList<String> lista, boolean presencia[]) {
        String s = "{";

        for (int i = 0; i < lista.size(); i++) {
            if (presencia[i])
                s += lista.get(i) + ((i == presencia.length - 1) ? ", " : "");
        }
        
        s += "}";
        System.out.println(s);
    }

    public static void combinaciones(ArrayList<String> lista, boolean presencia[], int i) {
        for (int j = 0; i < 2; j++) {
            presencia[i] = (j != 0);
            if (i == presencia.length - 1)
                imprimirSolucion(lista, presencia);
            else
                combinaciones(lista, presencia, i + 1);
        }
    }

    public static void combinaciones(ArrayList<String> lista) {
        combinaciones(lista, new boolean[lista.size()], 0);
    }

    public static void main(String[] args) {
        ArrayList<String> cadenas = new ArrayList<String>();
        cadenas.add("CARLOS");
        cadenas.add("EDGAR");
        cadenas.add("MARCO");
        cadenas.add("ROBERTO");
        cadenas.add("PROFE DE WEB");

        combinaciones(cadenas);

        int N = 20;

        for (int i = 1; i <= N; i++)
            System.out.printf("%d:\t%f\n", i, ochoReinas(i));
    }
}