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


//화면 1개 띄우기

public class ButtonAndLabel2 extends Application{
	
	Scene scene;

	@Override
	public void start(Stage primaryStage){
		
		HBox hbox = new HBox();

		Button btOk = new Button("거울뉴런");

		//버튼을 눌렀을 때
		
		btOk.setOnAction(e -> {
			
			hbox.getChildren().add(new Label(btOk.getText().toString()));
			hbox.getChildren().add(new TextField(btOk.getText().toString()));
			});

		hbox.getChildren().add(btOk);
	
		//화면
		scene = new Scene(hbox, 400, 350);
		primaryStage.setTitle("버튼을 눌렀을 때 라벨을 추가하기");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}