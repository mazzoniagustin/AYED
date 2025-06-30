package Parciales;
import TP3.GeneralTree;
import java.util.*;

public class Parcial21 {
	private GeneralTree<Integer> ag;
	
	public Parcial21 (GeneralTree<Integer> ag) {
		this.ag = ag;
	}
	
	public List<Integer> nivel(int num) {
		List<Integer> lis = new LinkedList<Integer>();
		if ((!ag.isEmpty()) && (ag != null)) {
			nivelHelper(ag,num,lis);
		}
		return lis;
		
	}
	
	private boolean nivelHelper(GeneralTree<Integer> ag, int num, List<Integer> list) {
		list.add(ag.getData());
		
		if (ag.isLeaf()) {			return true;
		}
		
		if (ag.getChildren().size() < num) {
			for (GeneralTree<Integer> child : ag.getChildren()) {
				if (nivelHelper(child,num,list)) {
					return true;
				}
			}
		}
		list.remove(list.size() -1);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
