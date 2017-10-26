package MyStudy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class GuiScreenMinController {

	@FXML
	public Button button;

	@FXML
	public ListView<String> lv;

	@FXML
	public void initialize() {

		// 안됨 main에서 정의해 주어야 하는 듯
		//ObservableList<String> ov = FXCollections.observableArrayList();
		//ov.addAll("너는", "바보");
		// lv.setItems(ov);

		// 작동안함. 여기서 정의한 버튼은
		// Button button2 = new Button("안녕");
		// button = button2;

		String abc = " 왓";

		button.setText("뭐야" + abc);

	}

}
