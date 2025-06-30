package Ej2;

public class Metodo {
	public static int[] crearArreglo (int n) {
		int arreglo[] = new int[n];
		int num = 0;
		for (int i = 0 ; i < n ; i++) {
			arreglo[i] = n + num;
			num+= n;
		}
		return arreglo;
	}
}
