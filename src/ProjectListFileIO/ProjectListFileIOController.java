package ProjectListFileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProjectListFileIOController {

	@FXML
	private Button newbt;

	@FXML
	private Button loadbt;

	@FXML
	private Button savebt;

	@FXML
	private TextField tf;

	@FXML
	private Label lb;

	@FXML
	private TextArea ta;

	File directory;
	File file;

	@FXML
	public void initialize() {

		tf.setPromptText("프로젝트명");

		// ta = 폴더명, 해당 폴더명 아래 tf네임의 텍스트파일저장!
		savebt.setOnAction(e -> {

			if (!tf.getText().toString().trim().isEmpty()) {
				lb.setText("파일존재유무");

				String abc = tf.getText().toString().trim();
				String abcd = tf.getText().toString().trim() + ".ta";
				System.out.println(abcd);
				
				directory = new File("C:\\Users\\Administrator\\Desktop\\ProjectListFileIO\\" + abc);

				directoryMake(directory);

				file = new File(directory.getPath() + "\\" + abcd + ".txt");

				createFilewithTa(file, ta, lb);

			} else {
				lb.setText("프로젝트명을 입력하세요");
			}

		});

	}

	private void createFilewithTa(File file, TextArea ta, Label lb) {
		if (file.exists()) {
			System.out.println("file exists");
			lb.setText("파일덮어씌우기(더블클릭)");
			lb.setOnMouseClicked(e1 -> {
				if (e1.getClickCount() == 2) {

					taText(ta, file);

					lb.setText("파일을 덮어씌웠습니다");

				}
			});

		} else {
			try {
				file.createNewFile();
				System.out.println("file created");

				// 파일에 ta text넣기

				taText(ta, file);

			} catch (IOException e1) {
				System.out.println("file didn't created");
			}
		}

	}

	private void directoryMake(File directory) {
		if (directory.exists()) {
			System.out.println("directory exists");
		} else {

			directory.mkdirs();
			System.out.println("directory created");

		}

	}

	// 파일에 ta text넣기
	void taText(TextArea ta, File file) {

		BufferedWriter bfw;
		try {
			bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
			bfw.write(ta.getText().toString());
			bfw.close();
			System.out.println("file written");

		} catch (IOException e1) {
			System.out.println("file didn't written");
		}

	}

}
