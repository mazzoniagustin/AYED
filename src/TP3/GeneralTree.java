package TP3;
import TP2.Queue;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();
	
	public GeneralTree() {

	}
	
	public GeneralTree(T data) {
		this.data = data;
	}
	
	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this.data = data;
		this.children = children;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<GeneralTree<T>> getChildren() {
		return children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null) {
			this.children = children;
		}
	}
	
	public void addChild (GeneralTree<T> child) {
		this.getChildren().add(child);
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}
	
	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			children.remove(child);
		}
	}
	
	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public int altura() {
		if (!isEmpty()) {
			return alt();
		}
		else {
			return -1;
		}
	}
	
	private int alt() {
		if (this.isLeaf()) {
			return 0;
		}
		else {
			int alturaMax = -1;
			int cant;
			List<GeneralTree<T>> children = this.getChildren();
			for (GeneralTree<T> child: children) {
				cant = 0;
				cant += child.alt();
				if (cant > alturaMax) {
					alturaMax = cant;
				}
			}
			return alturaMax + 1;
		}
	}
	
	public int nivel (T dato) {
		if (this.isEmpty()) {
			return -1;
		}
		else {
			return nivelHelper(this,dato,0);
		}
	}
	
	private int nivelHelper(GeneralTree<T> ag, T dato, int nivelAct) {
		if (ag.getData().equals(dato)) {
			return nivelAct;
		}
		else {
			List<GeneralTree<T>> children = ag.getChildren();
			for (GeneralTree<T> child: children) {
				int res = nivelHelper(child, dato, nivelAct + 1);
				if (res != -1) {
					return res;
				}
				
			}
		}
		return -1;
	}
	
	public int ancho() {
		if (this.isEmpty()) {
			return 0;
		}
		else {
			return anchoHelper();
		}
	}
	
	private int anchoHelper() {
	    int cant = 0;
	    int max = -1;
	    GeneralTree<T> aux;
	    Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();

	    cola.enqueue(this);
	    cola.enqueue(null); // Separador de nivel

	    while (!cola.isEmpty()) {
	        aux = cola.dequeue();

	        if (aux != null) {
	            cant++;
	            List<GeneralTree<T>> children = aux.getChildren();
	            for (GeneralTree<T> child : children) {
	                cola.enqueue(child);
	            }
	        } else {
	            if (cant > max) {
	                max = cant;
	            }
	            cant = 0;

	            if (!cola.isEmpty()) {
	                cola.enqueue(null); // Agrega separador para siguiente nivel
	            }
	        }
	    }

	    return max;
	}
	
	public List<Integer> numerosImparesMayoresQuePreOrden(Integer n) {
		List<Integer> l = new LinkedList<Integer>();
		if (this.isEmpty()) {
			return l;
		}
		else {
			numImpPreHelper(l,n);
			return l;
		}
	}
	
	private void numImpPreHelper(List<Integer> l , Integer n) {
		int data = (Integer) this.getData();
		if (data % 2 != 0 && data > n) {
			l.add(data);
		}
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child : children) {
			child.numImpPreHelper(l, n);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrder(Integer n) {
		List<Integer> l = new LinkedList<Integer>();
		if (this.isEmpty()) {
			return l;
		}
		else {
			numImpInHelper(l,n);
			return l;
		}
	}
	
	private void numImpInHelper(List<Integer> l , Integer n) {
		List<GeneralTree<T>> children = this.getChildren();
		if (this.hasChildren()) {
			children.get(0).numImpInHelper(l, n);
		}
		int data = (Integer) this.getData();
		if (data % 2 != 0 && data > n) {
			l.add(data);
		}
		for (GeneralTree<T> child : children) {
			child.numImpInHelper(l, n);
		}
	}
	
	
}
	