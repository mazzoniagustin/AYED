package Parciales;
import java.util.*;
import TP3.GeneralTree;

public class Parcial18 {
	private GeneralTree<Integer> ag;
	
	public Parcial18 (GeneralTree<Integer> ag) {
		this.ag = ag;
	}
	
	public static List<String> resolver(GeneralTree<Integer> ag, int valorMax) {
		if (!ag.isEmpty()) {
			List<String> list = new LinkedList<String>();
			resolverHelper(ag, valorMax, 0, list);
			return list;
		}
	}
	
	private static void resolverHelper(GeneralTree<Integer> ag, int valorMax, int nivel, List<String> list) {
		List<GeneralTree<Integer>> children = ag.getChildren();
		if (ag.hasChildren()) {
			resolverHelper(children.get(0),valorMax,nivel+1,list);
		}
		int value = ag.getData();
		if (value > valorMax) {
			list.add("Valor: " + value + " Nivel: " + nivel);
		}
		for (GeneralTree<Integer> child: children) {
			resolverHelper(child,valorMax,nivel+1,list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
