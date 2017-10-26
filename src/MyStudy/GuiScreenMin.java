package MyStudy;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GuiScreenMin extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		// 메인클래스이름 넣을 것
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GuiScreenMin.class.getResource("GuiScreenMin.fxml"));
		BorderPane root = (BorderPane) loader.load();

		// 컨트롤러자바클래서 이름넣을 것
		GuiScreenMinController controller = loader.getController();

		// list에 ov넣기. 안됨
		//ObservableList<String> ov = FXCollections.observableArrayList();
		//ov.add("hi");	
		//controller.lv.setItems(ov);

		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setMinWidth(650.0);
		primaryStage.setMinHeight(450.0);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
