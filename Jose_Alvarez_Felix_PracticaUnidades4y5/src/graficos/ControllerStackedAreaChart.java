package graficos;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import view.ControllerSeries;

public class ControllerStackedAreaChart {
	
	private ObservableList<XYChart.Series<Number, Number>> dist2;
	
	@FXML
    private StackedAreaChart<Number, Number> stackedAreaChart;
	
	public ObservableList<XYChart.Series<Number, Number>> loadDist2(){
		List<XYChart.Series<Number, Number>> list = new ArrayList<XYChart.Series<Number,Number>>();

		XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
		series1.setName("Primer modelo");
		series1.getData().add(new XYChart.Data<Number, Number>(1, ControllerSeries.mapaModelos.get("e-tron GT").get(0).getPrecio(), 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2, ControllerSeries.mapaModelos.get("e-tron").get(0).getPrecio(), 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(3, ControllerSeries.mapaModelos.get("TT").get(0).getPrecio(), 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(4, ControllerSeries.mapaModelos.get("R8").get(0).getPrecio(), 0.25));
		series1.getData().add(new XYChart.Data<Number, Number>(5, ControllerSeries.mapaModelos.get("RS").get(0).getPrecio(), 0.35));
        
		XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
		series2.setName("Segundo modelo");
		series2.getData().add(new XYChart.Data<Number, Number>(2, ControllerSeries.mapaModelos.get("e-tron").get(1).getPrecio(), 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(3, ControllerSeries.mapaModelos.get("TT").get(1).getPrecio(), 0.25));
		series2.getData().add(new XYChart.Data<Number, Number>(4, ControllerSeries.mapaModelos.get("R8").get(1).getPrecio(), 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(5, ControllerSeries.mapaModelos.get("RS").get(1).getPrecio(), 0.35));
		
		XYChart.Series<Number, Number> series3 = new XYChart.Series<Number, Number>();
		series3.setName("Tercer modelo");
		series3.getData().add(new XYChart.Data<Number, Number>(5, ControllerSeries.mapaModelos.get("RS").get(2).getPrecio(), 0.35));
		
		XYChart.Series<Number, Number> series4 = new XYChart.Series<Number, Number>();
		series4.setName("Cuarto modelo");
		series4.getData().add(new XYChart.Data<Number, Number>(5, ControllerSeries.mapaModelos.get("RS").get(3).getPrecio(), 0.35));
		
		list.add(series1);
		list.add(series2);
		list.add(series3);
		list.add(series4);
		
        return FXCollections.observableArrayList(list);
	}
	
	@FXML
	private void initialize() {
		
	}
	
	public void initStackedAreaChart() {
		stackedAreaChart.setData(this.dist2);
	}
	
	public ObservableList<XYChart.Series<Number, Number>> getDist2() {
		return dist2;
	}

	public void setDist2(ObservableList<XYChart.Series<Number, Number>> dist2) {
		this.dist2 = dist2;
	}
}
