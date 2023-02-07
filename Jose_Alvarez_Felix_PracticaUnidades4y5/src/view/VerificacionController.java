package view;

import javafx.fxml.FXML;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VerificacionController {
	
	@FXML
    private Text campoVerificar;

    @FXML
    private Text textoVerificar;
    
    @FXML
    private void initialize() {
    	
    	textoVerificar.setOnDragDetected((event) -> {
    		System.out.println("Texto seleccionado para arrastrar");
            
            // Se indica que el modo de transferencia ser� del tipo movimiento
            Dragboard db = textoVerificar.startDragAndDrop(TransferMode.MOVE);
            
            ClipboardContent content = new ClipboardContent();
            content.putString(textoVerificar.getText());
            db.setContent(content);            
        });
        
    	campoVerificar.setOnDragOver((event) -> {
            
            // Solo se acepta si el texto se mueve desde otro nodo y es un String
            if (event.getGestureSource() != campoVerificar && event.getDragboard().hasString()) {
                // Se permite movimiento drag and drop
                event.acceptTransferModes(TransferMode.MOVE);
            }          
        });
        
        //OnDragEntered: Cuando se detecta que el texto origen ha alcanzado el destino
    	campoVerificar.setOnDragEntered((event) -> {
            System.out.println("El texto ha encontrado el campo");
            // Se cambia el color para mostrar al usuario que se sit�a en el texto permitido para soltar el elemento origen
            if (event.getGestureSource() != campoVerificar && event.getDragboard().hasString()) {
            	campoVerificar.setFill(Color.GREEN);
            }
        });
        
    	campoVerificar.setOnDragDropped((event) -> {
            System.out.println("El texto se ha arrastrado con exito");
                         
            // Si se ha almacenado texto se copia al destino
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
            	campoVerificar.setText(db.getString());
                success = true;
            }
            // Marcamos el evento como finalizado
            event.setDropCompleted(success);        
        });
        
    	campoVerificar.setOnDragExited((event) -> {
        	System.out.println("Movimiento de raton finalizado");
        	
            // Cuando se finaliza el color vuelve a ser negro
        	campoVerificar.setFill(Color.BLACK);
        });
            
        textoVerificar.setOnDragDone((event) -> {
            System.out.println("Se notifica al texto que se ha completado el movimiento de arrastrar y soltar");
            // Se elimina del origen
            if (event.getTransferMode() == TransferMode.MOVE) {
            	textoVerificar.setText("");
            }
        });
    }
}
