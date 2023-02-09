package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Clase POJO de los modelos de coche
 * @author Jose Alvarez Felix
 * @version 09/02/2023
 */
public class Modelos {
	
	private final SimpleStringProperty modelo;
	private final SimpleStringProperty especificaciones;
	private final double precio;
	
	/**
	 * Constructor que crea los objetos Modelos
	 * @param modelo Parametro con el nombre del modelo
	 * @param especificaciones Parametro con las especificaciones del modelo
	 * @param precio Parametro con el precio del modelo
	 */
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
	
	/**
	 * Metodo que devuelve la informacion del modelo
	 */
	@Override
	public String toString() {
		return "Modelos [modelo=" + modelo + ", especificaciones=" + especificaciones + "]";
	}
}
