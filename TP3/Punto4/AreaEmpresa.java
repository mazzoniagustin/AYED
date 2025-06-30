package TP3.Punto4;

public class AreaEmpresa {
	private String area;
	private int tardanza;
	
	public AreaEmpresa(String unArea , int unaTardanza) {
		this.area = unArea;
		this.tardanza = unaTardanza;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getTardanza() {
		return tardanza;
	}

	public void setTardanza(int tardanza) {
		this.tardanza = tardanza;
	}
	
	
}
