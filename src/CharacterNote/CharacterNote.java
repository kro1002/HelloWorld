package CharacterNote;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CharacterNote extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		// 메인클래스이름 넣을 것
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CharacterNote.class.getResource("CharacterNote.fxml"));
		Parent root = (Parent) loader.load();

		// 컨트롤러자바클래서 이름넣을 것
		CharacterNoteFXML controller = loader.getController();

		Scene scene = new Scene(root, 610, 410);
		primaryStage.setScene(scene);
		primaryStage.setTitle("캐릭터노트");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
