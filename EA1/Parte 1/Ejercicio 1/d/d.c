#include <stdio.h>

int main() {
	int arr[] = {1,2,3,4,5,6,7,8,9,10};
	// int arr[] = {7,1,3,9,10,2,4,6,5,8};
	int size = sizeof(arr) / sizeof(int);
	
	for (int i = 0; i < size; i++) {  // N + 1
		if (arr[i] % 2 != 0) {  // ?
			for (int j = 0; j < size; j++) {  // N + 1
				if (arr[j] % 2 == 0) printf("(%d, %d)\n", arr[i], arr[j]);
			}
		}
	}
}