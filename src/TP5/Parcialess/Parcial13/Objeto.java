package TP5.Parcialess.Parcial13;

public class Objeto {
	private int cantidad;
	private boolean popular;
	
	public Objeto(int cantidad, boolean popular) {
		this.cantidad = cantidad;
		this.popular = popular;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isPopular() {
		return popular;
	}

	public void setPopular(boolean popular) {
		this.popular = popular;
	}
	
	public void esPopular(int valor) {
		if (this.cantidad >= valor) {
			setPopular(true);
		}
	}
	
	public void aumentarCant() {
		this.cantidad++;
	}

}
