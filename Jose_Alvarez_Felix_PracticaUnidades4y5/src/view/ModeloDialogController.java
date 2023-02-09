package view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceDialog;

/**
 * Controlador de la pantalla con la tabla y botones para añadir, editar o eliminar la información
 * 
 * @author Alumno DAM
 *
 */
public class ModeloDialogController {
	
	@FXML
    private TextField cvcField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField fechaField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField numeroTarjetaField;
    
    @FXML
    private Button botonComprarDialogo;	
    
    private static Stage dialogStageVerificar;
    
    private static boolean verificacion = false;
    
    @FXML
    private void handleVerificarCompra(ActionEvent event) {
    	if(isInputValid()) {
    		try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(ControllerApp.class.getResource("VerificacionDialog.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();
				
				dialogStageVerificar = new Stage();
				dialogStageVerificar.setTitle("Verificar compra");
				dialogStageVerificar.initModality(Modality.WINDOW_MODAL);
		        Scene scene = new Scene(listadoControles);
		        dialogStageVerificar.setScene(scene);
		        
		        dialogStageVerificar.showAndWait();
		        verificacion = true;
		        handleOk(event);
			}catch (IOException ex) {
				ex.printStackTrace();
			}
    	}
    }
    
    @FXML
    private void handleCancel(ActionEvent event) {
    	ControllerApp.getDialogStage().close();
    }

    @FXML
    private static void handleOk(ActionEvent event) {
    	if (verificacion) {
	    		Alert alertaConfirmar = new Alert(AlertType.CONFIRMATION);
	        	
	    		alertaConfirmar.setTitle("Notificacion de compra");
	    		alertaConfirmar.setHeaderText("Compra realizada");
	    		alertaConfirmar.setContentText("Se ha realizado la compra con �xito");
	    		
	    		alertaConfirmar.showAndWait();
	    		
	    		String [] datosEstadistica = {"Autonomo", "Empresa", "Uso personal"};
	    		List<String> dialogData = Arrays.asList(datosEstadistica);
	    		// Se crea el ChoiceDialog con el primer elemento seleccionado
	    		ChoiceDialog<String> choiceDialog = new
	    		ChoiceDialog<String>(dialogData.get(0), dialogData);
	    		choiceDialog.setHeaderText("Selecciona una opcion para datos estadisticos");
	    		choiceDialog.showAndWait();
	    		ControllerApp.getDialogStage().close();
        }
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "El campo nombre del titular esta vacio\n"; 
        }
        
        if (numeroTarjetaField.getText() == null || numeroTarjetaField.getText().length() == 0 || numeroTarjetaField.getText().length() != 12) {
            errorMessage += "El campo numero de tarjeta esta vacio o el tamano introducido no es correcto (introduzca 12 digitos)\n"; 
        } else {
            try {
                Long.parseLong(numeroTarjetaField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Numero de tarjeta no valido\n"; 
            }
        }
        
        if (cvcField.getText() == null || cvcField.getText().length() == 0 || cvcField.getText().length() != 3) {
            errorMessage += "El campo cvc code esta vacio o el tamano introducido no es correcto (introduzca 3 digitos)\n"; 
        } else {
            try {
                Integer.parseInt(cvcField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Cvc no valido\n"; 
            }
        }
        
        if (fechaField.getText() == null || fechaField.getText().length() == 0) {
            errorMessage += "El campo fecha de caducidad esta vacio\n"; 
        }
        
        if (direccionField.getText() == null || direccionField.getText().length() == 0) {
            errorMessage += "El campo direccion de facturacion esta vacio\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
        	// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Hay campos incorrectos");
    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
    		errorAlert.setContentText(errorMessage);
    		
    		errorAlert.showAndWait();
            return false;
        }
    }
}
