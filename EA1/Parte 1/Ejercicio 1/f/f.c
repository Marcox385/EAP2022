#include <stdio.h>

int main() {
	int A[3][3] = {{-3, 0, 2}, {-1, 0, 1}, {2, 5, -2}};
	int B[3][3] = {{3, 1, 5}, {0, -2, 6}, {3, -3, 7}};
	int res[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
	int size = sizeof(A[0]) / sizeof(int);
	
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) { 
			res[i][j] = A[i][j] * B[i][j];
		}
	}
	
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			printf("%d ", res[i][j]);
		}
		
		printf("\n");
	}
}