package Ej5;

public class Metodos {
	
	public static ObjetoEJ5 calcularEstad (int[] arreglo) {
		int max = -1;
		int min = 999;
		int suma = 0;
		
		for (int elto: arreglo) {
			if (elto > max) {
				max = elto;
			}
			if (elto < min) {
				min = elto;
			}
			suma += elto;
		}
		double promedio = (double) suma / (arreglo.length);
		ObjetoEJ5 obj = new ObjetoEJ5();
		obj.setMaximo(max);
		obj.setMinimo(min);
		obj.setPromedio(promedio);
	
		return obj;
	}
	
	public static void calcularSinParametros (ObjetoEJ5 obj) {
		int max = -1;
		int min = 999;
		int suma = 0;
		for (int elto : obj.)
		
	}

}
