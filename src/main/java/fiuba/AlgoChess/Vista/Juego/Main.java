package fiuba.AlgoChess.Vista.Juego;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Stage ventana;
	Scene scene1, scene2;

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ventana = stage;
		stage.setTitle("AlgoChess");

		//Elementos 1
		Label label1 = new Label("Binevenido a AlgoChess!");
		Button botonJugar = new Button("Jugar");
		botonJugar.setOnAction(e -> ventana.setScene(scene2));

		//Primer layout
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1 ,botonJugar);
		scene1 = new Scene(layout1,200,200);

		//Boton 2
		Button botonVolver = new Button("Volver");
		botonVolver.setOnAction(e -> ventana.setScene(scene1));

		//Segundo Layout
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(botonVolver);
		scene2 = new Scene(layout2,200,200);

		ventana.setScene(scene1);
		stage.show();
	}

}