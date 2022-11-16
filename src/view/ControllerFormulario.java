package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class ControllerFormulario {
	
	@FXML
    private ChoiceBox<String> choiceConsulta;
    
    @FXML
    private ComboBox<String> comboModelo;
    
	@FXML
    private void initialize() {
		
		choiceConsulta.getItems().addAll("Solicitar más información", "Oferta comercial", "Prueba de conducción", "Recibir la newsletter");
    	choiceConsulta.setValue("Seleccione el tipo de consulta");
    	
    	comboModelo.getItems().addAll("A1 Allstreet", "A1 Sportback", "A3 Cabrio", "A3 Sedan", "A3 Sportback", "A3 Sportback TFSIe", "A3 Sportback g-tron", "A4", "A4 Avant", "A4 Avant g-tron",
				"A4 allroad quattro", "A5 Cabrio", "A5 Coupé", "A5 Sportback", "A5 Sportback g-tron", "A6", "A6 Avant", "A6 Avant TFSIe", "A6 TFSIe", "A6 allroad quattro",
				"A7 Sportback", "A7 Sportback TFSIe", "A8", "A8 L", "A8 L TFSIe", "A8 TFSIe", "Q2", "Q3", "Q3 Sportback", "Q3 Sportback TFSIe", "Q3 TFSIe", "Q4 Sportback e-tron",
				"Q4 e-tron", "Q5", "Q5 Sportback", "Q5 Sportback TFSIe", "Q5 TFSIe", "Q7", "Q7 TFSIe", "Q8", "Q8 Sportback e-tron", "Q8 TFSIe", "Q8 e-tron", "R8 Coupé", 
				"R8 Coupé V10 perfomance RWD", "R8 Coupé V10 perfomance quattro", "R8 Spyder", "R8 Spyder V10 performance RWD", "R8 Spyder V10 performance quattro", "RS 3 Sedan", 
				"RS 3 Sportback", "RS 4 Avant", "RS 5 Coupé", "RS 5 Sportback", "RS 6 Avant", "RS 7 Sportback", "RS Q3", "RS Q3 Sportback", "RS Q8", "RS e-tron GT", 
				"S3 Cabrio", "S3 Sedan", "S3 Sportback", "S4", "S4 Avant", "S5 Cabrio", "S5 Coupé", "S5 Sportback", "S6", "S6 Avant", "S7 Sportback", "S8", "S8 L", "SQ2", "SQ5", 
				"SQ5 Sportback", "SQ7", "SQ8", "SQ8 Sportback e-tron", "SQ8 e-tron", "TT Coupé", "TT RS Coupé", "TT RS Roadster", "TT Roadster", "TTS Coupé", "TTS Roadster", 
				"e-tron", "e-tron GT quattro", "e-tron S", "e-tron S Sportback", "e-tron Sportback");
    	comboModelo.setValue("Modelo");
	}
}
