package practicaUnidades1y2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.ControllerApp;
import view.ControllerInicio;


public class PantallaPrincipal extends Application{
	
	private BorderPane rootLayout;
	//private FlowPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el XML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PantallaPrincipal.class.getResource("/view/PruebaInicio.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Pasamos al controlador de menu el objeto con el BorderPane principal
			ControllerInicio menuController = loader.getController();
			menuController.setRootLayout(rootLayout);
			
			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("MyAudi");
			primaryStage.show();
			scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
