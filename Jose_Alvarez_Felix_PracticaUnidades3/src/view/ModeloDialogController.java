package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

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
    
    private Stage dialogStage;
    
    private boolean okClicked = false;
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleCancel(ActionEvent event) {
    	dialogStage.close();
    }

    @FXML
    private void handleOk(ActionEvent event) {
    	if (isInputValid()) {
    		Alert alertaConfirmar = new Alert(AlertType.CONFIRMATION);
        	
    		alertaConfirmar.setTitle("Notificación de compra");
    		alertaConfirmar.setHeaderText("Compra realizada");
    		alertaConfirmar.setContentText("Se ha realizado la compra con éxito");
    		
    		alertaConfirmar.showAndWait();
    		okClicked = true;
            dialogStage.close();
        }
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "El campo nombre del titular está vacío\n"; 
        }
        
        if (numeroTarjetaField.getText() == null || numeroTarjetaField.getText().length() == 0) {
            errorMessage += "El campo número de tarjeta está vacío\n"; 
        } else {
            try {
                Integer.parseInt(numeroTarjetaField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Número de tarjeta no válido\n"; 
            }
        }
        
        if (cvcField.getText() == null || cvcField.getText().length() == 0) {
            errorMessage += "El campo cvc code está vacío\n"; 
        } else {
            try {
                Integer.parseInt(cvcField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Cvc no válido\n"; 
            }
        }
        
        if (fechaField.getText() == null || fechaField.getText().length() == 0) {
            errorMessage += "El campo fecha de caducidad está vacío\n"; 
        }
        
        if (direccionField.getText() == null || direccionField.getText().length() == 0) {
            errorMessage += "El campo dirección de facturación está vacío\n"; 
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
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
