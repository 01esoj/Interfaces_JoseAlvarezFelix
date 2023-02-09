package practicaUnidades4y5;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ControllerInicio;
import view.ControllerSeries;

public class PantallaPrincipal extends Application{
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		try {
			// Carga el XML con el diseno principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PantallaPrincipal.class.getResource("/view/PantallaInicio.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Pasamos al controlador de menu el objeto con el BorderPane principal
			ControllerInicio menuController = loader.getController();
			menuController.setRootLayout(rootLayout);
			
			// Se anade el diseno principal a la escena
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
		ControllerSeries.guardarModelos();
		launch(args);
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
