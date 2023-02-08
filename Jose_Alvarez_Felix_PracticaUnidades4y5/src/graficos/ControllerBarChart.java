package graficos;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class ControllerBarChart {
	
	private ObservableList<XYChart.Series<String, Number>> dist1;
	
	@FXML
    private BarChart<String, Number> barChart;
	
	public ObservableList<XYChart.Series<String, Number>> loadDist1(){
		List<XYChart.Series<String, Number>> list = new ArrayList<XYChart.Series<String,Number>>();
	
		// Se crean dos series con datos
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("Alumno 1");
		series1.getData().add(new XYChart.Data<String, Number>("DIW", 4));
		series1.getData().add(new XYChart.Data<String, Number>("DI", 8));
		series1.getData().add(new XYChart.Data<String, Number>("PSP", 9));
		series1.getData().add(new XYChart.Data<String, Number>("PDM", 3));
		series1.getData().add(new XYChart.Data<String, Number>("AD", 7));
		series1.getData().add(new XYChart.Data<String, Number>("SGE", 6));
		series1.getData().add(new XYChart.Data<String, Number>("DWEC", 10));
		series1.getData().add(new XYChart.Data<String, Number>("DWES", 3));
        
		// Se crean dos series con datos
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.setName("Alumno 2");
		series2.getData().add(new XYChart.Data<String, Number>("DIW", 10));
		series2.getData().add(new XYChart.Data<String, Number>("DI", 4));
		series2.getData().add(new XYChart.Data<String, Number>("PSP", 7));
		series2.getData().add(new XYChart.Data<String, Number>("PDM", 7));
		series2.getData().add(new XYChart.Data<String, Number>("AD", 5));
		series2.getData().add(new XYChart.Data<String, Number>("SGE", 2));
		series2.getData().add(new XYChart.Data<String, Number>("DWEC", 10));
		series2.getData().add(new XYChart.Data<String, Number>("DWES", 3));
		
		list.add(series1);
		list.add(series2);
		
        return FXCollections.observableArrayList(list);
	}
	
	@FXML
	private void initialize() {
		
	}
	
	public void initBarChart() {
    	barChart.setData(this.dist1);
    }
	
	public ObservableList<XYChart.Series<String, Number>> getDist1() {
		return dist1;
	}

	public void setDist1(ObservableList<XYChart.Series<String, Number>> dist1) {
		this.dist1 = dist1;
	}
}
