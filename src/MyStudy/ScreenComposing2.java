package MyStudy;
//package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//ȭ�� 1�� ����

public class ScreenComposing2 extends Application{
	
	Scene scene;
	Button button, button2;
	TextArea textarea, textarea2;
	
	@Override
	public void start(Stage primaryStage){
		
		//pane
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10));
		gridpane.setVgap(10);
		gridpane.setHgap(10);
		
		//pane2
		GridPane gridpane2 = new GridPane();
		//gridpane2.setPadding(new Insets(10));
		gridpane2.setPadding(new Insets(0,10,10,10));
		gridpane2.setVgap(10);
		gridpane2.setHgap(10);
		
		//borderpane
		BorderPane bpane = new BorderPane();
		
		bpane.setTop(gridpane);
		bpane.setLeft(gridpane2);
		
	
		//��ư
		button = new Button("��ư");
		button2 = new Button("��ư2");
		
		//textarea
		textarea = new TextArea(); 
		textarea.setPrefColumnCount(2);
		textarea.setPrefRowCount(2);
		textarea.setMaxWidth(1);
		
		textarea2 = new TextArea();
		textarea2.setPrefColumnCount(30);
		textarea2.setPrefRowCount(2);
		
		
		//textarea.setPrefWidth(200);
		//textarea.setMaxWidth(300);

		//��ư�̺�Ʈ
		
		//pane�� �߰��ϱ�
		gridpane.add(button, 0, 0);
		gridpane.add(button2, 1, 0);
		//gridpane.add(textarea, 1, 1);
		
		//pane�� �߰��ϱ�2
		gridpane2.add(textarea, 0, 0);
		gridpane2.add(textarea2, 0, 1);
		
		
		//����ȭ��
		scene = new Scene(bpane, 400, 350);
		primaryStage.setTitle("ȭ�鱸��");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}