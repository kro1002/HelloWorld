package CharacterNote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class CharacterNoteFXML {

	@FXML
	private BorderPane bp;

	// @FXML
	// private TextArea ta;

	@FXML
	private Label listlb;

	@FXML
	private ListView<String> lv;

	@FXML
	private Button addbt;

	@FXML
	private Button removebt;

	@FXML
	private TextField tf;

	@FXML
	private TextField tf2;

	@FXML
	private Button savebt;

	@FXML
	private Button loadbt;

	ArrayList<TextArea> lta;
	ObservableList<String> ov;
	TextArea[] tas;

	@FXML
	public void initialize() throws IOException {
		
		

		ov = FXCollections.observableArrayList();
		//ov.addAll("리스트", "리스트2");
		lv.setItems(ov);

		// 명제:n번째리스트는 n번째 ta를 갖는다.
		// 서브명제:n개의 ta를 bp센터에 위치시킨다.
		// 서브명제:리스트인덱스를 대응시킨다.

		lta = new ArrayList<TextArea>();

		int size = 1000;
		tas = new TextArea[size];
		for (int i = 0; i < size; i++) {
			tas[i] = new TextArea();

			lta.add(tas[i]);

		}
		
		firstread();

		addbt.setOnAction(e -> {

			ov.add(tf.getText().toString());
			tf.clear();

		});

		// 선택한 인덱스의 id에 해당하는 텍스트파일만들기
		lv.setOnMouseClicked(e -> {

			if (lv.getSelectionModel().getSelectedIndex() != -1) {

				bp.setCenter(lta.get(lv.getSelectionModel().getSelectedIndex()));

			}
		});

		savebt.setOnAction(e -> {

			String abc = tf2.getText().toString();

			File f2 = new File("C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abc);
			f2.mkdirs();

			if (f2.isDirectory()) {
				System.out.println("success");
			} else {
				System.out.println("errors");
			}

			for (int i = 0; i < ov.size(); i++) {

				String abcde = lv.getItems().get(i);
				File f = new File("C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abc + "\\" + abcde + ".txt");
				if (!f.exists()) {

					try {
						f.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
			for (int i = 0; i < ov.size(); i++) {
				String abcde = lv.getItems().get(i);
				File f = new File("C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abc + "\\" + abcde + ".txt");
				BufferedWriter bfw;
				try {
					bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF8"));
					bfw.write(lta.get(i).getText().toString());
					lta.get(i).setId(abcde);
					bfw.close();

				} catch (UnsupportedEncodingException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			BufferedWriter bfw;
			try {
				bfw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("C:\\Users\\Administrator\\Desktop\\secondsoftware\\firstload.txt"),
						"UTF8"));
				bfw.write(tf2.getText().toString());
				bfw.close();
			} catch (UnsupportedEncodingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		

		});

		removebt.setOnAction(e -> {

			// lta를 삭제한다음에 ov를 삭제해야함. 순서중요!
			lta.remove(lv.getSelectionModel().getSelectedIndex());
			ov.remove(lv.getSelectionModel().getSelectedIndex());

			String abc = tf2.getText().toString();
			File f = new File("C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abc);
			if (f.isDirectory()) {
				System.out.println("directory yes");

				// f.getAbsolutePath();

				// System.out.println(f.getAbsolutePath());

				// 디렉토리내 파일각각 모두 삭제하기(c:로 해야함 이름을 C로 했음). 디렉토리삭제는 내부파일이 없을 때 디렉토리삭제가 가능함
				// String[] children = f.list();
				// for (int i = 0; i < children.length; i++) {
				// String longs = "C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abc +
				// "\\" + children[i];
				// File f2 = new File(longs);
				// System.out.println(longs);
				// if (f2.delete()) {
				// System.out.println("success delete");
				// } else {
				// System.out.println("삭제 안됨");
				// }
				//
				// }

				// 100%방법
				File[] fs = f.listFiles();
				for (int i = 0; i < fs.length; i++) {

					fs[i].delete();
					System.out.println(fs[i].getPath());
				}

			}

		});

		loadbt.setOnAction(e -> {

			ov.clear();

			// lta.clear();

			for (int i = 0; i < 1000; i++) {

				tas[i].clear();

			}

			// 폴더내에 있는 이름들을 리스트에 두고,
			try {

				String abcd = tf2.getText().toString();
				File ff2 = new File("C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abcd);
				String[] liststring = ff2.list();

				System.out.println(ff2.getPath());

				for (int i = 0; i < liststring.length; i++) {

					String liststring2 = liststring[i].replaceAll(".txt", "");
					System.out.println(liststring2);
					ov.add(liststring2);

				}

				// 리스트뷰제목에 해당하는 파일을 ta에 가져올 것
				for (int i = 0; i < ov.size(); i++) {
					String lvname = lv.getItems().get(i);
					File f = new File(
							"C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abcd + "\\" + lvname + ".txt");
					ov.get(i);

					// 파일에 내용 쓰기
					FileInputStream fis2 = new FileInputStream(f.getPath());
					BufferedReader bfr = new BufferedReader(new InputStreamReader(fis2, "UTF-8"));
					StringBuilder sb = new StringBuilder();

					while (true) {
						int j = bfr.read();
						if (j < 0)
							break;
						sb.append((char) j);
					}

					lta.get(i).setText(sb.toString());

					fis2.close();

				}

			} catch (Exception e2) {
				System.out.println("errors");
			}

		});

	}

	public void firstread() throws IOException {
		// 파일에 내용 쓰기
		File f = new File("C:\\Users\\Administrator\\Desktop\\secondsoftware\\firstload.txt");
		FileInputStream fis = new FileInputStream(f);
		BufferedReader bfr = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int i = bfr.read();
			if (i < 0)
				break;
			sb.append((char) i);
		}
		fis.close();

		// 폴더내에 있는 이름들을 리스트에 두고,
		try {

			String abcd = sb.toString();
			File ff2 = new File("C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abcd);
			String[] liststring = ff2.list();

			System.out.println(ff2.getPath());

			for (int i = 0; i < liststring.length; i++) {

				String liststring2 = liststring[i].replaceAll(".txt", "");
				System.out.println(liststring2);
				ov.add(liststring2);

			}

			// 리스트뷰제목에 해당하는 파일을 ta에 가져올 것
			for (int i = 0; i < ov.size(); i++) {
				String lvname = lv.getItems().get(i);
				File f1 = new File(
						"C:\\Users\\Administrator\\Desktop\\secondsoftware\\" + abcd + "\\" + lvname + ".txt");
				ov.get(i);

				// 파일에 내용 쓰기
				FileInputStream fis2 = new FileInputStream(f1.getPath());
				BufferedReader bfr1 = new BufferedReader(new InputStreamReader(fis2, "UTF-8"));
				StringBuilder sb1 = new StringBuilder();

				while (true) {
					int j = bfr1.read();
					if (j < 0)
						break;
					sb1.append((char) j);
				}

				lta.get(i).setText(sb1.toString());

				fis2.close();

			}
			
			tf2.setText(abcd);

		} catch (Exception e2) {
			System.out.println("errors");
		}

	}

}

// f디렉토리내에 있는 모든 파일 지우기
// public static boolean deleteDir(File dir)
// {
// if (dir.isDirectory())
// {
//// get the names of the child files and directories into an array of String
// String[] children = dir.list();
//
//// for each child file or directory
// for (int i = 0; i < children.length; i++)
// {
//// recursively delete
// deleteDir(new File(dir, children[i]));
// }
// }
//
// return dir.delete();
// }


//파일지우기2
// File file = new File("C:/dir");
//
// if( file.exists() ){ //파일존재여부확인
//
// if(file.isDirectory()){ //파일이 디렉토리인지 확인
//
// File[] files = file.listFiles();
//
// for( int i=0; i<files.length; i++){
// if( files[i].delete() ){
// System.out.println(files[i].getName()+" 삭제성공");
// }else{
// System.out.println(files[i].getName()+" 삭제실패");
// }
// }
//
// }
// if(file.delete()){
// System.out.println("파일삭제 성공");
// }else{
// System.out.println("파일삭제 실패");
// }
//
// }else{
// System.out.println("파일이 존재하지 않습니다.");
// }
//
// }


