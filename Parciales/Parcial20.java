package Parciales;
import TP3.GeneralTree;
import java.util.*;

public class Parcial20 {
	private GeneralTree<Integer> ag;
	
	public Parcial20(GeneralTree<Integer> ag) {
		this.ag = ag;
	}
	
	public List<Integer> resolver(GeneralTree<Integer> ag) {
		List<Integer> list = new LinkedList<Integer>();
		if (!ag.isEmpty()) {
			resolverHelper(ag,list);
			return list;
		}
		return list;
	}
	
	private static void resolverHelper(GeneralTree<Integer> ag, List<Integer> list) {
		if (ag.hasChildren()) {
			for (GeneralTree<Integer> child : ag.getChildren()) {
				resolverHelper(child,list);
			}
		}
		else {
			if (ag.getData() % 2 == 0) {
				list.add(ag.getData());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
