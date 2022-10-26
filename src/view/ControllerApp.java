package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class ControllerApp {
	
	@FXML
    private TitledPane paginaModelos;
	
	@FXML
    private TitledPane paginaMundoAudi;
	
	@FXML
    private TitledPane paginaContacto;
	
	@FXML
    private TitledPane paginaAyuda;
	
	@FXML
    private TreeView<String> treeSeries;
	
	@FXML
    private ListView<String> listOtrasSeries;

    @FXML
    private ListView<String> listSeriesA;

    @FXML
    private ListView<String> listSeriesQ;
    
    @FXML
    private TreeView<String> treeAyuda;
	
	private BorderPane rootLayout;
	
	@FXML
    private void initialize() {
		TreeItem<String> series = new TreeItem<String>(" ");
		
		TreeItem<String> serieA = new TreeItem<String>("Series A");
    	
    	TreeItem<String> serieA1 = new TreeItem<String>("A1");
    	TreeItem<String> serieA3 = new TreeItem<String>("A3");
    	TreeItem<String> serieA4 = new TreeItem<String>("A4");
    	TreeItem<String> serieA5 = new TreeItem<String>("A5");
    	TreeItem<String> serieA6 = new TreeItem<String>("A6");
    	TreeItem<String> serieA7 = new TreeItem<String>("A7");
    	TreeItem<String> serieA8 = new TreeItem<String>("A8");
    	
    	serieA.getChildren().add(serieA1);
    	serieA.getChildren().add(serieA3);
    	serieA.getChildren().add(serieA4);
    	serieA.getChildren().add(serieA5);
    	serieA.getChildren().add(serieA6);
    	serieA.getChildren().add(serieA7);
    	serieA.getChildren().add(serieA8);
    	
    	TreeItem<String> serieQ = new TreeItem<String>("Series Q");
    	
    	TreeItem<String> serieQ2 = new TreeItem<String>("Q2");
    	TreeItem<String> serieQ3 = new TreeItem<String>("Q3");
    	TreeItem<String> serieQ4 = new TreeItem<String>("Q4 e-tron");
    	TreeItem<String> serieQ5 = new TreeItem<String>("Q5");
    	TreeItem<String> serieQ7 = new TreeItem<String>("Q7");
    	TreeItem<String> serieQ8 = new TreeItem<String>("Q8");
    	
    	serieQ.getChildren().add(serieQ2);
    	serieQ.getChildren().add(serieQ3);
    	serieQ.getChildren().add(serieQ4);
    	serieQ.getChildren().add(serieQ5);
    	serieQ.getChildren().add(serieQ7);
    	serieQ.getChildren().add(serieQ8);
    	
    	TreeItem<String> otrasSeries = new TreeItem<String>("Otras series");
    	
    	TreeItem<String> eTronGT = new TreeItem<String>("e-tron GT");
    	TreeItem<String> eTron = new TreeItem<String>("e-tron");
    	TreeItem<String> TT = new TreeItem<String>("TT");
    	TreeItem<String> R8 = new TreeItem<String>("R8");
    	TreeItem<String> RS = new TreeItem<String>("RS");
    	TreeItem<String> S = new TreeItem<String>("S");
    	
    	otrasSeries.getChildren().add(eTronGT);
    	otrasSeries.getChildren().add(eTron);
    	otrasSeries.getChildren().add(TT);
    	otrasSeries.getChildren().add(R8);
    	otrasSeries.getChildren().add(RS);
    	otrasSeries.getChildren().add(S);
    	
    	series.getChildren().add(serieA);
    	series.getChildren().add(serieQ);
    	series.getChildren().add(otrasSeries);
    	
    	series.setExpanded(true);
    	
    	serieA.setExpanded(false);
    	serieQ.setExpanded(false);
    	otrasSeries.setExpanded(false);
    	
    	if(treeSeries!=null)
    		treeSeries.setRoot(series);
    	
    	if(listSeriesA!=null) {
    		listSeriesA.getItems().addAll("A1", "A3", "A4", "A5", "A6", "A7", "A8");
    		listSeriesQ.getItems().addAll("Q2", "Q3", "Q4 e-tron", "Q5", "Q6", "Q7", "Q8");
    		listOtrasSeries.getItems().addAll("e-tron GT", "e-tron", "TT", "R8", "RS", "S");
    	}
    	
    	TreeItem<String> ayuda = new TreeItem<String>("Ayuda");
    	
    	TreeItem<String> ayudaConocenos = new TreeItem<String>("Con�cenos");
    	TreeItem<String> ayudaModelos = new TreeItem<String>("�C�mo puedo ver los distintos modelos?");
    	TreeItem<String> ayudaMundoAudi = new TreeItem<String>("�C�mo puedo saber m�s de la marca?");
    	TreeItem<String> ayudaContacto = new TreeItem<String>("�C�mo puedo contactar con vosotros en caso de ayuda?");
    	
    	TreeItem<String> ayudaInfoConocenos = new TreeItem<String>("En MyAudi tendr�s un r�pido acceso a todo lo que alberga nuestra marca. Podr�s navegar de una forma muy sencilla entre los distintos modelos de los que disponemos, estar a la �ltima en cu�nto a novedades se refiere, contactar con nosotros en caso de necesitar ayuda y muchas m�s cosas que te explicamos en los dem�s apartados.");
    	TreeItem<String> ayudaInfoModelos = new TreeItem<String>("Para poder ver todos los modelos de lso que dipsonemos y sus precios tendr�s que dirigirte a la pesta�a de la izquierda y desplegar la secci�n Modelos. Una vez dentro, tendr�s a tu disposici�n todos los modelos.");
    	TreeItem<String> ayudaInfoMundoAudi = new TreeItem<String>("Si lo que te interesa es saber c�mo trabajamos, c�mo nos involucramos con el medio ambiente, cu�les son nuestros procesos de fabricaci�n... tendr�s que dirigirte a la pesta�a de la izquierda y desplegar la secci�n Mundo Audi.");
    	TreeItem<String> ayudaInfoContacto = new TreeItem<String>("Si te ha surgido alguna duda o tienes alg�n inconveniente, podr�s contactar con nosotros rellenando un simple formulario y nosotros te contactaremos de la forma que prefieras lo antes posible.");
    	
    	ayudaConocenos.getChildren().add(ayudaInfoConocenos);
    	ayudaModelos.getChildren().add(ayudaInfoModelos);
    	ayudaMundoAudi.getChildren().add(ayudaInfoMundoAudi);
    	ayudaContacto.getChildren().add(ayudaInfoContacto);
    	
    	ayuda.getChildren().add(ayudaConocenos);
    	ayuda.getChildren().add(ayudaModelos);
    	ayuda.getChildren().add(ayudaMundoAudi);
    	ayuda.getChildren().add(ayudaContacto);
    	
    	ayuda.setExpanded(true);
    	ayudaConocenos.setExpanded(false);
    	ayudaModelos.setExpanded(false);
    	ayudaMundoAudi.setExpanded(false);
    	ayudaContacto.setExpanded(false);
    	
    	if(treeAyuda!=null) {
    		treeAyuda.setRoot(ayuda);
    	}
	}
	
	@FXML
	private void abrirPaginaContacto(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Din�micos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaContacto.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			
			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaMundoAudiSostenibilidad(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Din�micos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaSostenibilidad.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			
			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaModelos(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Din�micos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaModelos.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			
			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaAyuda(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Din�micos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaAyuda.fxml"));
			FlowPane listadoControles = (FlowPane) loader.load();
			
			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(listadoControles);
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
	
	public void closeWindows() {}
}
