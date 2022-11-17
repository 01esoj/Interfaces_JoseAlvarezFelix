package view;

import javafx.beans.property.SimpleStringProperty;

public class Modelos {
	
	private final SimpleStringProperty seriesACol;
	private final SimpleStringProperty seriesQCol;
	private final SimpleStringProperty otrasSeriesCol;
	
	public Modelos(String seriesACol, String seriesQCol, String otrasSeriesCol) {
		this.seriesACol = new SimpleStringProperty(seriesACol);
		this.seriesQCol = new SimpleStringProperty(seriesQCol);
		this.otrasSeriesCol = new SimpleStringProperty(otrasSeriesCol);
	}

	public SimpleStringProperty getSeriesACol() {
		return seriesACol;
	}

	public SimpleStringProperty getSeriesQCol() {
		return seriesQCol;
	}

	public SimpleStringProperty getOtrasSeriesCol() {
		return otrasSeriesCol;
	}
	
	public String getSeriesA() {
        return seriesACol.get();
    }
    
    public void setSeriesA(String seriesA) {
    	seriesACol.set(seriesA);
    }
    
    public String getSeriesQ() {
        return seriesQCol.get();
    }
    
    public void setSeriesQ(String seriesQ) {
    	seriesQCol.set(seriesQ);
    }
    
    public String getOtrasSeries() {
        return otrasSeriesCol.get();
    }
    
    public void setOtrasSeries(String otrasSeries) {
    	otrasSeriesCol.set(otrasSeries);
    }
}
