package MyStudy;
//package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


//ȭ�� 1�� ����

public class ButtonAndLabel extends Application{
	
	Scene scene;

	@Override
	public void start(Stage primaryStage){
		
		HBox hbox = new HBox();

		Button btOk = new Button("�ſﴺ��");

		//��ư�� ������ ��
		
		btOk.setOnAction(e -> {
			
			hbox.getChildren().add(new Label("���� �߰��Ǿ����ϴ�."));
			hbox.getChildren().add(new TextField("nice body"));
			});

		hbox.getChildren().add(btOk);
	
		//ȭ��
		scene = new Scene(hbox, 400, 350);
		primaryStage.setTitle("��ư�� ������ �� ���� �߰��ϱ�");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}