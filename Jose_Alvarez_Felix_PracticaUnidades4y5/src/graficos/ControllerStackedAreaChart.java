package graficos;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;

public class ControllerStackedAreaChart {
	
	private ObservableList<XYChart.Series<Number, Number>> dist2;
	
	@FXML
    private StackedAreaChart<Number, Number> stackedAreaChart;
	
	public ObservableList<XYChart.Series<Number, Number>> loadDist2(){
		List<XYChart.Series<Number, Number>> list = new ArrayList<XYChart.Series<Number,Number>>();
	
		// Se crean dos series con datos
		XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
		series1.setName("Web");
		series1.getData().add(new XYChart.Data<Number, Number>(2013, 5, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2014, 7, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2015, 6, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2016, 4, 0.25));
		series1.getData().add(new XYChart.Data<Number, Number>(2017, 8, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2018, 9, 0.35));
		series1.getData().add(new XYChart.Data<Number, Number>(2019, 3, 0.15));
		series1.getData().add(new XYChart.Data<Number, Number>(2020, 9, 0.5));
        
		// Se crean dos series con datos
		XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
		series2.setName("Multiplataforma");
		series2.getData().add(new XYChart.Data<Number, Number>(2013, 8, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2014, 5, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2015, 4, 0.25));
		series2.getData().add(new XYChart.Data<Number, Number>(2016, 7, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2017, 7, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2018, 5, 0.35));
		series2.getData().add(new XYChart.Data<Number, Number>(2019, 9, 0.5));
		series2.getData().add(new XYChart.Data<Number, Number>(2020, 4, 0.25));
		
		list.add(series1);
		list.add(series2);
		
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
