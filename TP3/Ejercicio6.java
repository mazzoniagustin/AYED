package TP3;
import TP3.GeneralTree;
public class Ejercicio6 {
	private GeneralTree<Character> ab;
	
	public double minimoCaudal(double caudal) {
		if (!ab.isEmpty()) {
			return minimoCaudalHelper(ab, caudal);
		}
		else {
			return 0;
		}
		
	}
	
	private double minimoCaudalHelper(GeneralTree<Character> ab, double caudalPadre) {
		if (!ab.hasChildren()) {
			return caudalPadre;
		}
		else {
			double min = 9999;
			int cant = ab.getChildren().size();
			for (GeneralTree<Character> child : ab.getChildren()) {
				double caudalHijo = minimoCaudalHelper(child,caudalPadre/cant);
				if (caudalHijo < min) {
					min = caudalHijo;
				}
			}
			return min;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
