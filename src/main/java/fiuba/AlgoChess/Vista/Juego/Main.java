package fiuba.AlgoChess.Vista.Juego;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.canvas.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

	Stage ventana;
	Scene sceneMenu, scene2;


	public Main() throws FileNotFoundException {
	}

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
		sceneMenu = new Scene(layout1,600,600);

		//Boton 2
		Button botonVolver = new Button("Volver");
		botonVolver.setOnAction(e -> ventana.setScene(sceneMenu));

		//Imagen tile
		Image tileSprite = new Image(new FileInputStream("texturas/tileSprite.png"));

		//Segundo Layout
		Pane layout2 = new Pane();
		layout2.getChildren().add(botonVolver);
		setCasilleros(layout2,tileSprite);
		scene2 = new Scene(layout2,600,600);

		ventana.setScene(sceneMenu);
		stage.show();
	}

	public void setCasilleros(Pane layout,Image img){
		for(int i = 0; i<20;i++){
			for(int j = 0; j<20;j++){
				ImageView imgView = new ImageView();
				imgView.setImage(img);
				imgView.setTranslateX(j*32);
				imgView.setTranslateY((i+1)*32);
				layout.getChildren().add(imgView);
			}

		}
	}
}