
package MyStudy2;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainProductGOOD extends Application{
	
	Stage window;
	TableView<ProductGOOD> table;
	//new add 
	TextField nameInput, priceInput, quantityInput;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("���� ����");
		
		//Name column
		TableColumn<ProductGOOD, String> nameColumn = new TableColumn<>("����ǰ");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//Name column
		TableColumn<ProductGOOD, Double> priceColumn = new TableColumn<>("����");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
		
		//Name column
		TableColumn<ProductGOOD, String> quantityColumn = new TableColumn<>("����"); 
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		 
		table = new TableView<>();
		table.setItems(getProduct());
		//table.getColumns().addAll(nameColumn,quantityColumn);
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
			
		//Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
	
		//Price input
		priceInput = new TextField();
		priceInput.setPromptText("Price");
		priceInput.setMinWidth(100);
		
		//Quantity input
		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");
		quantityInput.setMinWidth(100);
		
		//button total
		
		
		int tablecount = table.getItems().size();
		Double pricelabel;
		
	    Double totalprice = 0.0;
		for(int i = 0; i< tablecount; i++) {
		pricelabel = priceColumn.getCellData(i);
		totalprice = totalprice + pricelabel;
					
		}
		
				
		//Label label = new Label("�� ������");
	    Label label2 = new Label("�Ѱ����� " + totalprice.toString() + "�� �Դϴ�");
				
		//Button
	    
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> {
		
		
		try {
		addButtonClicked();
		
		int tablecount2 = table.getItems().size();
		Double pricelabel2;
		//double totalprice2;
		Double totalprice2 = 0.0;
		
		for(int i = 0; i< tablecount2; i++) {
			pricelabel2 = priceColumn.getCellData(i);
			totalprice2 = totalprice2 + pricelabel2;
						
			}
	
		label2.setText("�Ѱ����� " + totalprice2.toString() + "�� �Դϴ�");
		}
		catch(Exception e1){
		//label.setText("");
		label2.setText("���� ���� �Էµ��� �ʾҽ��ϴ�");
		}
		
		});
		
	
		
		
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());
		
	
		//hBox
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10,10,10,10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);		
		
		
		
		
		//hBox2
		HBox hBox2 = new HBox();
		hBox2.setPadding(new Insets(10,10,10,10));
		hBox2.setSpacing(10);
		hBox2.getChildren().addAll(label2);	
		
		//pane
		VBox vBox = new VBox(); 
		vBox.getChildren().addAll(table, hBox2, hBox);
		
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}
	//Add Button clicked
	public void addButtonClicked() {
	
		ProductGOOD product = new ProductGOOD();
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setQuantity(Integer.parseInt(quantityInput.getText()));
		table.getItems().add(product);
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();}
		
	
	
	//Delete button Clicked
	public void deleteButtonClicked() {
		ObservableList<ProductGOOD> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
	}
	
	public ObservableList<ProductGOOD> getProduct(){
		ObservableList<ProductGOOD> products = FXCollections.observableArrayList();
		//products.add(new ProductGOOD("Laptop",859.00, 20));
		//products.add(new ProductGOOD("Bouncy Ball",2.49, 198));
		//products.add(new Product("Toilet",99.00, 74));
		//products.add(new Product("The Notebook DVD",19.99, 12));
		//products.add(new Product("Corn",1.49, 856));
		return products;
		
	}
}
