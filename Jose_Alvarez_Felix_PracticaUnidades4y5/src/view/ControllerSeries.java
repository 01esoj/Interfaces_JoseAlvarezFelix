package view;

import java.io.IOException;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Modelos;

public class ControllerSeries {
	
	@FXML
    private Button botonComprar;

    @FXML
    private TableColumn<Modelos, String> columnaEspecificaciones;

    @FXML
    private TableColumn<Modelos, String> columnaModelos;

    @FXML
    private ComboBox<String> comboColor;

    @FXML
    private TextField filtrarEspecificaciones;

    @FXML
    private TextField filtrarModelo;

    @FXML
    private TextField modeloTextField;

    @FXML
    private TextField precioTextField;

    @FXML
    private TextField serieTextField;

    @FXML
    private TableView<Modelos> tablaModelos;
    
    private static Stage dialogStage;


    private ObservableList<Modelos> datosModelosA1 = FXCollections.observableArrayList(
    		new Modelos("A1 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("A1 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosA3 = FXCollections.observableArrayList(
    		new Modelos("A3 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("A3 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosA4 = FXCollections.observableArrayList(
    		new Modelos("A4 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("A4 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosA5 = FXCollections.observableArrayList(
    		new Modelos("A5 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("A5 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosA6 = FXCollections.observableArrayList(
    		new Modelos("A6 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("A6 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosA7 = FXCollections.observableArrayList(
    		new Modelos("A7 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("A7 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosA8 = FXCollections.observableArrayList(
    		new Modelos("A8 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("A8 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosQ2 = FXCollections.observableArrayList(
    		new Modelos("q2 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("q2 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosQ3 = FXCollections.observableArrayList(
    		new Modelos("q3 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("q3 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosQ4 = FXCollections.observableArrayList(
    		new Modelos("q4 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("q4 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosQ5 = FXCollections.observableArrayList(
    		new Modelos("q5 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("q5 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosQ7 = FXCollections.observableArrayList(
    		new Modelos("q7 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("q7 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosQ8 = FXCollections.observableArrayList(
    		new Modelos("q8 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("q8 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosEtronGT = FXCollections.observableArrayList(
    		new Modelos("etgt Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("etgt Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosEtron = FXCollections.observableArrayList(
    		new Modelos("et Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("et Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosTT = FXCollections.observableArrayList(
    		new Modelos("tt Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("tt Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosRS = FXCollections.observableArrayList(
    		new Modelos("rs Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("rs Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosR8 = FXCollections.observableArrayList(
    		new Modelos("r8 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("r8 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

    private ObservableList<Modelos> datosModelosS = FXCollections.observableArrayList(
    		new Modelos("s Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152 128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 35000),
    		new Modelos("s Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155 123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 35000)
		);

	private ObservableList<Modelos> filtroDatosModelos = FXCollections.observableArrayList();
	
	private HashMap<String, ObservableList<Modelos>> mapaModelos = new HashMap<>();
	
	private void guardarModelos() {
		mapaModelos.put("A1", datosModelosA1);
		mapaModelos.put("A3", datosModelosA3);
		mapaModelos.put("A4", datosModelosA4);
		mapaModelos.put("A5", datosModelosA5);
		mapaModelos.put("A6", datosModelosA6);
		mapaModelos.put("A7", datosModelosA7);
		mapaModelos.put("A8", datosModelosA8);
		mapaModelos.put("Q2", datosModelosQ2);
		mapaModelos.put("Q3", datosModelosQ3);
		mapaModelos.put("Q4 e-tron", datosModelosQ4);
		mapaModelos.put("Q5", datosModelosQ5);
		mapaModelos.put("Q7", datosModelosQ7);
		mapaModelos.put("Q8", datosModelosQ8);
		mapaModelos.put("e-tron GT", datosModelosEtronGT);
		mapaModelos.put("e-tron", datosModelosEtron);
		mapaModelos.put("TT", datosModelosTT);
		mapaModelos.put("RS", datosModelosRS);
		mapaModelos.put("R8", datosModelosR8);
		mapaModelos.put("S", datosModelosS);
	}
	
	@FXML
    private void initialize() {
		guardarModelos();
		
		if(tablaModelos!=null) {
    		columnaModelos.setCellValueFactory(cellData -> cellData.getValue().getModeloProperty());
	    	columnaEspecificaciones.setCellValueFactory(cellData -> cellData.getValue().getEspecificacionesProperty());
	    	
	    	tablaModelos.setItems(mapaModelos.get(ControllerApp.getModeloActual()));
	    	
	    	mostrarModeloElegido(null);
	    	
	    	tablaModelos.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> mostrarModeloElegido(newValue));
    	}
	}
	
    @FXML
    private void filtrarModelo(KeyEvent event) {
    	String filtroModelo = filtrarModelo.getText();
		
		if(filtroModelo.isEmpty()) {
			tablaModelos.setItems(mapaModelos.get(ControllerApp.getModeloActual()));
		}else {
			filtroDatosModelos.clear();
			
			for(Modelos m: mapaModelos.get(ControllerApp.getModeloActual())) {
				if(m.getModelo().toLowerCase().contains(filtroModelo.toLowerCase())) {
					filtroDatosModelos.add(m);
				}
			}
			columnaModelos.setCellValueFactory(cellData -> cellData.getValue().getModeloProperty());
			tablaModelos.setItems(filtroDatosModelos);
		}
    }
    
    @FXML
    private void filtrarEspecificaciones(KeyEvent event) {
    	String filtroEspecificaciones = filtrarEspecificaciones.getText();
		
		if(filtroEspecificaciones.isEmpty()) {
			tablaModelos.setItems(mapaModelos.get(ControllerApp.getModeloActual()));
		}else {
			filtroDatosModelos.clear();
			
			for(Modelos m: mapaModelos.get(ControllerApp.getModeloActual())) {
				if(m.getEspecificaciones().toLowerCase().contains(filtroEspecificaciones.toLowerCase())) {
					filtroDatosModelos.add(m);
				}
			}
			columnaEspecificaciones.setCellValueFactory(cellData -> cellData.getValue().getEspecificacionesProperty());
			tablaModelos.setItems(filtroDatosModelos);
		}
    }
    
    @FXML
    private void handleComprar(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("ModeloDialog.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			
			dialogStage = new Stage();
	        dialogStage.setTitle("Realizar pago");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(listadoControles);
	        dialogStage.setScene(scene);
	        
	        dialogStage.showAndWait();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
    }
    
    private void mostrarModeloElegido(Modelos modelo) {
        
		if (modelo != null) {
        	if(modelo.getModelo().equals( mapaModelos.get(ControllerApp.getModeloActual()).get(0).getModelo() )) {
        		serieTextField.setText("Serie "+ControllerApp.getModeloActual());
        		modeloTextField.setText(modelo.getModelo());
        		precioTextField.setText(modelo.getPrecio()+" €");
        		
        		comboColor.getItems().addAll("Negro metalizado", "Gris efecto perla", "Azul metalizado", "Blanco glaciar", "Blanco cortina", "Plata metalizado", "Rojo efecto perla", "Amarillo piton", "Gris metalizado");
        	}else if(modelo.getModelo().equals( mapaModelos.get(ControllerApp.getModeloActual()).get(1).getModelo() )){
        		serieTextField.setText("Serie "+ControllerApp.getModeloActual());
        		modeloTextField.setText(modelo.getModelo());
        		precioTextField.setText(modelo.getPrecio()+" €");
        		
        		comboColor.getItems().addAll("Negro metalizado", "Gris efecto perla", "Azul metalizado", "Blanco glaciar", "Rojo efecto perla", "Amarillo piton");
        	}
        	comboColor.setValue("Color");
        } else {
        	serieTextField.setText("");
        	modeloTextField.setText("");
            precioTextField.setText("");
        }
    }
    
    public static Stage getDialogStage() {
		return dialogStage;
	}
}
