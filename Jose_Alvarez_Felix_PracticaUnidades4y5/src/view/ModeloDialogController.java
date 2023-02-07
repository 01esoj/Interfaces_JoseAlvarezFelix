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
	        	
	    		alertaConfirmar.setTitle("Notificaci�n de compra");
	    		alertaConfirmar.setHeaderText("Compra realizada");
	    		alertaConfirmar.setContentText("Se ha realizado la compra con �xito");
	    		
	    		alertaConfirmar.showAndWait();
	    		
	    		String [] datosEstadistica = {"Aut�nomo", "Empresa", "Uso personal"};
	    		List<String> dialogData = Arrays.asList(datosEstadistica);
	    		// Se crea el ChoiceDialog con el primer elemento seleccionado
	    		ChoiceDialog<String> choiceDialog = new
	    		ChoiceDialog<String>(dialogData.get(0), dialogData);
	    		choiceDialog.setHeaderText("Selecciona una opci�n para datos estad�sticos");
	    		choiceDialog.showAndWait();
	    		ControllerApp.getDialogStage().close();
        }
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "El campo nombre del titular est� vac�o\n"; 
        }
        
        if (numeroTarjetaField.getText() == null || numeroTarjetaField.getText().length() == 0 || numeroTarjetaField.getText().length() != 12) {
            errorMessage += "El campo n�mero de tarjeta est� vac�o o el tama�o introducido no es correcto (introduzca 12 d�gitos)\n"; 
        } else {
            try {
                Long.parseLong(numeroTarjetaField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "N�mero de tarjeta no v�lido\n"; 
            }
        }
        
        if (cvcField.getText() == null || cvcField.getText().length() == 0 || cvcField.getText().length() != 3) {
            errorMessage += "El campo cvc code est� vac�o o el tama�o introducido no es correcto (introduzca 3 d�gitos)\n"; 
        } else {
            try {
                Integer.parseInt(cvcField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Cvc no v�lido\n"; 
            }
        }
        
        if (fechaField.getText() == null || fechaField.getText().length() == 0) {
            errorMessage += "El campo fecha de caducidad est� vac�o\n"; 
        }
        
        if (direccionField.getText() == null || direccionField.getText().length() == 0) {
            errorMessage += "El campo direcci�n de facturaci�n est� vac�o\n"; 
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
