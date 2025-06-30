package Parciales.Parcial5;
import TP2.BinaryTree;
import java.util.*;

public class ProcesadorDeArbol {
	private BinaryTree<Integer> ab;
	
	public ProcesadorDeArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public Datos procesar(BinaryTree<Integer> ab) {
		int cantidad = 0;
		List<Integer> list = new LinkedList<Integer>();
		if ((!ab.isEmpty()) && (ab != null)) {
			cantidad = procesarHelper(ab,list);
		}
		Datos dato = new Datos(list,cantidad);
		return dato;
	}
	
	private int procesarHelper(BinaryTree<Integer> ab, List<Integer> list) {
		int cant = 0;
		if (ab.hasLeftChild()) {
			cant += procesarHelper(ab.getLeftChild(),list);
		}
		if (ab.hasRightChild()) {
			cant += procesarHelper(ab.getRightChild(),list);
		}
		if (ab.getData() % 2 != 0) {
			cant++;
			if ((ab.hasLeftChild() && (!ab.hasRightChild())) || ((!ab.hasLeftChild()) && ab.hasRightChild())) {
				list.add(ab.getData());
			}
		}
		return cant;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
