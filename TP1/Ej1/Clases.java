package TP1.Ej1;

public class Clases {
	public static void recorrerFor(int a, int b) {
		for (int i = a ; i <= b ; i++) {
			System.out.println(i);
		}
	}
	public static void conWhile(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void recursion (int a, int b) {
		if (a <= b) {
			System.out.println(a);
			recursion(a + 1,b);
		}
	}
}
