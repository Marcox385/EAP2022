/* b.	Dada una palabra de N caracteres,
determina si termina en vocal o no.*/
#include <stdio.h>

/* Valores de vocales 
	A = 65, E = 69, I = 73, O = 79, U = 85
	a = 97, e = 101, i = 105, o = 111, u = 117
*/

/* Posible estrategia: convertir último caracter a mayúscula
para realizar solo 5 comparaciones. */

int main() {
	char arr[] = "ABCDEF";
	int pos = (sizeof(arr) / sizeof(char));
	char last = arr[pos - 2];
	
	if (last == 65 || last == 69 || last == 73 || last == 79 || last == 85
		|| last == 97 || last == 101 || last == 105 || last == 111 || last == 117) {
		printf("True\n"); return 1;
	}
	
	printf("False\n"); return 0;
}