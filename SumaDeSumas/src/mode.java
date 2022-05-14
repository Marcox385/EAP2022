public class mode {	
	int mode(int[] array) {
		int maxCount = 0, mode = -1;
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) count++;
			}
			
			if (count > maxCount) {
				maxCount = count;
				mode = array[i];
			}
		}
		return mode;
	}
	
	public static void main(String[] args) {
		
	}
}