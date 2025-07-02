package Ej2;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese el numero para crear el arreglo");
		int num = s.nextInt();
		int arreglo [] = Metodo.crearArreglo(num);
		for (int i = 0 ; i < num ; i++) {
			System.out.println(arreglo[i] + " - ");
		}

	}

}
