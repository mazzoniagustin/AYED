package Parciales.Parcial13;
import TP3.GeneralTree;

public class Parcial13 {
	private GeneralTree<Integer> ab;
	
	public Parcial13(GeneralTree<Integer> ab) {
		this.ab = ab;
	}
	
	public int resolver(GeneralTree<Integer> ab) {
		if ((!ab.isEmpty()) && (ab != null)) {
			elementos E = new elementos();
			resolverHelper(ab, E);
			if (E.getSumaTotal() % 2 == 0) {
				return E.getPositivos();
			}
			else {
				return E.getNegativos();
			}
		}
		return 0;
	}
	
	private static void resolverHelper(GeneralTree<Integer> ab, elementos Elem) {
		for (GeneralTree<Integer> child: ab.getChildren()) {
			resolverHelper(child,Elem);
		}
		
		int valor = ab.getData();
		Elem.agregarTotal(valor);
		if (valor > 0) {
			Elem.sumaPositivos(valor);
		}
		else {
			Elem.sumaNegativos(valor);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
