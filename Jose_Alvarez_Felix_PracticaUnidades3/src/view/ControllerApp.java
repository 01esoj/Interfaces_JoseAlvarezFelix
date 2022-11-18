package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import practicaUnidades3.PantallaPrincipal;

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
    private Slider sliderPrecioA;

    @FXML
    private Slider sliderPrecioQ;

    @FXML
    private Slider sliderPrecioR;
    
	private BorderPane rootLayout;
	
	private PantallaPrincipal mainApp;
	
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
    	
    		listSeriesA.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    			if(newValue.equals("A1")) {
    				System.out.println("Antiguo->" + oldValue + "Nuevo->" + newValue);
    				
    			}
    		});
    	}
    	
    	TreeItem<String> ayuda = new TreeItem<String>("Ayuda");
    	
    	TreeItem<String> ayudaConocenos = new TreeItem<String>("Conócenos");
    	TreeItem<String> ayudaModelos = new TreeItem<String>("¿Cómo puedo ver los distintos modelos?");
    	TreeItem<String> ayudaMundoAudi = new TreeItem<String>("¿Cómo puedo saber más de la marca?");
    	TreeItem<String> ayudaContacto = new TreeItem<String>("¿Cómo puedo contactar con vosotros en caso de ayuda?");
    	
    	TreeItem<String> ayudaInfoConocenos = new TreeItem<String>("En MyAudi tendrás un rápido acceso a todo lo que alberga nuestra marca. Podrás navegar de una forma muy \nsencilla entre los distintos modelos de los que disponemos, estar a la última en cuánto a novedades se refiere,\n contactar con nosotros en caso de necesitar ayuda y muchas más cosas que te explicamos en los demás \napartados.");
    	TreeItem<String> ayudaInfoModelos = new TreeItem<String>("Para poder ver todos los modelos de los que disponemos y sus precios tendrás que dirigirte a la pestaña de la \nizquierda y desplegar la sección Modelos. Una vez dentro, podrás escoger entre las distintas series de nuestra\n marca y poder visualizar con más detalle las especificaciones del modelo que escojas. De lo contrario si \nprefieres buscar un modelo que se ajuste a tu presupuesto podrás deslizar en el rango de precio correspodiente \na cada serie y encontrar el que más se adapte a tus necesidades.");
    	TreeItem<String> ayudaInfoMundoAudi = new TreeItem<String>("Si lo que te interesa es saber cómo trabajamos, cómo nos involucramos con el medio ambiente, cuáles son \nnuestros procesos de fabricación... tendrás que dirigirte a la pestaña de la izquierda y desplegar la sección \nMundo Audi. Una vez allí podrás descubrir cómo trabajamos. Además, será en esa sección en la que iremos \nactualizando distintas promociones.");
    	TreeItem<String> ayudaInfoContacto = new TreeItem<String>("Si te ha surgido alguna duda con un modelo o tienes algún inconveniente o simplemente quieres contactar \ncon nosotros por una consulta, podrás hacerlo rellenando un simple formulario en el que introducirás tus datos \ny nosotros te contactaremos de la forma que hayas elegido lo antes posible.");
    	
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
    	
    	if(sliderPrecioA!=null) {
	    	sliderPrecioA.setOnMouseEntered((event) -> {
	    		sliderPrecioA.setCursor(Cursor.HAND);
			});
    	}
    	
    	if(sliderPrecioQ!=null) {
	    	sliderPrecioQ.setOnMouseEntered((event) -> {
	    		sliderPrecioQ.setCursor(Cursor.HAND);
			});
    	}
    	
    	if(sliderPrecioR!=null) {
    		sliderPrecioR.setOnMouseEntered((event) -> {
    			sliderPrecioR.setCursor(Cursor.HAND);
    		});
    	}
    	
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
			AnchorPane listadoControles = (AnchorPane) loader.load();
			
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
