package TP2;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> a;
	
	public ContadorArbol(BinaryTree<Integer> unArbol) {
		a = unArbol;
	}
	
	public List<Integer> numerosPares() {
		List <Integer> l = new LinkedList<Integer>();
		if (!a.isEmpty()) this.numPares(l,a);
		return l;
	}
	
	public void numPares(List<Integer> l , BinaryTree<Integer> a) {
			if (a.getData() % 2 == 0) l.add(a.getData());
			if (a.hasLeftChild()) numPares(l,a.getLeftChild());
			if (a.hasRightChild()) numPares(l, a.getRightChild());
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
