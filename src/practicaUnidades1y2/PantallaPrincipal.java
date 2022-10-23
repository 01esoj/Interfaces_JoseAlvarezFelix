package practicaUnidades1y2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class PantallaPrincipal extends Application{
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			initRootLayout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initRootLayout() {
		try {
			// Carga el XML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PantallaPrincipal.class.getResource("/view/PantallaPrincipal.fxml"));
			rootLayout = (BorderPane) loader.load();
			// Se añade el diseño principal a la escena
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
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
