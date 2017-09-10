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
		
		//버튼
		button = new Button(); 
		button.setText("Click me");
		
		//버튼2
		button2 = new Button(); 
		button2.setText("삭제");
			
		//콤보박스
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
		textfield.setPromptText("나는 천재다");
		
		//textarea2
	    TextArea textfield2 = new TextArea(); 
	    textfield2.setPrefColumnCount(50);
	    textfield2.setPrefWidth(200);
	    textfield2.setMaxWidth(100);
	    textfield2.scrollLeftProperty();
	    textfield2.setPromptText("하하하");
                
        
		System.out.println(textfield.getText());
        
        //이벤트핸들러
        button.setOnAction(e ->{
        	if(textfield.getText().isEmpty()) {
        	}
        
        	else {
        	comboBox.getItems().add(textfield.getText());
        	}
        	textfield.clear();
        });
        
        //이벤트핸들러
        button2.setOnAction(e ->{
        	//comboBox.getItems().clear();
        	
        	System.out.println(comboBox.getSelectionModel().getSelectedItem());
        	comboBox.getItems().remove(comboBox.getSelectionModel().getSelectedItem());
        	
        });
        
        //콤보박스 이벤트핸들러
        comboBox.setOnAction( e -> {
        	
        //System.out.println("User selected " + comboBox.getValue());
        textfield2.appendText("<" + comboBox.getSelectionModel().getSelectedItem() + ">" + "\n" );
    
        });
		
		
		//페인
		GridPane layout = new GridPane();
		layout.add(button,0,0);
		layout.add(button2, 1, 0);
		layout.add(comboBox,0,1);
		layout.add(textfield,2,0);
		layout.add(textfield2,2,1);
		
		
		//스택
		Scene scene = new Scene(layout,400,350);
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}

}
