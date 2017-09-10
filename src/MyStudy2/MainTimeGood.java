
package MyStudy2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainTimeGood extends Application{
	
	Stage window;
	TableView<TimeProductGood> table;

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("날짜표");
		
		//Name column
		TableColumn<TimeProductGood, String> nameColumn = new TableColumn<>("날짜");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		

		 
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn);
			
			
		VBox vBox = new VBox(); 
		vBox.getChildren().addAll(table);
		
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}

	
	public ObservableList<TimeProductGood> getProduct(){
		ObservableList<TimeProductGood> products = FXCollections.observableArrayList();
		products.add(new TimeProductGood("Laptop"));
		products.add(new TimeProductGood("Bouncy"));
		return products;
		
	}
}
