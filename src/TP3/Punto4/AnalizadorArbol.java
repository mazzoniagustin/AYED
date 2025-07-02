package TP3.Punto4;
import TP3.GeneralTree;
import TP2.Queue;
import java.util.*;

public class AnalizadorArbol {
	
	public double devovlverPromedio(GeneralTree<AreaEmpresa> arbol) {
		if (!arbol.isEmpty()) {
			return calcularPromedio(arbol);
		}
		else {
			return -1;
		}
	}
	
	private double calcularPromedio (GeneralTree<AreaEmpresa> arbol) {
		int cant = 0;
		int prom;
		int max = -1;
		int total = 0;
		
		GeneralTree<AreaEmpresa> aux;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		
		cola.enqueue(arbol);
		cola.enqueue(null);
		
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			
			if (aux != null) {
				
				List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
				
				for (GeneralTree<AreaEmpresa> child: children) {
					cola.enqueue(child);
				}
				
				total += aux.getData().getTardanza();
				cant++;
			
				
			}
			else {
				if (!cola.isEmpty()) {
					
					cola.enqueue(null);
					prom = total/cant;
					
					if (prom > max) {
						max = prom;
					}
					cant = 0; total = 0;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13), children1);
        
        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25), children2);
        
        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10), children3);
        
        List<GeneralTree<AreaEmpresa>> children4 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14), children4);
        
        AnalizadorArbol arb = new AnalizadorArbol();
        System.out.println("MIO El mayor promedio entre todos los valores promedios de los niveles es: " + arb.devovlverPromedio(a));
    }

	}

