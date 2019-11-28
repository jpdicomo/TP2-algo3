package fiuba.AlgoChess.Vista.Juego;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Controlador.BotonNuevaPartida;
import fiuba.AlgoChess.Controlador.BotonSalirDelJuego;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;

public class Main extends Application {

	private Stage escenario;
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.escenario = stage;
		this.escenario.setTitle("AlgoChess");
		this.cambiarEscenaA(this.pantallaInicial());
		this.escenario.show();
	}

	
	public void cambiarEscenaA(Scene nuevaEscena) {
		
		this.escenario.setScene(nuevaEscena);
	}
	
	
	private Scene pantallaInicial() throws FileNotFoundException {

		Label labelTitulo = new Label("AlgoChess");
		labelTitulo.setFont(Font.font("Verdana", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		Button botonNuevaPartida = new Button("Nueva Partida");
		botonNuevaPartida.setFont(Font.font("Verdana", 16));
		botonNuevaPartida.setOnAction(new BotonNuevaPartida(this));

		Button botonSalir = new Button("Salir");
		botonSalir.setFont(Font.font("Verdana", 16));
		botonSalir.setOnAction(new BotonSalirDelJuego());
		
		VBox botones = new VBox(botonNuevaPartida, botonSalir);
		botones.setAlignment(Pos.BOTTOM_CENTER);
		botones.setSpacing(15);

		VBox contenedorPrincipal = new VBox(labelTitulo, botones);
		contenedorPrincipal.setSpacing(200);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		
		Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("./recursos/fondo.png")),
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(800, 600, false, false, false, false)));
		contenedorPrincipal.setBackground(fondo);
		
		return new Scene(contenedorPrincipal, 800, 600);
	}

}