package fiuba.AlgoChess.Vista.Juego;

import fiuba.AlgoChess.Vista.Juego.Handlers.BotonNuevaPartidaHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.canvas.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

	private Stage escenario;
	private Scene sceneMenu, scene2;


	public Main() throws FileNotFoundException {
	}

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.escenario = stage;
		this.escenario.setTitle("AlgoChess");


//
//		//Boton 2
//		Button botonVolver = new Button("Volver");
//		botonVolver.setOnAction(e -> ventana.setScene(sceneMenu));

		//Imagen tile
		Image tileSprite = new Image(new FileInputStream("texturas/tileSprite.png"));
//
//		//Segundo Layout
//		Pane layout2 = new Pane();
//		layout2.getChildren().add(botonVolver);
//		setCasilleros(layout2,tileSprite);
//		scene2 = new Scene(layout2,600,600);

		escenario.setScene(this.pantallaInicial());
		stage.show();
	}
	private Scene pantallaInicial() throws FileNotFoundException {

		Label labelTitulo = new Label("AlgoChess");
		labelTitulo.setFont(Font.font("Verdana", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		Button botonNuevaPartida = new Button("Nueva Partida");
		botonNuevaPartida.setFont(Font.font("Verdana", 16));

		BotonNuevaPartidaHandler botonNuevaPartidaHandler = new BotonNuevaPartidaHandler(this.escenario,this.creacionDePersonajes());
		botonNuevaPartida.setOnAction(botonNuevaPartidaHandler);

		Button botonSalir = new Button("Salir");
		botonSalir.setFont(Font.font("Verdana", 16));

		VBox botones = new VBox(botonNuevaPartida, botonSalir);
		botones.setAlignment(Pos.BOTTOM_CENTER);
		botones.setSpacing(15);

		VBox contenedorPrincipal = new VBox(labelTitulo, botones);
		contenedorPrincipal.setSpacing(200);
		contenedorPrincipal.setAlignment(Pos.CENTER);

		Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("texturas/fondo.png")),
				BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(800, 600, false, false, false, false)));
		contenedorPrincipal.setBackground(fondo);

		return new Scene(contenedorPrincipal, 800, 600);
	}

	private Scene creacionDePersonajes() throws FileNotFoundException{
		Label labelTitulo = new Label("Creacion de Jugadores");
		labelTitulo.setFont(Font.font("Verdana", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		Label labelJugador1 = new Label("Jugador 1");
		Label labelJugador2 = new Label("Jugador 2");

		TextField textFieldJugador1 = new TextField();
		textFieldJugador1.setPromptText("Ingresa tu nombre");
		TextField textFieldJugador2 = new TextField();
		textFieldJugador2.setPromptText("Ingresa tu nombre");

		Button  botonAceptarNombreJugador1 = new Button("aceptar");
		Button  botonAceptarNombreJugador2 = new Button("aceptar");

		HBox labelJugadores = new HBox(labelJugador1,labelJugador2);
		labelJugadores.setAlignment(Pos.CENTER);
		labelJugadores.setSpacing(500);

		HBox cuadrosDeTexto = new HBox(textFieldJugador1,textFieldJugador2);
		cuadrosDeTexto.setAlignment(Pos.CENTER);
		cuadrosDeTexto.setSpacing(310);

		HBox botonesAceptar = new HBox(botonAceptarNombreJugador1,botonAceptarNombreJugador2);
		botonesAceptar.setAlignment(Pos.CENTER);
		botonesAceptar.setSpacing(500);

		VBox contenedorPrincipal = new VBox(labelJugadores,cuadrosDeTexto,botonesAceptar);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		contenedorPrincipal.setSpacing(20);

		return new Scene(contenedorPrincipal, 800, 600);
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