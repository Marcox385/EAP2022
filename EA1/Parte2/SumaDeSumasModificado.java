public class SumaDeSumasModificado {
    private static float sumCount;

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

	public static int sumaDeSumas(int[] arr) {
		int sum = 0, sumParcial; sumCount = 0;
		
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

    public static void main(String[] args) {
        for (int n = 1000; n <= 5000; n += 100) {
            float sumPromedio = 0;
            for (int i = 0; i < (n / 10); i++) {
                sumaDeSumas(randomArray(n, -10, 10));
                sumPromedio += sumCount;
            }

            sumPromedio /= (n / 10);

            System.out.printf("%d\t%.3f\n", n, sumPromedio);
        }
    }
}