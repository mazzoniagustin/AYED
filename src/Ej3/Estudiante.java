package Ej3;

import ttp1.ejercicio7.Persona;

public class Estudiante extends Persona {
	private String comision;
	private String direccion;
	
	public Estudiante(String unaComision, String unaDirec) {
		super();
		comision = unaComision;
		direccion = unaDirec;
		
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString() {
		return super.toString() + " Comision: " + getComision() + " Direccion: " + getDireccion();
	}


}
