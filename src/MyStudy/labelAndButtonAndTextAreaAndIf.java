package MyStudy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//ȭ�� 1�� ����

public class labelAndButtonAndTextAreaAndIf extends Application{

	Button button;
	Label label;
	TextArea textarea;
	
	GridPane gridpane;
	
	
	@Override
	public void start(Stage primaryStage){
		
		
		button = new Button("����");
		label = new Label("nice");
		textarea = new TextArea();
		textarea.setMaxWidth(100);
		
		gridpane = new GridPane();
		
		
		//��ưŬ��
		button.setOnAction(e ->{
			
		button.setText("����");	
		button.setText(textarea.getText().toString());

		
		if(button.getText() == "����")
		{
			
			//label.setText(button.getText().toString());
			label.setText("�Ϳ�");
		
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
		System.out.println(button.getText() == "����");
		
		});
		
		//if(button.getText().toString() == "����")
		//{
		//label.setText("�Ϳ�");
		//}
		
		//add
		gridpane.add(button, 0, 0);
		gridpane.add(label, 1, 0);
		gridpane.add(textarea, 0, 2);
		
		//ȭ�鼳��
		Scene scene = new Scene(gridpane, 400, 400);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}