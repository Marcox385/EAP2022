/* a.	Dado un arreglo de N números enteros,
cuenta el número de impares positivos existentes en tal arreglo.*/
#include <stdio.h>

int main() {
		int array[10] = {1,2,3,4,5,6,7,8,9,10}, total = 0;
		int size = sizeof(array) / sizeof(int);
		
		for (int i = 0; i < size; i++) {
				if (array[i] % 2 != 0 && array[i] > 0) ++total;
		}
		
		printf("%d\n", total);
		//return total;
}