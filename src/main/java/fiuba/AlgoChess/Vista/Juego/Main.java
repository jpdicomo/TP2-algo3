package fiuba.AlgoChess.Vista.Juego;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Mi primera ventana");
		stage.show();
	}
}