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


//화면 1개 띄우기

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
	
		//버튼
		button = new Button("버튼");
		button2 = new Button("버튼2");
		
		//textarea
		textarea = new TextArea(); 
		textarea.setPrefColumnCount(10);
		textarea.setPrefRowCount(10);
		
		
		//textarea.setPrefWidth(200);
		//textarea.setMaxWidth(300);

		//버튼이벤트
		
		
		//pane에 추가하기
		gridpane.add(button, 0, 0);
		gridpane.add(button2, 0, 1);
		gridpane.add(textarea, 1, 1);
		
		
		//최종화면
		scene = new Scene(gridpane, 400, 350);
		primaryStage.setTitle("화면구성");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}