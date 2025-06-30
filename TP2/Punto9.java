package TP2;
import TP2.BinaryTree;
public class Punto9 {
	private BinaryTree <Integer> arbol;
	
	public BinaryTree<sad> sumAndDid(BinaryTree<Integer> Ab) {
		if (!Ab.isEmpty()) {
			BinaryTree<sad> nuevoAb = new BinaryTree<sad>();
			sumDifHelper(Ab,nuevoAb,0,null);
			return nuevoAb;
		}
		else {
			return null;
		}
	}
	
	private void sumDifHelper(BinaryTree<Integer> original, BinaryTree<sad> sumDif, int sumaAcumulada, Integer padre) {
		int valorActual = original.getData();
		int suma = valorActual + sumaAcumulada;
		int dif;
		if (padre == null) {
			dif = 0;
		}
		else {
			dif = valorActual - padre;
		}
		sumDif.setData(new sad(suma,dif));
		if (original.hasLeftChild()) {
			BinaryTree<sad> leftC = new BinaryTree<sad>();
			sumDif.addLeftChild(leftC);
			sumDifHelper(original.getLeftChild(),leftC,suma,valorActual);
		}
		if (original.hasRightChild()) {
			BinaryTree<sad> rightC = new BinaryTree<sad>();
			sumDif.addRightChild(rightC);
			sumDifHelper(original.getRightChild(),rightC,suma,valorActual);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
