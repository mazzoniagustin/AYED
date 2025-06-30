package Parciales;
import TP3.GeneralTree;
public class Parcial12 {
	private GeneralTree<Integer> ab;
	
	public Parcial12(GeneralTree<Integer> ab) {
		this.ab = ab;
	}
	
	public int retornarMayor (GeneralTree<Integer> ab) {
		int max = -1;
		if (!ab.isEmpty()) {
			max = retornarMayorHelper(GeneralTree<Integer> ab, -1);
		}
		return max;
	}
	
	private int retornarMayorHelper(GeneralTree<Integer> ab) {
		int max = -1;
		for (GeneralTree<Integer> child : ab.getChildren()) {
			int maxHijo = retornarMayorHelper(child);
			if (maxHijo > max) {
				max = maxHijo;
			}
		}
		if (ab.getData() > max) {
			max = ab.getData();
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
