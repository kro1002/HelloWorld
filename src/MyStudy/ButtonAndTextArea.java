package MyStudy;
//package project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//화면 1개 띄우기

public class ButtonAndTextArea extends Application{
	
	Scene scene;

	@Override
	public void start(Stage primaryStage){
		
		GridPane gridpane = new GridPane();
		GridPane gridpane2 = new GridPane();
		gridpane.setHgap(10);
		
		Button btOk = new Button("거울뉴런");
		Button btOk2 = new Button("순간저장");
		
		Button btOk3 = new Button("화면전환");
		Button btOk4 = new Button("뒤로");
		
		Scene screen2 = new Scene(gridpane2, 400,350);
		TextArea textfield2 = new TextArea();
		
		gridpane2.add(btOk4, 0, 0);
		gridpane2.add(textfield2, 0, 1);
		
	
		//textfield.appendText(btOk.getText().toString());
		
			
		//버튼을 눌렀을 때
		btOk.setOnAction(e -> {
			textfield.appendText(btOk.getText().toString() + "\n");
			});

		btOk2.setOnAction(e -> {
			textfield2.appendText("<" + btOk.getText().toString() +">" + "\n");
			textfield2.appendText(textfield.getText().toString() + "\n");
			textfield2.appendText("\n");
			textfield.clear();
			});
		
		//버튼을 눌렀을 때2
		btOk3.setOnAction(e -> {
			primaryStage.setScene(screen2);
			primaryStage.setTitle("화면전환");
			
			});
		
		
		btOk4.setOnAction(e -> {
			primaryStage.setScene(scene);
			primaryStage.setTitle("원래화면");
			
			});
						
		gridpane.add(btOk, 1,0);
		gridpane.add(textfield, 3, 1);
		gridpane.add(btOk2, 1, 1);
		gridpane.add(btOk3, 1, 3);
		
		scene = new Scene(gridpane, 400, 350);
		primaryStage.setTitle("순간저장을 누르면 두번째화면에 저장");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}