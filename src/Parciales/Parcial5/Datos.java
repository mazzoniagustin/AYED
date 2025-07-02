package Parciales.Parcial5;
import java.util.*;

public class Datos {
	private int cant;
	private List<Integer> lista;
	
	public Datos(List<Integer> lista, int cantidad) {
		this.cant = cantidad;
		this.lista = lista;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public List<Integer> getLista() {
		return lista;
	}

	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}
	
	

}
