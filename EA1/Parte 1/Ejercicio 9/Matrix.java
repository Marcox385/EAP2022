public class Matrix {

    public static int[][] fill(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (j == i || j == (n - i - 1)) ? 1 : 0;
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
