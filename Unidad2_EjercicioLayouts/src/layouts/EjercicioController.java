package layouts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EjercicioController {
	
	@FXML
    private ChoiceBox<Object> choice1;

    @FXML
    private ListView<String> list1;
    
    @FXML
    private ComboBox<String> combo1;
    
    @FXML
    private TreeView<String> tree1;
    
    private ObservableList<String> predeterminado = FXCollections.observableArrayList();
    private ObservableList<String> seleccion = FXCollections.observableArrayList();
    
    @FXML
    private void initialize() {
    	
    			
    	choice1.getItems().addAll("New York", "Orlando", new Separator(), "London", "Manchester");
    	
    	choice1.setValue("Seleccione un valor...");
    	
    	combo1.getItems().addAll("Inglés", "Japonés", "Español");
    	
    	combo1.setValue("Selecciona un idioma");
    	
    	seleccion.addAll("Object", "Classes", "Functions", "Variables", "Compiler", 
    				"Debugger", "Projects", "Beans", "Libraries", "Modules");
    	
    	for (int i = 0; i < 10; i++) {
    		predeterminado.add("Indeterminate (pick a choice)");
        }
    	
    	list1.setItems(predeterminado);
    	list1.setCellFactory(ComboBoxListCell.forListView(seleccion));
    	list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	ImageView iv = new ImageView(new Image("C:\\Users\\Alumno_Tarde\\eclipse-workspace\\Unidad2_EjercicioLayouts\\imagenes\\vip.png"));
    	iv.setPreserveRatio(true);
    	iv.setFitHeight(10);
    	
    	
    	TreeItem<String> rootItemInbox = new TreeItem<String>("Inbox", iv);
    	
    	TreeItem<String> salesItem = new TreeItem<String>("Sales");
    	TreeItem<String> MarketingItem = new TreeItem<String>("Marketing");
    	TreeItem<String> DistributionItem = new TreeItem<String>("Distribution");
    	TreeItem<String> CostsItem = new TreeItem<String>("Costs");
    	
    	rootItemInbox.getChildren().add(salesItem);
    	rootItemInbox.getChildren().add(MarketingItem);
    	rootItemInbox.getChildren().add(DistributionItem);
    	rootItemInbox.getChildren().add(CostsItem);
    	
    	rootItemInbox.setExpanded(true);
    	tree1.setRoot(rootItemInbox);
    }

}
