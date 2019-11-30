package fiuba.AlgoChess.Vista.Juego;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Vista.Compra.CajaDeUnidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Controlador.BotonCargarJugadores;
import fiuba.AlgoChess.Controlador.BotonNuevaPartida;
import fiuba.AlgoChess.Controlador.BotonSalirDelJuego;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;

public class Main extends Application {

	private Stage escenario;
	private Bando[] bandos;
	private Jugador[] jugadores;
	private Tablero tablero;

	public static void main(String[] args) {

		launch(args);
	}

	// Listo.
	@Override
	public void start(Stage stage) throws Exception {

//		stage.setMaximized(true); <-- No creo que haga falta
		stage.setResizable(true);
		this.escenario = stage;
		this.escenario.setTitle("AlgoChess");
		this.cambiarEscenaA(this.escenaBienvenida());
		this.escenario.show();
	}
	
	
	public void cambiarEscenaA(Scene nuevaEscena) {
		
		this.escenario.setScene(nuevaEscena);
	}
	
	
	public void crearJugadores(String jugador1, String jugador2) {

		this.bandos[0] = new Bando();
		this.bandos[1] = new Bando();
		
		this.jugadores[0] = new Jugador(jugador1, bandos[0]);
		this.jugadores[1] = new Jugador(jugador2, bandos[1]);
		
		this.tablero = new Tablero(this.bandos[0], this.bandos[1]);
	}
	
	
	public Scene escenaBienvenida() throws FileNotFoundException {

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
		
		
		Background fondo = new CreadorDeFondos().crearFondo("./recursos/fondos/fondo1.png");
		contenedorPrincipal.setBackground(fondo);
		
		return new Scene(contenedorPrincipal, 800, 600);
	}

	
	public Scene escenaCargaDeJugadores() throws FileNotFoundException{
		
		// Titulo
	    Label labelTitulo = new Label("Creacion de Jugadores");
		labelTitulo.setFont(Font.font("Verdana", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		// Jugador 1
		Label labelJugador1 = new Label("Jugador 1");
		labelJugador1.setFont(Font.font("TimesNewRoman",20));
        labelJugador1.setTextFill(Color.rgb(255, 255, 255));
        TextField nombreJugador1 = new TextField();
        nombreJugador1.setPromptText("Ingresa tu nombre");
		
        
        // Jugador 2
        Label labelJugador2 = new Label("Jugador 2");
        labelJugador2.setFont(Font.font("TimesNewRoman", 20));
        labelJugador2.setTextFill(Color.rgb(255, 255, 255));
		TextField nombreJugador2 = new TextField();
		nombreJugador2.setPromptText("Ingresa tu nombre");

		Button botonJugar = new Button("Jugar");
		botonJugar.setFont(Font.font("Times New Roman", 20));
		
		BotonCargarJugadores botonCargarJugadores = new BotonCargarJugadores(nombreJugador1, nombreJugador2, this);
		botonJugar.setOnAction(botonCargarJugadores);
		
		
		//Creacion de las XBox
		HBox labelJugadores = new HBox(labelJugador1,labelJugador2);
		labelJugadores.setAlignment(Pos.CENTER);
		labelJugadores.setSpacing(500);

		HBox cuadrosDeTexto = new HBox(nombreJugador1,nombreJugador2);
		cuadrosDeTexto.setAlignment(Pos.CENTER);
		cuadrosDeTexto.setSpacing(380);

		VBox contenedorJugadores = new VBox(labelJugadores, cuadrosDeTexto);
		contenedorJugadores.setAlignment(Pos.CENTER);
		contenedorJugadores.setSpacing(20);
		
		VBox contenedorPrincipal = new VBox(contenedorJugadores, botonJugar);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		contenedorPrincipal.setSpacing(150);

		// Cargo el fondo.
		Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("./recursos/fondo2.png")),
				BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(800, 600, false, false, false, false)));
		contenedorPrincipal.setBackground(fondo);

		return new Scene(contenedorPrincipal, 800, 600);
	}
	
	
	public Scene escenaCompraDeUnidades1() throws FileNotFoundException {
		
		
		CajaDeUnidades cajaUnidades = new CajaDeUnidades(this, 1);
		Button botonTerminarCompra = new Button("Terminar Compra");
		
		VBox contenedorPrincipal = new VBox(cajaUnidades, botonTerminarCompra);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		contenedorPrincipal.setSpacing(150);
		
		// Cargo el fondo.
		Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("./recursos/fondo1.png")),
				BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(800, 600, false, false, false, false)));
		contenedorPrincipal.setBackground(fondo);

		return null;
	}
	
	
	public Jugador getJugador(int numeroJugador) {

		return this.jugadores[numeroJugador - 1];
	}

	public Bando getBando(int numeroJugador) {

		return bandos[numeroJugador - 1];
	}
}