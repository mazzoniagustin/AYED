package Parciales.Parcial17;
import TP3.GeneralTree;
import java.util.*;

public class Parcial17 {
	GeneralTree<Integer> ag;
	
	public Parcial17(GeneralTree<Integer> ag) {
		this.ag = ag;
	}
	
	
	public static double resolver(GeneralTree<Integer> ag, Integer min, Integer max) {
		datos Dato = new datos();
		if (!ag.isEmpty() && (ag != null)) {
			resolverHelper(ag,min,max,Dato);
		}
		return Dato.getProm();
	}
	
	private static void resolverHelper(GeneralTree<Integer> ag, Integer min, Integer max, datos Dato) {
		List<GeneralTree<Integer>> child = ag.getChildren();
		resolverHelper(child.get(0),min,max,Dato);
		
		if ((ag.getData() > min) && (ag.getData() < max)) {
			Dato.incrementarSuma(ag.getData());
		}
		
		for (int i = 1 ; i < child.size() ; i++) {
			resolverHelper(child.get(i),min,max,Dato);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
