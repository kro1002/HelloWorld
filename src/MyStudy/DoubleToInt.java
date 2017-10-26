package MyStudy;

import javafx.application.Application;
import javafx.stage.Stage;

public class DoubleToInt extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		
		Double a = 1.2;
		int b = a.intValue();
		
		double c = Double.parseDouble(String.valueOf(b));
		
		
		//실수형이 들어간 나머지는 소수점으로 출력됨
		System.out.println(3.4 %3);
		
		
		
		
		System.out.println(c);
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
