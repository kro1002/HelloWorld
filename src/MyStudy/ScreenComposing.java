package MyStudy;
//package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//ȭ�� 1�� ����

public class ScreenComposing extends Application{
	
	Scene scene;
	Button button, button2;
	TextArea textarea;
	
	
	@Override
	public void start(Stage primaryStage){
		
		//pane
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10));
		gridpane.setVgap(10);
		gridpane.setHgap(10);
	
		//��ư
		button = new Button("��ư");
		button2 = new Button("��ư2");
		
		//textarea
		textarea = new TextArea(); 
		textarea.setPrefColumnCount(10);
		textarea.setPrefRowCount(10);
		
		
		//textarea.setPrefWidth(200);
		//textarea.setMaxWidth(300);

		//��ư�̺�Ʈ
		
		
		//pane�� �߰��ϱ�
		gridpane.add(button, 0, 0);
		gridpane.add(button2, 0, 1);
		gridpane.add(textarea, 1, 1);
		
		
		//����ȭ��
		scene = new Scene(gridpane, 400, 350);
		primaryStage.setTitle("ȭ�鱸��");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}