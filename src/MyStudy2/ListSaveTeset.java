package MyStudy2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListSaveTeset extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		ListView lv = new ListView();
		ObservableList ov = FXCollections.observableArrayList();
		//ov.addAll("첫", "둘");
		lv.setItems(ov);

		Button bt = new Button("추가");
		Button bt2 = new Button("저장");
		Button bt3 = new Button("삭제");
		TextField tf = new TextField();
		bt.setOnAction(e -> {

			String abc = tf.getText().toString().trim();

			ov.add(abc);

		});

		// 리스트불러오기
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\text.txt");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int i = bfr.read();
			if (i < 0)
				break;
			sb.append((char) i);
			//ov.add(sb.toString());
			//sb.replace(0, ov.size(), "");

		}
		
		String abcd = sb.toString();
		String[] abcde = abcd.split(",");
		ov.addAll(abcde);
		fis.close();

		// 리스트저장하기
		bt2.setOnAction(e -> {

			BufferedWriter bfw;
			try {
				bfw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("C:\\Users\\Administrator\\Desktop\\text.txt"), "UTF8"));
				for (int i = 0; i < ov.size(); i++) {

					bfw.write(ov.get(i).toString() + ",");
					//bfw.write(",");
					//bfw.newLine();

				}
				bfw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		
		bt3.setOnAction(e ->{
			
			ov.remove(lv.getSelectionModel().getSelectedIndex());
			
		});

		VBox vb = new VBox();
		vb.getChildren().addAll(lv, bt, bt2, tf,bt3);
		Scene scene = new Scene(vb, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
