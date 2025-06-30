package Parciales.Parcial6;

public class Personaje {
	private String tipo;
	private String nombre;
	
	public Personaje(String unTipo, String unNombre) {
		this.tipo = unTipo;
		this.nombre = unNombre;
	}
	
	public boolean esDragon() {
		return this.tipo.equals("Dragon");
	}
	
	public boolean esPrincesa() {
		return this.tipo.equals("Princesa");
	}

}
