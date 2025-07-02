package Parciales;
import TP3.GeneralTree;

public class ParcialProgra3 {
	private GeneralTree<String> ab;
	
	public ParcialProgra3(GeneralTree<String> ab) {
		this.ab = ab;
	}
	
	public GeneralTree<String> tesoroAccesibleMasCercano(GeneralTree<String> camaras) {
		if (!camaras.isEmpty()) {
			GeneralTree<String> nodo = tesoroAccesibleMasCercanoHelper(camaras);
			return nodo;
		}
		else {
			return null;
		}
	}
	
	private GeneralTree<String> tesoroAccesibleMasCercanoHelper(GeneralTree<String> ab) {
		if (ab.getData().equals("Tesoro")) {
			return ab;
		}
		if (ab.getData().equals("Bloqueo")) {
			return null;
		}
		
		for (GeneralTree<String> child : ab.getChildren()) {
			GeneralTree<String> res = tesoroAccesibleMasCercanoHelper(child);
			if (res != null) {
				return res;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
