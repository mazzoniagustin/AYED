package Parciales.Parcial17;

public class datos {
	private int suma;
	private int cant;
	private double prom;
	
	public datos() {
		this.suma = 0;
		this.cant = 0;
		this.prom = 0.0;
	}
	
	public void incrementarSuma(int valor) {
		this.suma += valor;
		cant++;
	}
	
	public double getProm() {
		this.prom = this.suma / this.cant;
		return this.prom;
	}
	
	public int getSuma() {
		return this.suma;
	}
	
	public int getCantidad() {
		return this.cant;
	}
}
