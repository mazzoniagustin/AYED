package ttp1.ejercicio7;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int legajo;
	
	public Estudiante(String unNombre, String unApellido, int unLegajo) {
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.legajo = unLegajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public String toString() {
		return ("Nombre: " + this.nombre + " Apellido: " + this.apellido + " Legajo: " + this.legajo);
	}
	
	
}
