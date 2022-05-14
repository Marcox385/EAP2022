public class SumaDeSumas {
	
	private static long sumCount;
	private static long sumCount2;
	
	public static int randomInt(int min, int max) {
		return (int)(min + (max - min) * Math.random());
	}
	
	public static int[] randomArray(int n, int min, int max) {
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = randomInt(min, max);
		}
		
		return arr;
	}

	public static int sumaDeSumas1(int[] arr) {
		int sum = 0, sumParcial, sumCount = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sumParcial = 0;
			for (int j = 0; j <= i; j++) {
				sumParcial += arr[j];
				sumCount++;
			}
			sum += sumParcial;
		}
		
		return sum;
	}
	
	/*public static int sumaDeSumas2(int[][] arrs) {
		int sum = 0, sumParcial, sumCount2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sumParcial = 0;
			for (int j = 0; j <= i; j++) {
				sumParcial += arr[j];
				sumCount++;
			}
			sum += sumParcial;
		}
		
		return sum;
	}*/

	public static int sumaDeSumas2(int[][] arrs) {
		int sum = 0, sumParcial, sumCount2 = 0;
		
		for (int i = 0; i < arrs.length; i++) {
			sumParcial = 0;
			for (int j = 0; j <= arrs[i].length; j++) {
				sumParcial += arrs[i][j];
				sumCount2++;
			}
			sum += sumParcial;
		}
		
		return sum/arrs.length;
	}
	
	public static void main(String[] args) {
		// for (int n = 1000; n <= 5000; n += 100) {
		// 	int arr[] = randomArray(n, -10, 10);
			
		// 	long start = System.currentTimeMillis();
		// 	sumaDeSumas1(arr);			
		// 	long millis = System.currentTimeMillis() - start;
			
		// 	System.out.printf("%d\t%d\n", n, millis);
		// }

			
		for (int n = 1000; n <= 5000; n += 100) {
			int arr[] = randomArray(n, -10, 10);
			
			long start = System.currentTimeMillis();
			sumaDeSumas1(arr);			
			long millis = System.currentTimeMillis() - start;
			
			System.out.printf("%d\t%d\n", n, millis);
		}
	}
}