package practicaUnidades1y2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ControllerApp;


public class PantallaPrincipal extends Application{
	
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el XML con el dise�o principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PantallaPrincipal.class.getResource("/view/PantallaPrincipal.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Pasamos al controlador de menu el objeto con el BorderPane principal
			ControllerApp menuController = loader.getController();
			menuController.setRootLayout(rootLayout);
			
			// Se a�ade el dise�o principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
