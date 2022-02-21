/* c.	Dada una matriz de N x N n�meros reales,
encuentra el n�mero m�s grande de la segunda columna.*/
#include <stdio.h>

int main() {
	int matrix[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	// Considerando simetr�a N x N
	int dimCol = sizeof(matrix[0])/sizeof(int), max = matrix[0][1];
	
	
	for (int i = 1; i < dimCol; i++) { // L�nea determinante
		if (matrix[i][1] > max) max = matrix[i][1];
	}
	
	// return max;
	printf("%d\n", max);
}