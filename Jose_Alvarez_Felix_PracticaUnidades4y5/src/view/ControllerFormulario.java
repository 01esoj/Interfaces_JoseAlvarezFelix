package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class ControllerFormulario {
	
	@FXML
    private ToggleGroup Opciones;

    @FXML
    private RadioButton botonCorreo;

    @FXML
    private Button botonEnviar;

    @FXML
    private Button botonLimpiar;

    @FXML
    private RadioButton botonTelefono;

    @FXML
    private ChoiceBox<String> choiceConsulta;

    @FXML
    private ComboBox<String> comboModelo;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextArea txtInfo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;
    
    private Alert crearAlerta(AlertType type, String title, String header, String contextText) {
    	Alert auxAlert = new Alert(type);
    	
    	auxAlert.setTitle(title);
    	auxAlert.setHeaderText(header);
    	auxAlert.setContentText(contextText);
    	
    	return auxAlert;
    }
    
	@FXML
    private void initialize() {
		
		choiceConsulta.getItems().addAll("Solicitar mas informacian", "Oferta comercial", "Prueba de conduccion", "Recibir la newsletter");
    	choiceConsulta.setValue("Seleccione el tipo de consulta");
    	
    	comboModelo.getItems().addAll("A1 Allstreet", "A1 Sportback", "A3 Sedan", "A3 Sportback", "A4", "A4 Avant", "A4 allroad quattro", "A5 Cabrio", "A5 Coupe", "A5 Sportback", 
    			"A6", "A6 Avant", "A6 allroad quattro", "A7 Sportback", "A8", "A8 L", "Q2", "Q3", "Q3 Sportback", "Q4 e-tron", "Q4 Sportback e-tron",
				"Q5", "Q5 Sportback", "Q7", "Q8", "Q8 e-tron", "R8 Coupe", "R8 Spyder", "RS 3 Sedan", "RS 3 Sportback", "RS 4 Avant", "RS 5 Coupe", "RS 5 Sportback", "RS 6 Avant", "RS 7 Sportback", 
				"RS Q3", "RS Q3 Sportback", "RS Q8", "RS e-tron GT", "S3 Cabrio", "S3 Sedan", "S3 Sportback", "S4", "S4 Avant", "S5 Cabrio", "S5 Coupe", "S5 Sportback", "S6", "S6 Avant", 
				"S7 Sportback", "S8", "S8 L", "SQ2", "SQ5", "SQ5 Sportback", "SQ7", "SQ8", "SQ8 Sportback e-tron", "SQ8 e-tron", "TT Coupe", "TT RS Coupe", "TTS Coupe", "TTS Roadster", 
				"e-tron", "e-tron GT quattro", "e-tron S", "e-tron S Sportback", "e-tron Sportback");
    	comboModelo.setValue("Modelo");
    	
    	// Alert de tipo error
    	Alert alertaCampos = crearAlerta(AlertType.WARNING, "Alerta de advertencia", "Fallo en algun campo", "Falta algun campo por rellenar");
    	Alert alertaPreferencias = crearAlerta(AlertType.ERROR, "Alerta de error", "Fallo en preferencias", "Tienes que escoger una opcion");
    	Alert alertaExito = crearAlerta(AlertType.INFORMATION, "Alerta de enviado", "No hay ningun fallo", "Formulario enviado con exito");
    	Alert alertaConfirmar = crearAlerta(AlertType.CONFIRMATION, "Alerta de borrado", "Alerta de borrado de campos", "Desea borrar el valor de los campo del formulario?");
		
    	// Se muestra el di�logo cuando se hace click en el bot�n y no se cumple el formato del texto
    	botonEnviar.setOnAction(e -> {
    		String nombre = txtNombre.getText().trim();
    		String apellido = txtApellido.getText().trim();
    		String correo = txtCorreo.getText().trim();
    		String telefono = txtTelefono.getText().trim();
    		String informacion = txtInfo.getText().trim();
    		
    		if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || telefono.isEmpty() || informacion.isEmpty() || comboModelo.getValue().equals("Modelo") || choiceConsulta.getValue().equals("Seleccione el tipo de consulta")) {
    			alertaCampos.showAndWait();
    		}else if(!botonCorreo.isSelected() && !botonTelefono.isSelected()) {
    			alertaPreferencias.showAndWait();
    		}else {
    			alertaExito.showAndWait();
    		}
        });
    	
    	botonLimpiar.setOnAction(e -> {
    		alertaConfirmar.showAndWait().ifPresent(respuesta -> {
    			if (respuesta == ButtonType.OK) {
    				txtNombre.setText("");
    				txtApellido.setText("");
    				txtCorreo.setText("");
    				txtTelefono.setText("");
    				txtInfo.setText("");
    				comboModelo.setValue("");
    				choiceConsulta.setValue("Seleccione el tipo de consulta");
    				botonCorreo.setSelected(false);
    				botonTelefono.setSelected(false);
    		    }
    		});
    	});
	}
}
