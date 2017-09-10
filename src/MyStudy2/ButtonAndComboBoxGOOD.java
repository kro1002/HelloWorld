package MyStudy2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class ButtonAndComboBoxGOOD extends Application {

	Button button;
	Button button2;
	ComboBox<String> comboBox;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Title of the Window");
		
		//��ư
		button = new Button(); 
		button.setText("Click me");
		
		//��ư2
		button2 = new Button(); 
		button2.setText("����");
			
		//�޺��ڽ�
		comboBox = new ComboBox<String>();
		comboBox.setPromptText("What is your favorite movie?");
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "St. Vincent",
                "Blackhat");
                
        //textarea
        TextArea textfield = new TextArea(); 
		textfield.setPrefColumnCount(50);
		textfield.setPrefWidth(200);
		textfield.setMaxWidth(100);
		textfield.scrollLeftProperty();
		textfield.setPromptText("���� õ���");
		
		//textarea2
	    TextArea textfield2 = new TextArea(); 
	    textfield2.setPrefColumnCount(50);
	    textfield2.setPrefWidth(200);
	    textfield2.setMaxWidth(100);
	    textfield2.scrollLeftProperty();
	    textfield2.setPromptText("������");
                
        
		System.out.println(textfield.getText());
        
        //�̺�Ʈ�ڵ鷯
        button.setOnAction(e ->{
        	if(textfield.getText().isEmpty()) {
        	}
        
        	else {
        	comboBox.getItems().add(textfield.getText());
        	}
        	textfield.clear();
        });
        
        //�̺�Ʈ�ڵ鷯
        button2.setOnAction(e ->{
        	//comboBox.getItems().clear();
        	
        	System.out.println(comboBox.getSelectionModel().getSelectedItem());
        	comboBox.getItems().remove(comboBox.getSelectionModel().getSelectedItem());
        	
        });
        
        //�޺��ڽ� �̺�Ʈ�ڵ鷯
        comboBox.setOnAction( e -> {
        	
        //System.out.println("User selected " + comboBox.getValue());
        textfield2.appendText("<" + comboBox.getSelectionModel().getSelectedItem() + ">" + "\n" );
    
        });
		
		
		//����
		GridPane layout = new GridPane();
		layout.add(button,0,0);
		layout.add(button2, 1, 0);
		layout.add(comboBox,0,1);
		layout.add(textfield,2,0);
		layout.add(textfield2,2,1);
		
		
		//����
		Scene scene = new Scene(layout,400,350);
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}

}
