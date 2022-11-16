package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
	
	/*@FXML
    private TableView<Modelos> tableModelos;
	
	@FXML
    private TableColumn<Modelos, String> seriesACol;

    @FXML
    private TableColumn<Modelos, String> seriesQCol;

    @FXML
    private TableColumn<Modelos, String> otrasSeriesCol;*/
    
    @FXML
    private ListView<String> listOtrasSeries;

    @FXML
    private ListView<String> listSeriesA;

    @FXML
    private ListView<String> listSeriesQ;
    
    @FXML
    private TreeView<String> treeAyuda;
    
    @FXML
    private ChoiceBox<String> choiceConsulta;
    
    @FXML
    private ComboBox<String> comboModelo;
	
	private BorderPane rootLayout;
	
	/*private ObservableList<Modelos> datosModelos = FXCollections.observableArrayList(
    	    new Modelos("A1", "Q2", "e-tron GT"),
    	    new Modelos("A3", "Q3", "e-tron"),
    	    new Modelos("A4", "Q4 e-tron", "TT"),
    	    new Modelos("A5", "Q5", "R8"),
    	    new Modelos("A6", "Q6", "RS"),
    	    new Modelos("A7", "Q7", "S"),
    	    new Modelos("A8", "Q8", ""),
    	    new Modelos("A1", "Q2", "")
    );*/
	
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
    	
    	/*seriesACol.setCellValueFactory(new PropertyValueFactory<Modelos,String>("seriesACol"));
    	seriesQCol.setCellValueFactory(new PropertyValueFactory<Modelos,String>("seriesQCol"));
    	otrasSeriesCol.setCellValueFactory(new PropertyValueFactory<Modelos,String>("otrasSeriesCol"));
    	
   		tableModelos.setItems(datosModelos);*/
    	
    	if(listSeriesA!=null) {
    		listSeriesA.getItems().addAll("A1", "A3", "A4", "A5", "A6", "A7", "A8");
    		listSeriesQ.getItems().addAll("Q2", "Q3", "Q4 e-tron", "Q5", "Q6", "Q7", "Q8");
    		listOtrasSeries.getItems().addAll("e-tron GT", "e-tron", "TT", "R8", "RS", "S");
    	}
    	
    	TreeItem<String> ayuda = new TreeItem<String>("Ayuda");
    	
    	TreeItem<String> ayudaConocenos = new TreeItem<String>("Conócenos");
    	TreeItem<String> ayudaModelos = new TreeItem<String>("¿Cómo puedo ver los distintos modelos?");
    	TreeItem<String> ayudaMundoAudi = new TreeItem<String>("¿Cómo puedo saber más de la marca?");
    	TreeItem<String> ayudaContacto = new TreeItem<String>("¿Cómo puedo contactar con vosotros en caso de ayuda?");
    	
    	TreeItem<String> ayudaInfoConocenos = new TreeItem<String>("En MyAudi tendrás un rápido acceso a todo lo que alberga nuestra marca. Podrás navegar de una forma muy sencilla entre los distintos modelos de los que disponemos, estar a la última en cuánto a novedades se refiere, contactar con nosotros en caso de necesitar ayuda y muchas más cosas que te explicamos en los demás apartados.");
    	TreeItem<String> ayudaInfoModelos = new TreeItem<String>("Para poder ver todos los modelos de lso que dipsonemos y sus precios tendrás que dirigirte a la pestaña de la izquierda y desplegar la sección Modelos. Una vez dentro, tendrás a tu disposición todos los modelos.");
    	TreeItem<String> ayudaInfoMundoAudi = new TreeItem<String>("Si lo que te interesa es saber cómo trabajamos, cómo nos involucramos con el medio ambiente, cuáles son nuestros procesos de fabricación... tendrás que dirigirte a la pestaña de la izquierda y desplegar la sección Mundo Audi.");
    	TreeItem<String> ayudaInfoContacto = new TreeItem<String>("Si te ha surgido alguna duda o tienes algún inconveniente, podrás contactar con nosotros rellenando un simple formulario y nosotros te contactaremos de la forma que prefieras lo antes posible.");
    	
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
    	
    	choiceConsulta.getItems().addAll("Solicitar más información", "Oferta comercial", "Prueba de conducción", "Recibir la newsletter");
    	choiceConsulta.setValue("Seleccione el tipo de consulta");
    	
    	comboModelo.getItems().addAll("A1 Allstreet", "A1 Sportback", "A3 Cabrio", "A3 Sedan", "A3 Sportback", "A3 Sportback TFSIe", "A3 Sportback g-tron", "A4", "A4 Avant", "A4 Avant g-tron",
				"A4 allroad quattro", "A5 Cabrio", "A5 Coupé", "A5 Sportback", "A5 Sportback g-tron", "A6", "A6 Avant", "A6 Avant TFSIe", "A6 TFSIe", "A6 allroad quattro",
				"A7 Sportback", "A7 Sportback TFSIe", "A8", "A8 L", "A8 L TFSIe", "A8 TFSIe", "Q2", "Q3", "Q3 Sportback", "Q3 Sportback TFSIe", "Q3 TFSIe", "Q4 Sportback e-tron",
				"Q4 e-tron", "Q5", "Q5 Sportback", "Q5 Sportback TFSIe", "Q5 TFSIe", "Q7", "Q7 TFSIe", "Q8", "Q8 Sportback e-tron", "Q8 TFSIe", "Q8 e-tron", "R8 Coupé", 
				"R8 Coupé V10 perfomance RWD", "R8 Coupé V10 perfomance quattro", "R8 Spyder", "R8 Spyder V10 performance RWD", "R8 Spyder V10 performance quattro", "RS 3 Sedan", 
				"RS 3 Sportback", "RS 4 Avant", "RS 5 Coupé", "RS 5 Sportback", "RS 6 Avant", "RS 7 Sportback", "RS Q3", "RS Q3 Sportback", "RS Q8", "RS e-tron GT", 
				"S3 Cabrio", "S3 Sedan", "S3 Sportback", "S4", "S4 Avant", "S5 Cabrio", "S5 Coupé", "S5 Sportback", "S6", "S6 Avant", "S7 Sportback", "S8", "S8 L", "SQ2", "SQ5", 
				"SQ5 Sportback", "SQ7", "SQ8", "SQ8 Sportback e-tron", "SQ8 e-tron", "TT Coupé", "TT RS Coupé", "TT RS Roadster", "TT Roadster", "TTS Coupé", "TTS Roadster", 
				"e-tron", "e-tron GT quattro", "e-tron S", "e-tron S Sportback", "e-tron Sportback");
    	comboModelo.setValue("Modelo");
    	
	}
	
	@FXML
	private void abrirPaginaContacto(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaContacto.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaMundoAudiSostenibilidad(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaSostenibilidad.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaModelos(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaModelos.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaAyuda(MouseEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaAyuda.fxml"));
			FlowPane listadoControles = (FlowPane) loader.load();
			
			// Se sitúa en el centro del diseño principal
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
