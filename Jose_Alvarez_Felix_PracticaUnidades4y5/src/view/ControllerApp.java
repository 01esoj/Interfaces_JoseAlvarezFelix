package view;

import java.io.IOException;

import java.util.Arrays;

import graficos.ControllerBarChart;
import graficos.ControllerPieChart;
import graficos.ControllerStackedAreaChart;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import practicaUnidades4y5.PantallaPrincipal;

/**
 * Controlador de la pantalla principal que carga las distintas pantallas y contiene los componentes de cada una
 * @author Jose Alvarez Felix
 * @version 09/02/2023
 */
public class ControllerApp {
	
	private FXMLLoader loader;
	
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
    
    @FXML
    private Slider sliderPrecioA;

    @FXML
    private Slider sliderPrecioQ;

    @FXML
    private Slider sliderPrecioR;
    
    @FXML
    private TextField modeloTextField;

    @FXML
    private TextField precioTextField;

    @FXML
    private TextField serieTextField;
    
	private static BorderPane rootLayout;
	
	private static Stage dialogStage;
	
	private final static StringProperty modeloActual = new SimpleStringProperty();
	private boolean inicializadoModelo = false;
	
	public static String getModeloActual() {
		return modeloActual.get();
	}
	
	public static StringProperty modeloActualProperty() {
	      return modeloActual;
	}
	
	public void setModeloActual(String paramModelo) {
		if (!inicializadoModelo) {
			modeloActual.set(paramModelo);
			inicializadoModelo = true;
		}
	}
	
	/**
     * Metodo para inicializar el controlador que se llama cuando se carga el FXML
     */
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
    	
    	if(treeSeries!=null) {
    		treeSeries.setRoot(series);
    	}
    	
