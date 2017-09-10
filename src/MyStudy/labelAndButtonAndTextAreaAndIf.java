package MyStudy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//화면 1개 띄우기

public class labelAndButtonAndTextAreaAndIf extends Application{

	Button button;
	Label label;
	TextArea textarea;
	
	GridPane gridpane;
	
	
	@Override
	public void start(Stage primaryStage){
		
		
		button = new Button("나는");
		label = new Label("nice");
		textarea = new TextArea();
		textarea.setMaxWidth(100);
		
		gridpane = new GridPane();
		
		
		//버튼클릭
		button.setOnAction(e ->{
			
		button.setText("나는");	
		button.setText(textarea.getText().toString());

		
		if(button.getText() == "나는")
		{
			
			//label.setText(button.getText().toString());
			label.setText("와우");
		
		}
		else{
		
		label.setText(button.getText().toString());
		//textarea.clear();
		}
		
		System.out.println(button.getText().toString());
		System.out.println(button.getText());
		System.out.println(textarea.getText().toString());
		System.out.println(textarea.getText());
		System.out.println(label.getText());
		System.out.println(button.getText() == "나는");
		
		});
		
		//if(button.getText().toString() == "나는")
		//{
		//label.setText("와우");
		//}
		
		//add
		gridpane.add(button, 0, 0);
		gridpane.add(label, 1, 0);
		gridpane.add(textarea, 0, 2);
		
		//화면설정
		Scene scene = new Scene(gridpane, 400, 400);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}