public class Matrix {

    public static int[][] fillUniversal(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < (n / 2) + 1; i++) {
            for (int j = 0; j < (n / 2) + 1; j++) {
                int curVal = (j == i) ? 1 : 0;
            	
                matrix[i][j] = curVal;
            	matrix[i][n - j - 1] = curVal;
            	matrix[n - i - 1][j] = curVal;
            	matrix[n - i - 1][n - j - 1] = curVal;
            }
        }

        return matrix;
    }
    
    public static int[][] fillJava(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < (n / 2) + 1; i++) {
            matrix[i][i] = 1;
            matrix[i][n - i - 1] = 1;
            matrix[n - i - 1][i] = 1;
            matrix[n - i - 1][n - i - 1] = 1;
        }

        return matrix;
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] i : matrix) {
            for (int j : i)  System.out.printf("%d", j);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int dim = 5;
        int[][] matrix = fillUniversal(dim);
        printMatrix(matrix);
    }
}
