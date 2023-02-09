package graficos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import view.ControllerSeries;

/**
 * Controlador del grafico que contiene la comparativa de precios de los modelos de la serie q
 * @author Jose Alvarez Felix
 * @version 09/02/2023
 */
public class ControllerPieChart {
	
	private ObservableList<PieChart.Data> pieData;
	
	@FXML
    private PieChart pieChart;
	
	/**
	 * Metodo que recupera los precios de los modelos y los va guardando en el ObservableList
	 * @return Un ObservableList con los datos de los precios
	 */
	public ObservableList<PieChart.Data> loadPieData(){
		
		double mediaA1 = (ControllerSeries.mapaModelos.get("A1").get(0).getPrecio() + ControllerSeries.mapaModelos.get("A1").get(1).getPrecio()) / 2;
		double mediaA3 = (ControllerSeries.mapaModelos.get("A3").get(0).getPrecio() + ControllerSeries.mapaModelos.get("A3").get(1).getPrecio()) / 2;
		double mediaA4 = (ControllerSeries.mapaModelos.get("A4").get(0).getPrecio() + ControllerSeries.mapaModelos.get("A4").get(1).getPrecio() + ControllerSeries.mapaModelos.get("A4").get(2).getPrecio()) / 3;
		double mediaA5 = (ControllerSeries.mapaModelos.get("A5").get(0).getPrecio() + ControllerSeries.mapaModelos.get("A5").get(1).getPrecio() + ControllerSeries.mapaModelos.get("A5").get(2).getPrecio()) / 3;
		double mediaA6 = (ControllerSeries.mapaModelos.get("A6").get(0).getPrecio() + ControllerSeries.mapaModelos.get("A6").get(1).getPrecio() + ControllerSeries.mapaModelos.get("A6").get(2).getPrecio()) / 3;
		double mediaA7 = ControllerSeries.mapaModelos.get("A7").get(0).getPrecio();
		double mediaA8 = (ControllerSeries.mapaModelos.get("A8").get(0).getPrecio() + ControllerSeries.mapaModelos.get("A8").get(1).getPrecio()) / 2;
		
		// Rellenamos los datos del gráfico
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				
                new PieChart.Data("A1", Math.round(mediaA1)),
                new PieChart.Data("A3", Math.round(mediaA3)),
                new PieChart.Data("A4", Math.round(mediaA4)),
                new PieChart.Data("A5", Math.round(mediaA5)),
                new PieChart.Data("A6", Math.round(mediaA6)),
                new PieChart.Data("A7", Math.round(mediaA7)),
                new PieChart.Data("A8", Math.round(mediaA8))
                
                );
		
		return pieChartData;
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
	public void initPieChart() {
		pieChart.setData(pieData);
		
		// Se muestra en cada etiqueta el valor
		for (final PieChart.Data data : pieChart.getData()) {
		    data.setName(data.getName() + "=" + data.getPieValue());
		}
    }
	
	/**
	 * Metodo que devuelve el conjunto de datos del grafico
	 * @return Un ObservableList con datos del grafico
	 */
	public ObservableList<PieChart.Data> getPieData() {
		return pieData;
	}
	
	/**
	 * Metodo que establece el conjunto de datos del grafico
	 * @param pieData ObservableList con datos del grafico
	 */
	public void setPieData(ObservableList<PieChart.Data> pieData) {
		this.pieData = pieData;
	}
}