    	if(listSeriesA!=null) {
    		listSeriesA.getItems().addAll("A1", "A3", "A4", "A5", "A6", "A7", "A8");
    		listSeriesQ.getItems().addAll("Q2", "Q3", "Q4 e-tron", "Q5", "Q7", "Q8");
    		listOtrasSeries.getItems().addAll("e-tron GT", "e-tron", "TT", "R8", "RS");
    		
    		listSeriesA.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    			setModeloActual(newValue);
    			for(String modelo : Arrays.asList(newValue)) {
    				System.out.println("Se ha seleccionado el modelo: "+modelo);
    				abrirPaginaSeries();
    			}
    		});
    		
    		listSeriesQ.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    			setModeloActual(newValue);
    			for(String modelo : Arrays.asList(newValue)) {
    				System.out.println("Se ha seleccionado el modelo: "+modelo);
    				abrirPaginaSeries();
    			}
    		});
    		
    		listOtrasSeries.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    			setModeloActual(newValue);
    			for(String modelo : Arrays.asList(newValue)) {
    				System.out.println("Se ha seleccionado el modelo: "+modelo);
    				abrirPaginaSeries();
    			}
    		});
    	}
    	
    	TreeItem<String> ayuda = new TreeItem<String>("Ayuda");
    	
    	TreeItem<String> ayudaConocenos = new TreeItem<String>("Conocenos");
    	TreeItem<String> ayudaModelos = new TreeItem<String>("¿Como puedo ver los distintos modelos?");
    	TreeItem<String> ayudaMundoAudi = new TreeItem<String>("¿Como puedo saber mas de la marca?");
    	TreeItem<String> ayudaContacto = new TreeItem<String>("¿Como puedo contactar con vosotros en caso de ayuda?");
    	
    	TreeItem<String> ayudaInfoConocenos = new TreeItem<String>("En MyAudi tendras un rapido acceso a todo lo que alberga nuestra marca. Podras navegar de una forma muy \nsencilla entre los distintos modelos de los que disponemos, estar a la ultima en cuanto a novedades se refiere,\n contactar con nosotros en caso de necesitar ayuda y muchas mas cosas que te explicamos en los demas \napartados.");
    	TreeItem<String> ayudaInfoModelos = new TreeItem<String>("Para poder ver todos los modelos de los que disponemos y sus precios tendras que dirigirte a la pestana de la \nizquierda y desplegar la seccion Modelos. Una vez dentro, podras escoger entre las distintas series de nuestra\n marca y poder visualizar con mas detalle las especificaciones del modelo que escojas. De lo contrario si \nprefieres buscar un modelo que se ajuste a tu presupuesto podras deslizar en el rango de precio correspodiente \na cada serie y encontrar el que mas se adapte a tus necesidades.");
    	TreeItem<String> ayudaInfoMundoAudi = new TreeItem<String>("Si lo que te interesa es saber como trabajamos, como nos involucramos con el medio ambiente, cuales son \nnuestros procesos de fabricacion... tendros que dirigirte a la pestana de la izquierda y desplegar la seccion \nMundo Audi. Una vez alla podras descubrir como trabajamos. Ademas, sera en esa seccion en la que iremos \nactualizando distintas promociones.");
    	TreeItem<String> ayudaInfoContacto = new TreeItem<String>("Si te ha surgido alguna duda con un modelo o tienes algun inconveniente o simplemente quieres contactar \ncon nosotros por una consulta, podras hacerlo rellenando un simple formulario en el que introduciras tus datos \ny nosotros te contactaremos de la forma que hayas elegido lo antes posible.");
    	
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
	
	/*
	 * Metodo que carga la pagina de contacto
	 */
	@FXML
	private void abrirPaginaContacto(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaContacto.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			listadoControles.getStylesheets().addAll(this.getClass().getResource("Contacto.css").toExternalForm());

			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Metodo que carga la pagina de sostenibilidad
	 */
	@FXML
	private void abrirPaginaMundoAudiSostenibilidad(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaSostenibilidad.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			listadoControles.getStylesheets().addAll(this.getClass().getResource("Sostenibilidad.css").toExternalForm());

			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Metodo que carga la pagina de modelos
	 */
	@FXML
	private void abrirPaginaModelos(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaModelos.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			listadoControles.getStylesheets().addAll(this.getClass().getResource("Modelos.css").toExternalForm());

			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Metodo que carga la pagina de ayuda
	 */
	@FXML
	private void abrirPaginaAyuda(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaAyuda.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			listadoControles.getStylesheets().addAll(this.getClass().getResource("Ayuda.css").toExternalForm());
			
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Metodo que carga la pagina de series
	 */
	@FXML
	private void abrirPaginaSeries() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaSeries.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			listadoControles.getStylesheets().addAll(this.getClass().getResource("Series.css").toExternalForm());

            
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Metodo que carga la pagina con el grafico de precios de los modelos de la serie a 
	 */
	@FXML
	private void compararSerieA(ActionEvent event) {
    	try {
    		// Se crea un nuevo diálogo para mostar el gráfico
    		this.loader = new FXMLLoader();
            this.loader.setLocation(PantallaPrincipal.class.getResource("/graficos/PieChart.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            dialogStage = new Stage();
            dialogStage.setTitle("Estadísticas de precios");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            scene.getStylesheets().addAll(this.getClass().getResource("/graficos/PieChart.css").toExternalForm());
            
	        // Se pasa como parametro el listado de calificaciones
	        ControllerPieChart controller = this.loader.getController();
	        controller.setPieData(controller.loadPieData());
	        controller.initPieChart();
	        
	        dialogStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * Metodo que carga la pagina con el grafico de precios de los modelos de la serie q 
	 */
	@FXML
	private void compararSerieQ(ActionEvent event) {
    	try {
    		// Se crea un nuevo dialogo para mostar el gráfico
    		this.loader = new FXMLLoader();
            this.loader.setLocation(PantallaPrincipal.class.getResource("/graficos/BarChart.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            dialogStage = new Stage();
            dialogStage.setTitle("Estadísticas de precios");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
    		scene.getStylesheets().addAll(this.getClass().getResource("/graficos/BarChart.css").toExternalForm());
    		
	        // Se pasa como parámetro el listado de calificaciones
	        ControllerBarChart controller = this.loader.getController();
	        controller.setDist1(controller.loadDist1());
	        controller.initBarChart();
	        
	        dialogStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * Metodo que carga la pagina con el grafico de precios de los modelos del resto de series
	 */
	@FXML
	private void compararOtrasSerie(ActionEvent event) {
    	try {
    		// Se crea un nuevo diálogo para mostar el gráfico
    		this.loader = new FXMLLoader();
            this.loader.setLocation(PantallaPrincipal.class.getResource("/graficos/StackedAreaChart.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            dialogStage = new Stage();
            dialogStage.setTitle("Estadísticas de precios");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);    	
            scene.getStylesheets().addAll(this.getClass().getResource("/graficos/StackedArea.css").toExternalForm());
            
	        // Se pasa como parámetro el listado de calificaciones
	        ControllerStackedAreaChart controller = this.loader.getController();
	        controller.setDist2(controller.loadDist2());
	        controller.initStackedAreaChart();
	        
	        dialogStage.show();
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
		ControllerApp.rootLayout = rootLayout;
	}	
	
	/**
	 * Getter para que los controladores accedan al Stage con la pantalla inicial
	 * @return El Stage con la pantalla inicial principal
	 */
	public static Stage getDialogStage() {
		return dialogStage;
	}
	
	/**
	 * Metodo para cerrar la pantalla inicial cuando se carga la pantalla principal
	 */
	public void closeWindows() {}
}
