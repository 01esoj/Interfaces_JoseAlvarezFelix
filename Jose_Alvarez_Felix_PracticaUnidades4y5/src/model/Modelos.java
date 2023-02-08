package model;

import javafx.beans.property.SimpleStringProperty;

public class Modelos {
	
	private final SimpleStringProperty modelo;
	private final SimpleStringProperty especificaciones;
	private final double precio;
	
	public Modelos(String modelo, String especificaciones, double precio) {
		this.modelo = new SimpleStringProperty(modelo);
		this.especificaciones = new SimpleStringProperty(especificaciones);
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public SimpleStringProperty getModeloProperty() {
		return modelo;
	}

	public SimpleStringProperty getEspecificacionesProperty() {
		return especificaciones;
	}
	
	public String getModelo() {
		return modelo.get();
	}

	public void setModelo(String modelo) {
		this.modelo.set(modelo);
	}
	
	public String getEspecificaciones() {
		return especificaciones.get();
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones.set(especificaciones);
	}

	@Override
	public String toString() {
		return "Modelos [modelo=" + modelo + ", especificaciones=" + especificaciones + "]";
	}
}
