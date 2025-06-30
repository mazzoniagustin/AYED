package TP2;
import java.util.*;
import TP2.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int leftC = 0;
		int rightC = 0;
		if (this.isEmpty()) {
		   return 0;
	   }
	   else if (this.isLeaf()) {
			   return 1;
		   }
		
	   else {
		   if (this.hasLeftChild()) {
		   leftC = this.getLeftChild().contarHojas();
	   }
		   if (this.hasRightChild()) {
			   rightC = this.getRightChild().contarHojas();
		   }
		   return rightC + leftC;
	}
}
		
		
    	 
	 /* public BinaryTree<T> espejo(){
    	BinaryTree<T> nuevoAb = new BinaryTree<T>(this.getData());
    	if (this.hasLeftChild()) {
    		nuevoAb.addRightChild(this.getLeftChild().espejo());
    	}
    	if (this.hasRightChild()) {
    		nuevoAb.addLeftChild(this.getRightChild().espejo());
    	}
    	return nuevoAb;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (this.isEmpty() || n < 0 || m < n) return; // Si esta vacia, no hace nada
	    Queue<BinaryTree<T>> cola = new LinkedList<T>; // Se crea una cola
	    cola.add(this); // raiz del arbol.
	    int nivelActual = 0;
	        
	    while(!cola.isEmpty()) { // mientras que no esté vacia
	    	int nodoNivel = cola.size(); // se obtiene la cantidad de nodos en el nivel actual
	        if(nivelActual >=n && nivelActual <= m) { // si cumplen la condicion
	        for(int i=0; i < nodoNivel; i++) {
	        	BinaryTree<T> nodo = cola.remove(); // se procesa el nodo, eliminandolo de la cola
	        	System.out.print(nodo.getData() + " | "); // se imprime este nuevo nodo
	            if(nodo.hasLeftChild()) cola.add(nodo.getLeftChild()); // si tiene hijos, se agregan a la cola
	            if(nodo.hasRightChild()) cola.add(nodo.getRightChild());
	            }
	            } else {
	                for(int i=0; i < nodoNivel; i++) {
	                    cola.remove(); // se descarta fuera del rango
	                }
	            }
	            nivelActual++;
	            System.out.println("");
	        }
	    }
		
   } */
		
}

