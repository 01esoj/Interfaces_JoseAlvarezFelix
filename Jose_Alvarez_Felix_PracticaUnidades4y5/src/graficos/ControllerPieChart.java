package graficos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class ControllerPieChart {
	
	private ObservableList<PieChart.Data> pieData;
	
	@FXML
    private PieChart pieChart;
	
	public ObservableList<PieChart.Data> loadPieData(){
		// Rellenamos los datos del gráfico
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("DIW", 7),
                new PieChart.Data("DI", 6),
                new PieChart.Data("PSP", 8),
                new PieChart.Data("PDM", 5),
                new PieChart.Data("AD", 6),
                new PieChart.Data("SGE", 4),
                new PieChart.Data("DWEC", 10),
                new PieChart.Data("DWES", 3));
		
		return pieChartData;
	}
	
	@FXML
	private void initialize() {
		
	}
	
	public void initPieChart() {
		pieChart.setData(pieData);
		
		// Se muestra en cada etiqueta el valor
		for (final PieChart.Data data : pieChart.getData()) {
		    data.setName(data.getName() + "=" + data.getPieValue());
		}
    }
	
	public ObservableList<PieChart.Data> getPieData() {
		return pieData;
	}

	public void setPieData(ObservableList<PieChart.Data> pieData) {
		this.pieData = pieData;
	}
}
