package ProjectListFileIO;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjectListFileIO extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		// 메인클래스이름 넣을 것
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ProjectListFileIO.class.getResource("ProjectListFileIO.fxml"));
		Parent root = (Parent) loader.load();

		// 컨트롤러자바클래서 이름넣을 것
		ProjectListFileIOController controller = loader.getController();

		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("ListFileIO");

	}

	public static void main(String[] args) {
		launch(args);
	}
}
