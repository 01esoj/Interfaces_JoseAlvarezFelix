 package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Controlador de la pantalla con la tabla y botones para añadir, editar o eliminar la información
 * 
 * @author Alumno DAM
 *
 */
public class ControllerInicio {
	
	@FXML
    private ImageView fotoAudi;
	
	private BorderPane rootLayout;
	
	@FXML
    private void initialize() {
		
	}
	
	@FXML
	private void abrirPaginaInicio(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Din�micos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaPrincipal.fxml"));
			
			BorderPane root = loader.load();
			
			ControllerApp principal = loader.getController();
			principal.setRootLayout(root);
			
			// Se sit�a en el centro del dise�o principal
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("MyAudi");
			stage.show();		
			
			stage.setOnCloseRequest(e -> principal.closeWindows());
			Stage myStage = (Stage) this.fotoAudi.getScene().getWindow(); 
			myStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}
}
