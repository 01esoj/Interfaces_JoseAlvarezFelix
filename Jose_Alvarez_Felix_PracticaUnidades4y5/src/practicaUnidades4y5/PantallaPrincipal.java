package practicaUnidades4y5;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ControllerInicio;
import view.ControllerSeries;

/**
 * Es la primera pantalla, contiene la imagen que al pulsarla redirige a la pantalla principal
 * @author Jose Alvarez Felix
 * @version 09/02/2023
 */
public class PantallaPrincipal extends Application{
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/**
	 * Metodo que carga la pantalla inicial de la aplicacion
	 * @param primaryStage Objeto con la ventana principal
	 */
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
	
	/**
	 * Metodo main para iniciar la aplicacin
	 * @param args Argumentos de la MV de Java
	 */
	public static void main(String[] args) {
		ControllerSeries.guardarModelos();
		launch(args);
	}
	
	/**
	 * Getter para que los controladores accedan al Stage con la pantalla inicial
	 * @return El Stage con la pantalla inicial principal
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
