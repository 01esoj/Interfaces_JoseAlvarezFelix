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

/**
 * Controlador de la pantalla que muestra la serie elegida con sus modelos correspondientes
 * @author Jose Alvarez Felix
 * @version 09/02/2023
 */
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

    private static ObservableList<Modelos> datosModelosA1 = FXCollections.observableArrayList(
    		new Modelos("A1 Allstreet", "Consumo de combustible: 6,7-5,7 l/100km \nEmision combinada de CO2: 152-128 g/km \nVelocidad maxima: 182 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Super 95", 27210),
    		new Modelos("A1 Sportback", "Consumo de combustible: 6,8-5,4 l/100km \nEmision combinada de CO2: 155-123 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Super 95", 24660)
		);

    private static ObservableList<Modelos> datosModelosA3 = FXCollections.observableArrayList(
    		new Modelos("A3 Sportback", "Consumo de combustible: 6,2-4,3 l/100km \nEmision combinada de CO2: 141-113 g/km \nVelocidad maxima: 206 km/h \nAceleracion 0-100 km/h: 10,1 s \nTipo de combustible: Diesel", 30120),
    		new Modelos("A3 Sedan", "Consumo de combustible: 6,1–4,2 l/100km \nEmision combinada de CO2: 138–110 g/km \nVelocidad maxima: 210 km/h \nAceleracion 0-100 km/h: 10,1 s \nTipo de combustible: Diesel", 32230)
		);

    private static ObservableList<Modelos> datosModelosA4 = FXCollections.observableArrayList(
    		new Modelos("A4", "Consumo de combustible: 8.2-10.2 l/100km \nEmision combinada de CO2: 185-225 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 7,3 s \nTipo de combustible: Gasolina o diesel", 45570),
    		new Modelos("A4 Avant", "Consumo de combustible: 8.2-9.9 l/100km \nEmision combinada de CO2: 185-214 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 7,2 s \nTipo de combustible: Gasolina o diesel", 49540),
    		new Modelos("A4 allroad quattro", "Consumo de combustible: 7.3-9.2 l/100km \nEmision combinada de CO2: 158-195 g/km \nVelocidad maxima: 235 km/h \nAceleracion 0-100 km/h: 7,2 s \nTipo de combustible: Gasolina o diesel", 56050)
		);

    private static ObservableList<Modelos> datosModelosA5 = FXCollections.observableArrayList(
    		new Modelos("A5 Coupe", "Consumo de combustible: 7,8-9,8 l/100km \nEmision combinada de CO2: 175-209 g/km \nVelocidad maxima: 243 km/h \nAceleracion 0-100 km/h: 7 s \nTipo de combustible: Gasolina", 53430),
    		new Modelos("A5 Sportback", "Consumo de combustible: 7,5-9,7 l/100km \nEmision combinada de CO2: 170-209 g/km \nVelocidad maxima: 234 km/h \nAceleracion 0-100 km/h: 7,1 s \nTipo de combustible: Gasolina", 57290),
    		new Modelos("A5 Cabrio", "Consumo de combustible: 8,3-10,2 l/100km \nEmision combinada de CO2: 191-225 g/km \nVelocidad maxima: 225 km/h \nAceleracion 0-100 km/h: 7,3 s \nTipo de combustible: Gasolina", 61280)

		);

    private static ObservableList<Modelos> datosModelosA6 = FXCollections.observableArrayList(
    		new Modelos("A6", "Consumo de combustible: 7,6-9,6 l/100km \nEmision combinada de CO2: 170-209 g/km \nVelocidad maxima: 243 km/h \nAceleracion 0-100 km/h: 11,5 s \nTipo de combustible: Gasolina", 58550),
    		new Modelos("A6 Avant", "Consumo de combustible: 7,6-9,5 l/100km \nEmision combinada de CO2: 170-206 g/km \nVelocidad maxima: 246 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Diesel", 61570),
    		new Modelos("A6 allroad quattro", "Consumo de combustible: 7,1-8,9 l/100km \nEmision combinada de CO2: 159-196 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 11 s \nTipo de combustible: Diesel", 68470)

		);

    private static ObservableList<Modelos> datosModelosA7 = FXCollections.observableArrayList(
    		new Modelos("A7 Sportback", "Consumo de combustible: 7,7-11,3 l/100km \nEmision combinada de CO2: 170-194 g/km \nVelocidad maxima: 246 km/h \nAceleracion 0-100 km/h: 5,6 s \nTipo de combustible: Diesel", 74920)
		);

    private static ObservableList<Modelos> datosModelosA8 = FXCollections.observableArrayList(
    		new Modelos("A8", "Consumo de combustible: 7,8-11 l/100km \nEmision combinada de CO2: 170-193 g/km \nVelocidad maxima: 243 km/h \nAceleracion 0-100 km/h: 5,8 s \nTipo de combustible: Diesel", 111723),
    		new Modelos("A8 L", "Consumo de combustible: 8,2-11 l/100km \nEmision combinada de CO2: 179-193 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 5,8 s \nTipo de combustible: Diesel", 116150)
		);

    private static ObservableList<Modelos> datosModelosQ2 = FXCollections.observableArrayList(
    		new Modelos("Q2", "Consumo de combustible: 7-8,3 l/100km \nEmision combinada de CO2: 156-187 g/km \nVelocidad maxima: 210 km/h \nAceleracion 0-100 km/h: 9,3 s \nTipo de combustible: Gasolina", 32330)
		);

    private static ObservableList<Modelos> datosModelosQ3 = FXCollections.observableArrayList(
    		new Modelos("Q3", "Consumo de combustible: 7-8,3 l/100km \nEmision combinada de CO2: 156-187 g/km \nVelocidad maxima: 216 km/h \nAceleracion 0-100 km/h: 9,3 s \nTipo de combustible: Diesel", 42240),
    		new Modelos("Q3 Sportback", "Consumo de combustible: 7-8,4 l/100km \nEmision combinada de CO2: 156-193 g/km \nVelocidad maxima: 210 km/h \nAceleracion 0-100 km/h: 9,2 s \nTipo de combustible: Diesel", 44450),
    		new Modelos("RS Q3 Sportback", "Consumo de combustible: 8,3 l/100km \nEmision combinada de CO2: 189 g/km \nVelocidad maxima: 256 km/h \nAceleracion 0-100 km/h: 4,5 s \nTipo de combustible: Gasolina", 79770)
		);

    private static ObservableList<Modelos> datosModelosQ4 = FXCollections.observableArrayList(
    		new Modelos("Q4 e-tron", "Consumo de energia electrica: 22-23 kWh/100km \nAutonomia: 450 km \nVelocidad maxima: 160 km/h \nAceleracion 0-100 km/h: 6,2 s \nTipo de combustible: Electricidad", 55924),
    		new Modelos("Q4 Sportback e-tron", "Consumo de energia electrica: 22-23 kWh/100km \nAutonomia: 450 km \nVelocidad maxima: 160 km/h \nAceleracion 0-100 km/h: 6,3 s \nTipo de combustible: Electricidad", 59530)
		);

    private static ObservableList<Modelos> datosModelosQ5 = FXCollections.observableArrayList(
    		new Modelos("Q5", "Consumo de combustible: 7,1-8,9 l/100km \nEmision combinada de CO2: 156-205 g/km \nVelocidad maxima: 228 km/h \nAceleracion 0-100 km/h: 7,7 s \nTipo de combustible: Diesel", 55400),
    		new Modelos("Q5 Sportback", "Consumo de combustible: 7,3-8,9 l/100km \nEmision combinada de CO2: 157-205 g/km \nVelocidad maxima: 230 km/h \nAceleracion 0-100 km/h: 7,5 s \nTipo de combustible: Diesel", 58400)
		);

    private static ObservableList<Modelos> datosModelosQ7 = FXCollections.observableArrayList(
    		new Modelos("Q7", "Consumo de combustible: 7,9-9,7  l/100km \nEmision combinada de CO2: 177-219 g/km \nVelocidad maxima: 240 km/h \nAceleracion 0-100 km/h: 7,1 s \nTipo de combustible: Gasolina", 74460)
		);

    private static ObservableList<Modelos> datosModelosQ8 = FXCollections.observableArrayList(
    		new Modelos("Q8", "Consumo de combustible: 8,9-10 l/100km \nEmision combinada de CO2: 199-224 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 5,4 s \nTipo de combustible: Gasolina", 85780),
    		new Modelos("RS Q8", "Consumo de combustible: 10,7 l/100km \nEmision combinada de CO2: 244 g/km \nVelocidad maxima: 305 km/h \nAceleracion 0-100 km/h: 3,8 s \nTipo de combustible: Gasolina", 165920)
		);

    private static ObservableList<Modelos> datosModelosEtronGT = FXCollections.observableArrayList(
    		new Modelos("e-tron GT quattro", "Consumo de energia electrica: 19-20 kWh/100km \nAutonomia: 430 km \nVelocidad maxima: 245 km/h \nAceleracion 0-100 km/h: 4,1 s \nTipo de combustible: Electricidad", 106050)
		);

    private static ObservableList<Modelos> datosModelosEtron = FXCollections.observableArrayList(
    		new Modelos("e-tron", "Consumo de energia electrica: 22,6-23,7 kWh/100km \nAutonomia: 425 km \nVelocidad maxima: 200 km/h \nAceleracion 0-100 km/h: 6,8 s \nTipo de combustible: Electricidad", 84610),
    		new Modelos("e-tron Sportback", "Consumo de energia electrica: 22,6-23,7 kWh/100km \nAutonomia: 425 km \nVelocidad maxima: 200 km/h \nAceleracion 0-100 km/h: 6,8 s \nTipo de combustible: Electricidad", 87110)
		);

    private static ObservableList<Modelos> datosModelosTT = FXCollections.observableArrayList(
    		new Modelos("TT Tourist Trophy", "Consumo de combustible: 7,2-8,2 l/100km \nEmision combinada de CO2: 165-189 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 5,2 s \nTipo de combustible: Gasolina o diesel", 56990),
    		new Modelos("TT RS Coupe", "Consumo de combustible: 8,1-8,2 l/100km \nEmision combinada de CO2: 186-189 g/km \nVelocidad maxima: 193 km/h \nAceleracion 0-100 km/h: 3,7 s \nTipo de combustible: Gasolina", 94240)
		);

    private static ObservableList<Modelos> datosModelosRS = FXCollections.observableArrayList(
    		new Modelos("RS 3 Sportback", "Consumo de combustible: 8,3-8,4 l/100km \nEmision combinada de CO2: 189-192 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 4,1 s \nTipo de combustible: Gasolina", 79060),
    		new Modelos("RS 4 Avant", "Consumo de combustible: 9,1-9,3 l/100km \nEmision combinada de CO2: 208-213 g/km \nVelocidad maxima: 280 km/h \nAceleracion 0-100 km/h: 4,4 s \nTipo de combustible: Gasolina", 105390),
    		new Modelos("RS 5 Coupe", "Consumo de combustible: 9,1-9,3 l/100km \nEmision combinada de CO2: 208-213 g/km \nVelocidad maxima: 280 km/h \nAceleracion 0-100 km/h: 3,9 s \nTipo de combustible: Gasolina", 111810),
    		new Modelos("RS 7 Sportback", "Consumo de combustible: 10,5-11,2 l/100km \nEmision combinada de CO2: 238-252 g/km \nVelocidad maxima: 250 km/h \nAceleracion 0-100 km/h: 3,6 s \nTipo de combustible: Diesel", 148280)
		);

    private static ObservableList<Modelos> datosModelosR8 = FXCollections.observableArrayList(
    		new Modelos("R8 Coupe V10", "Consumo de combustible: 13,1 l/100km \nEmision combinada de CO2: 299 g/km \nVelocidad maxima: 330 km/h \nAceleracion 0-100 km/h: 3,6 s \nTipo de combustible: Gasolina", 181850),
    		new Modelos("R8 Spyder V10", "Consumo de combustible: 13,7 l/100km \nEmision combinada de CO2: 312 g/km \nVelocidad maxima: 340 km/h \nAceleracion 0-100 km/h: 3,2 s \nTipo de combustible: Gasolina", 196650)
		);

	private ObservableList<Modelos> filtroDatosModelos = FXCollections.observableArrayList();
	
	public static HashMap<String, ObservableList<Modelos>> mapaModelos = new HashMap<>();
	
	/**
	 * Metodo que guarda todos los datos de cada modelo en un HashMap al que se pueda acceder de manera mas sencilla en otro momento
	 */
	public static void guardarModelos() {
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
	}
	
	/**
     * Metodo para inicializar el controlador que se llama cuando se carga el FXML
     */
	@FXML
    private void initialize() {
		
		if(tablaModelos!=null) {
    		columnaModelos.setCellValueFactory(cellData -> cellData.getValue().getModeloProperty());
	    	columnaEspecificaciones.setCellValueFactory(cellData -> cellData.getValue().getEspecificacionesProperty());
	    	
	    	tablaModelos.setItems(mapaModelos.get(ControllerApp.getModeloActual()));
	    	
	    	mostrarModeloElegido(null);
	    	
	    	tablaModelos.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> mostrarModeloElegido(newValue));
    	}
	}
	
	/**
	 * Metodo que filtra los datos del TableView segun el modelo de coche
	 */
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
    
    /**
	 * Metodo que filtra los datos del TableView segun las especificaciones del coche
	 */
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
    
    /**
     * Metodo que carga el dialogo de compra del coche
     */
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
    
    /**
     * Metodo para recoger el modelo de coche que se selecciona y rellenas los campos con sus datos para comprarlo
     * @param modelo Parametro que guarda la informacion del coche seleccionado
     */
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
        	}else if(modelo.getModelo().equals( mapaModelos.get(ControllerApp.getModeloActual()).get(2).getModelo() )){
        		serieTextField.setText("Serie "+ControllerApp.getModeloActual());
        		modeloTextField.setText(modelo.getModelo());
        		precioTextField.setText(modelo.getPrecio()+" €");
        		
        		comboColor.getItems().addAll("Negro metalizado", "Gris efecto perla", "Azul metalizado", "Blanco glaciar", "Rojo efecto perla", "Amarillo piton");
        	}else if(modelo.getModelo().equals( mapaModelos.get(ControllerApp.getModeloActual()).get(3).getModelo() )){
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
    
    /**
	 * Getter para que los controladores accedan al Stage con la pantalla inicial
	 * @return El Stage con la pantalla inicial principal
	 */
    public static Stage getDialogStage() {
		return dialogStage;
	}
}
