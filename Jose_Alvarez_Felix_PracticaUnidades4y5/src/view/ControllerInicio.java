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
 * Controlador de la pantalla inicial que redirige a la pantalla principal, cuenta con una imagen
 * @author Jose Alvarez Felix
 * @version 09/02/2023
 */
public class ControllerInicio {
	
	@FXML
    private ImageView fotoAudi;
	
	private BorderPane rootLayout;
	
	/**
     * Metodo para inicializar el controlador que se llama cuando se carga el FXML
     */
	@FXML
    private void initialize() {
		
	}
	
	/**
     * Metodo que carga la pantalla principal
     */
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
	
	/**
	 * Getter para que los controladores accedan al layout de la pantalla principal
	 * @return El BorderPane de la pantalla actual
	 */
	public BorderPane getRootLayout() {
		return rootLayout;
	}
	
	/**
	 * Setter para establecer un BorderPane distinto
	 */
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}
}
