package view;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Modelos;

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
    
    @FXML
    private ComboBox<String> comboColor;
    
    @FXML
    private TableView<Modelos> tablaModelos;
    
    @FXML
    private TableColumn<Modelos, String> columnaModelos;
    
    @FXML
    private TableColumn<Modelos, String> columnaEspecificaciones;
    
    @FXML
    private TextField filtrarEspecificaciones;

    @FXML
    private TextField filtrarModelo;
    
    @FXML
    private Button botonComprar;
    
	private static BorderPane rootLayout;
	
	private static Stage dialogStage;
	
	private ObservableList<Modelos> datosModelosA1 = FXCollections.observableArrayList(
    	    new Modelos("A1 Allstreet", "Consumo de combustible: 6,7–5,7 l/100km \nEmisión combinada de CO2: 152–128 g/km \nVelocidad máxima: 182 km/h \nAceleración 0-100 km/h: 11,5 s \nTipo de combustible: Super 95"),
    	    new Modelos("A1 Sportback", "Consumo de combustible: 6,8–5,4 l/100km \nEmisión combinada de CO2: 155–123 g/km \nVelocidad máxima: 193 km/h \nAceleración 0-100 km/h: 11 s \nTipo de combustible: Super 95")
    );
	
	private ObservableList<Modelos> filtroDatosModelosA1 = FXCollections.observableArrayList();
	
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
    	
    		listSeriesA.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    			if(newValue.equals("A1")) {
    				System.out.println("Se ha seleccionado los modelos: "+newValue);
    				abrirPaginaSeriesA1();
    			}
    		});
    		
    		listSeriesQ.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    			if(newValue.equals("Q2")) {
    				System.out.println("Se ha seleccionado los modelos: "+newValue);
    			}
    		});
    		
    		listOtrasSeries.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    			if(newValue.equals("e-tron GT")) {
    				System.out.println("Se ha seleccionado los modelos: "+newValue);
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
    	
    	if(tablaModelos!=null) {
    		columnaModelos.setCellValueFactory(cellData -> cellData.getValue().getModeloProperty());
	    	columnaEspecificaciones.setCellValueFactory(cellData -> cellData.getValue().getEspecificacionesProperty());
	    	
	    	tablaModelos.setItems(datosModelosA1);
	    	
	    	mostrarModeloElegido(null);
	    	
	    	tablaModelos.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> mostrarModeloElegido(newValue));
    	}
    	
	}
	
	@FXML
	private void filtrarModelo(KeyEvent event) {
		
		String filtroModelo = filtrarModelo.getText();
		
		if(filtroModelo.isEmpty()) {
			tablaModelos.setItems(datosModelosA1);
		}else {
			filtroDatosModelosA1.clear();
			
			for(Modelos m: datosModelosA1) {
				if(m.getModelo().toLowerCase().contains(filtroModelo.toLowerCase())) {
					filtroDatosModelosA1.add(m);
				}
			}
			columnaModelos.setCellValueFactory(cellData -> cellData.getValue().getModeloProperty());
			tablaModelos.setItems(filtroDatosModelosA1);
		}
	}
	
	@FXML
	private void filtrarEspecificaciones(KeyEvent event) {
		
		String filtroEspecificaciones = filtrarEspecificaciones.getText();
		
		if(filtroEspecificaciones.isEmpty()) {
			tablaModelos.setItems(datosModelosA1);
		}else {
			filtroDatosModelosA1.clear();
			
			for(Modelos m: datosModelosA1) {
				if(m.getEspecificaciones().toLowerCase().contains(filtroEspecificaciones.toLowerCase())) {
					filtroDatosModelosA1.add(m);
				}
			}
			columnaEspecificaciones.setCellValueFactory(cellData -> cellData.getValue().getEspecificacionesProperty());
			tablaModelos.setItems(filtroDatosModelosA1);
		}
	}
	
	@FXML
    private void handleComprar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("ModeloDialog.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			
			dialogStage = new Stage();
	        dialogStage.setTitle("Realizar pago");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(listadoControles);
	        dialogStage.setScene(scene);
	        
	        dialogStage.showAndWait();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
    }
	
	private void mostrarModeloElegido(Modelos modelo) {
        
		if (modelo != null) {
        	if(modelo.getModelo().equals("A1 Allstreet")) {
        		serieTextField.setText("Serie A1");
        		modeloTextField.setText(modelo.getModelo());
        		precioTextField.setText("32.260 €");
        		
        		comboColor.getItems().addAll("Negro metalizado", "Gris efecto perla", "Azul metalizado", "Blanco glaciar", "Blanco cortina", "Plata metalizado", "Rojo efecto perla", "Amarillo Pitón", "Gris metalizado");
        	}else if(modelo.getModelo().equals("A1 Sportback")){
        		serieTextField.setText("Serie A1");
        		modeloTextField.setText(modelo.getModelo());
        		precioTextField.setText("28.340 €");
        		
        		comboColor.getItems().addAll("Negro metalizado", "Gris efecto perla", "Azul metalizado", "Blanco glaciar", "Rojo efecto perla", "Amarillo Pitón");
        	}
        	comboColor.setValue("Color");
        } else {
        	serieTextField.setText("");
        	modeloTextField.setText("");
            precioTextField.setText("");
        }
    }
	
	@FXML
	private void abrirPaginaContacto(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaContacto.fxml"));
			GridPane listadoControles = (GridPane) loader.load();
			
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaMundoAudiSostenibilidad(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaSostenibilidad.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaModelos(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaModelos.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaAyuda(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaAyuda.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void abrirPaginaSeriesA1() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControllerApp.class.getResource("PantallaSeriesA1.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		ControllerApp.rootLayout = rootLayout;
	}	
	
	public static Stage getDialogStage() {
		return dialogStage;
	}
	public void closeWindows() {}
}
