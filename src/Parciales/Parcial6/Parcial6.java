package Parciales.Parcial6;
import TP2.BinaryTree;

public class Parcial6 {
	BinaryTree<Personaje> ab;
	
	public Parcial6 (BinaryTree<Personaje> ab) {
		this.ab = ab;
	}
	
	public Personaje princesaAccesible() {
		if (!ab.isEmpty()) {
			return princesaAccesibleHelper(ab);
		}
		else {
			return null;
		}
	}
	
	private Personaje princesaAccesibleHelper(BinaryTree<Personaje> ab) {
		if (ab.getData().esPrincesa()) {
			return ab.getData();
		}
		if (ab.getData().esDragon()) {
			return null;
		}
		
		Personaje aux = null;
		if (ab.hasLeftChild()) {
			aux = princesaAccesibleHelper(ab.getLeftChild());
		}
		if ((ab.hasRightChild() && aux == null)) {
			aux = princesaAccesibleHelper(ab.getRightChild());
		}
		return aux;
			
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
