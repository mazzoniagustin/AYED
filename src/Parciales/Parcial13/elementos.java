package Parciales.Parcial13;

public class elementos {
	private int sumaTotal;
	private int negativos;
	private int positivos;
	
	
	public elementos() {
		this.sumaTotal = 0;
		this.negativos = 0;
		this.positivos = 0;
		
	}


	public int getSumaTotal() {
		return sumaTotal;
	}


	public void setSumaTotal(int sumaTotal) {
		this.sumaTotal = sumaTotal;
	}


	public int getNegativos() {
		return negativos;
	}


	public void setNegativos(int negativos) {
		this.negativos = negativos;
	}


	public int getPositivos() {
		return positivos;
	}


	public void setPositivos(int positivos) {
		this.positivos = positivos;
	}
	
	public void sumaPositivos(int valor) {
		this.positivos += valor;
	}
	
	public void sumaNegativos(int valor) {
		this.negativos += valor;
	}
	
	public void agregarTotal(int valor) {
		this.sumaTotal += valor;
	}
	
	
}
