class Mochila {
    static class Item {
        final String name;
        final int w, v;

        Item (String name, int w, int v) {
            this.name = name;
            this.w = w;
            this.v = v;
        }

        @Override
        public String toString() {
            return this.name + ": <Valor: " + this.v + ", Peso: " + this.w + ">";
        }
    }

    static int max(int A, int B) {
        return (A > B) ? A : B;
    }

    static void backpack(Item[] items, int W) {
        int n = items.length;
        int[] w = new int[items.length],
              v = new int[items.length];
        int[][] vals = new int[n + 1][W + 1];

        for (int a = 0; a < n; a++) {
            w[a] = items[a].w;
            v[a] = items[a].v;
        }
 
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                vals[i][j] = (i == 0 || j == 0) ? 0 : 
                             (w[i - 1] <= j) ? max(v[i - 1] + vals[i - 1][j - w[i - 1]], vals[i - 1][j]) :
                             vals[i - 1][j];
            }
        }
 
        int res = vals[n][W];
        System.out.println("Valor final: " + res);
 
        int holder = W;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res == vals[i - 1][holder]) continue;
            else {
                System.out.println(items[i].toString());
 
                res -= v[i - 1];
                holder -= w[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Item i1 = new Item("Sacapuntas", 1, 1);
        Item i2 = new Item("Corrector", 2, 6);
        Item i3 = new Item("Calculadora", 5, 18);
        Item i4 = new Item("Teclado 20%", 6, 22);
        Item i5 = new Item("PC Gamer", 7, 28);

        Item[] items = {i1, i2, i3, i4, i5};
        int W = 11;

        backpack(items, W);
    }
}