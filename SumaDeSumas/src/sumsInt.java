public class sumsInt {
	public static boolean sumsInt1 (int[] arr, int X) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == X) return true;
			}
		}
		
		return false;
	}
	
	public static boolean sumsInt2 (int[] arr, int X) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= X) return false;
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= X) break;
				else if (arr[i] + arr[j] == X) return true;
			}
		}
		
		return false;
	}
	
	public static int[][] fill(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (j == i || j == (n - i - 1)) ? 1 : 0;
            }
        }

        return matrix;
    }
	
	public static int[][] fill2(int n) {
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
		for (int[] row : matrix) {
			for (int col : row) {
				System.out.printf("%d ", col);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1, 4, 5, 7, 9, 12, 13};
		
//		System.out.println(sumsInt2(A,13));
//		printMatrix(fill(100));
		printMatrix(fill2(5));
	}
}