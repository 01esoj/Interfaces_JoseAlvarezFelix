package model;

import javafx.beans.property.SimpleStringProperty;

public class Modelos {
	
	private final SimpleStringProperty modelo;
	private final SimpleStringProperty especificaciones;
	
	public Modelos(SimpleStringProperty modelo, SimpleStringProperty especificaciones) {
		super();
		this.modelo = modelo;
		this.especificaciones = especificaciones;
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
}
