package TP2;
import TP2.BinaryTree;

public class ProfundidadArbolBinario {
	private BinaryTree<Integer> ab;
	
	public ProfundidadArbolBinario (BinaryTree<Integer> unAb) {
		this.ab = unAb;
	}	
		public int sumaElementosProfundidad(int num) {
			if (!ab.isEmpty()) {
				return sumaElementos(ab,num,0);
			}
			else {
				return 0;
			}
		}
		private int sumaElementos (BinaryTree<Integer> ab, int num, int profundidad) {
			int suElementos = 0;
			if (num == profundidad) {
				return ab.getData();
			}
			else {
				if ((ab.hasLeftChild()) && (profundidad < num)) {
					suElementos += sumaElementos(ab.getLeftChild(),num,profundidad + 1);
				}
				if ((ab.hasRightChild()) && (profundidad < num)) {
					suElementos += sumaElementos(ab.getRightChild(),num,profundidad + 1);
				}
				return suElementos;
			}
		}

	public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ProfundidadArbolBinario prof = new ProfundidadArbolBinario(ab);
        System.out.println(prof.sumaElementosProfundidad(2));

	}

}
