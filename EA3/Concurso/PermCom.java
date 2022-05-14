import java.util.Arrays;

// Problema T: Permutación común

class PermCom {
    static int max(int A, int B) {
        return (A > B) ? A : B;
    }

    static char[] solve(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = max(dp[i - 1][j],
                                       dp[i][j - 1]);
            }
        }

        int index = dp[s1.length()][s2.length()],
                i = s1.length(), j = s2.length();
        char[] sol = new char[index + 1];

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sol[index - 1] = s1.charAt(i - 1);
                i--; j--; index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else j--;
        }

        return sol;
    }

    static void printSol(char[] sol) {
        for (char c : sol) System.out.printf("%s", c);
        System.out.println();
    }

    public static void main(String[] args) {
        char[] sol = solve("walking", "down");
        Arrays.sort(sol);
        printSol(sol);
    }
}