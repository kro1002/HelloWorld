package MyStudy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CastStudy extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox vb = new VBox();
		
		Button bt = new Button("버튼1");
		Button bt2 = new Button("버튼2");
		
		//형변환 가능 @FXML이 붙으면 형변환이 안되는 것 같다. 버그일지도
		bt = bt2;

//		vb.getChildren().addAll(bt,bt2);
		vb.getChildren().add(bt);
		//vb.getChildren().add(bt2);
		
		Scene scene = new Scene(vb, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
