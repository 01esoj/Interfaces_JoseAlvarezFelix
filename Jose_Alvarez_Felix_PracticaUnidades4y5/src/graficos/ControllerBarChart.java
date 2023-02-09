package graficos;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import view.ControllerSeries;

/**
 * Controlador del grafico que contiene la comparativa de precios de los modelos de la serie a
 * @author Jose Alvarez Felix
 * @version 09/02/2023
 */
public class ControllerBarChart {
	
	private ObservableList<XYChart.Series<String, Number>> dist1;
	
	@FXML
    private BarChart<String, Number> barChart;
	
	/**
	 * Metodo que recupera los precios de los modelos y los va guardando en el ObservableList
	 * @return Un ObservableList con los datos de los precios
	 */
	public ObservableList<XYChart.Series<String, Number>> loadDist1(){
		List<XYChart.Series<String, Number>> list = new ArrayList<XYChart.Series<String,Number>>();
		
		// Se crean dos series con datos
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("Primer modelo");
		series1.getData().add(new XYChart.Data<String, Number>("Q2", ControllerSeries.mapaModelos.get("Q2").get(0).getPrecio() ));
		series1.getData().add(new XYChart.Data<String, Number>("Q3", ControllerSeries.mapaModelos.get("Q3").get(0).getPrecio() ));
		series1.getData().add(new XYChart.Data<String, Number>("Q4 e-tron", ControllerSeries.mapaModelos.get("Q4 e-tron").get(0).getPrecio() ));
		series1.getData().add(new XYChart.Data<String, Number>("Q5", ControllerSeries.mapaModelos.get("Q5").get(0).getPrecio() ));
		series1.getData().add(new XYChart.Data<String, Number>("Q7", ControllerSeries.mapaModelos.get("Q7").get(0).getPrecio() ));
		series1.getData().add(new XYChart.Data<String, Number>("Q8", ControllerSeries.mapaModelos.get("Q8").get(0).getPrecio() ));

		// Se crean dos series con datos
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.setName("Segundo modelo");
		series2.getData().add(new XYChart.Data<String, Number>("Q3", ControllerSeries.mapaModelos.get("Q3").get(1).getPrecio() ));
		series2.getData().add(new XYChart.Data<String, Number>("Q4 e-tron", ControllerSeries.mapaModelos.get("Q4 e-tron").get(1).getPrecio() ));
		series2.getData().add(new XYChart.Data<String, Number>("Q5", ControllerSeries.mapaModelos.get("Q5").get(1).getPrecio() ));
		series2.getData().add(new XYChart.Data<String, Number>("Q8", ControllerSeries.mapaModelos.get("Q8").get(1).getPrecio() ));
		
		XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
		series3.setName("Tercer modelo");
		series3.getData().add(new XYChart.Data<String, Number>("Q3", ControllerSeries.mapaModelos.get("Q3").get(2).getPrecio() ));
		
		list.add(series1);
		list.add(series2);
		list.add(series3);
		
        return FXCollections.observableArrayList(list);
	}
	
	/**
     * Metodo para inicializar el controlador que se llama cuando se carga el FXML
     */
	@FXML
	private void initialize() {
		
	}
	 
	/**
	 * Inicializa el grafico con los datos proporcionados
	 */
	public void initBarChart() {
    	barChart.setData(this.dist1);
    }
	
	/**
	 * Metodo que devuelve el conjunto de datos del grafico
	 * @return Un ObservableList con datos del grafico
	 */
	public ObservableList<XYChart.Series<String, Number>> getDist1() {
		return dist1;
	}
	
	/**
	 * Metodo que establece el conjunto de datos del grafico
	 * @param dist1 ObservableList con datos del grafico
	 */
	public void setDist1(ObservableList<XYChart.Series<String, Number>> dist1) {
		this.dist1 = dist1;
	}
}
