public class Matrix {

    public static int[][] fill(int n) {
        int[][] matrix = new int[n][n];
        int curVal = 0;

        for (int i = 0; i < (n / 2) + 1; i++) {
            for (int j = 0; j < (n / 2) + 1; j++) {
                curVal = (j == i) ? 1 : 0;
            	
                matrix[i][j] = curVal;
            	matrix[i][n - j - 1] = curVal;
            	matrix[n - i - 1][j] = curVal;
            	matrix[n - i - 1][n - j - 1] = curVal;
            }
        }

        return matrix;
    }

    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%d", matrix[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int dim = 5;
        int[][] matrix = fill(dim);
        printMatrix(matrix);
    }
}
