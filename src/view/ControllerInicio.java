package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ControllerInicio {
	
	@FXML
    private ImageView fotoAudi;
	
	private FlowPane rootLayout;
	
	@FXML
    private void initialize() {
		
	}
	
	@FXML
	private void abrirPaginaInicio(MouseEvent event) {
		System.out.println("imagen");
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaPrincipal.fxml"));
			
			Parent root = loader.load();
			
			ControllerApp principal = loader.getController();
			
			// Se sitúa en el centro del diseño principal
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.show();		
			
			//borrar linea
			stage.setOnCloseRequest(e -> principal.closeWindows());
			Stage myStage = (Stage) this.fotoAudi.getScene().getWindow(); 
			myStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FlowPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(FlowPane rootLayout) {
		this.rootLayout = rootLayout;
	}
}
