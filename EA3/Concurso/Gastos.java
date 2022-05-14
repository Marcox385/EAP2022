import java.util.Collections;
import java.util.Vector;

class Gastos {
    static boolean caseSol;

    static void unique_combination(int l, int sum, int K, Vector<Integer> local, Vector<Integer> A) {
        if (sum == K) {
            caseSol = true;
            return;
        }
 
        for (int i = l; i < A.size(); i++) {
             if (sum + A.get(i) > K)
                continue;
 
            if (i > l && A.get(i) == A.get(i - 1) )
                continue;
 
            local.add(A.get(i)); 
            unique_combination(i + 1, sum + A.get(i), K, local, A); 
            local.remove(local.size() - 1);
        }
    }
 
    static void Combination(Vector<Integer> input) {
        Vector<Integer> A = new Vector<>();
        int K = input.get(0);

        for (int i = 2; i < input.size(); i++) A.add(input.get(i));

        Collections.sort(A); 
        Vector<Integer> local = new Vector<Integer>(); 
        unique_combination(0, 0, K, local, A);
    }

    static Vector<Integer> format(String s) {
        String[] f = s.split(" ");
        Vector<Integer> r = new Vector<>();

        for (int i = 0; i < f.length; i++) {
            r.add(Integer.parseInt(f[i]));
        }

        return r;
    }

    public static void main(String[] args) {
        // Formato: 10 = objetivo; 5 = elementos
        // String caso = "10 5 3 9 6 2 4";
        String caso = "500 4 250 200 150 400";
        Combination(format(caso));

        System.out.println((caseSol) ? "Secretario de Finanzas" : "Ni modo");
    }
}