 package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControllerInicio {
	
	@FXML
    private ImageView fotoAudi;
	
	private BorderPane rootLayout;
	private Scene scene;
	
	@FXML
    private void initialize() {
		
	}
	
	@FXML
	private void abrirPaginaInicio(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaPrincipal.fxml"));
			
			BorderPane root = loader.load();
			
			ControllerApp principal = loader.getController();
			principal.setRootLayout(root);
			
			// Se sitúa en el centro del diseño principal
			scene = new Scene(root);
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

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
