package fiuba.AlgoChess.Vista.Juego;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Vista.Compra.CajaDeUnidades;
import fiuba.AlgoChess.Vista.Juego.Colocacion.CajaDeUnidadesVertical;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;

import java.io.File;

import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaColocarUnidades1;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaColocarUnidades2;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaDeCompra2;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarAEscenaDeLucha;
import fiuba.AlgoChess.Controlador.Handlers.BotonCambiarDeTurno;
import fiuba.AlgoChess.Controlador.Handlers.BotonComenzarJuego;
import fiuba.AlgoChess.Controlador.Handlers.BotonNuevaPartida;
import fiuba.AlgoChess.Controlador.Handlers.BotonSalirDelJuego;
import fiuba.AlgoChess.Controlador.Handlers.BotonVolverAJugar;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;

public class Main extends Application {

	private Stage escenario;
	private Bando[] bandos = new Bando[2];
	private Jugador[] jugadores = new Jugador[2];
	private Tablero tablero;
	private int numeroJugador;
	private Media sonido;
	private MediaPlayer reproductor;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.iniciarJuego();
		this.escenario = stage;
		this.escenario.setTitle("AlgoChess");
		this.escenario.setMaximized(true);
		this.cambiarEscenaA(this.escenaBienvenida());
		this.escenario.show();
	}

	private void iniciarJuego() {

		this.bandos[0] = new Bando();
		this.bandos[1] = new Bando();
		this.jugadores[0] = new Jugador("", this.bandos[0]);
		this.jugadores[1] = new Jugador("", this.bandos[1]);
		this.tablero = new Tablero(this.bandos[0], this.bandos[1]);
	}
	
	public void reiniciarJuego() {
		
		this.iniciarJuego();
		this.cambiarEscenaA(this.escenaBienvenida());
	}

	public void cambiarEscenaA(Scene nuevaEscena) {

		double ancho = this.escenario.getWidth();
		double alto = this.escenario.getHeight();
		boolean modoDePantalla = this.escenario.isMaximized();

		this.escenario.setScene(nuevaEscena);
		this.escenario.setWidth(ancho);
		this.escenario.setHeight(alto);
		this.escenario.setMaximized(modoDePantalla);
	}

	// Escenas.

	public Scene escenaBienvenida() {

		// Titulo.
		Label labelTitulo = new Label("");
		labelTitulo.setFont(Font.font("Verdana", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		// Botones.
		Button botonNuevaPartida = new Button("Nueva Partida");
		botonNuevaPartida.setFont(Font.font("Verdana", 20));
		botonNuevaPartida.setOnAction(new BotonNuevaPartida(this));

		Button botonSalir = new Button("Salir");
		botonSalir.setFont(Font.font("Verdana", 20));
		botonSalir.setOnAction(new BotonSalirDelJuego());

		// XBox
		VBox botones = new VBox(botonNuevaPartida, botonSalir);
		botones.setAlignment(Pos.BOTTOM_CENTER);
		botones.setSpacing(20);

		VBox contenedorPrincipal = new VBox(labelTitulo, botones);
		contenedorPrincipal.setSpacing(270);
		contenedorPrincipal.setAlignment(Pos.CENTER);

		// Fondo y musica.
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo1.png", 1920, 1080));
		this.cambiarMusica("./recursos/sonidos/escenas/intro.wav");

		return new Scene(contenedorPrincipal, 1920, 1080);
	}

	public Scene escenaCargaDeJugadores() {

		// Titulo
		Label labelTitulo = new Label("Ingresen sus nombres");
		labelTitulo.setFont(Font.font("Times New Roman", 72));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		// Jugador 1
		Label labelJugador1 = new Label("Jugador 1");
		labelJugador1.setFont(Font.font("Times New Roman", 30));
		labelJugador1.setTextFill(Color.rgb(255, 255, 255));
		TextField nombreJugador1 = new TextField();
		nombreJugador1.setPromptText("Ingresa tu nombre");
		nombreJugador1.setFont(Font.font("Times New Roman", 20));

		// Jugador 2
		Label labelJugador2 = new Label("Jugador 2");
		labelJugador2.setFont(Font.font("Times New Roman", 30));
		labelJugador2.setTextFill(Color.rgb(255, 255, 255));
		TextField nombreJugador2 = new TextField();
		nombreJugador2.setPromptText("Ingresa tu nombre");
		nombreJugador2.setFont(Font.font("Times New Roman", 20));

		Button botonComenzar = new Button("Comenzar Juego");
		botonComenzar.setFont(Font.font("Verdana", 20));
		botonComenzar.setOnAction(new BotonComenzarJuego(nombreJugador1, nombreJugador2, this));

		// Creacion de las XBox
		HBox labelJugadores = new HBox(labelJugador1, labelJugador2);
		labelJugadores.setAlignment(Pos.CENTER);
		labelJugadores.setSpacing(450);

		HBox cuadrosDeTexto = new HBox(nombreJugador1, nombreJugador2);
		cuadrosDeTexto.setAlignment(Pos.CENTER);
		cuadrosDeTexto.setSpacing(200);

		VBox contenedorJugadores = new VBox(labelJugadores, cuadrosDeTexto);
		contenedorJugadores.setAlignment(Pos.CENTER);
		contenedorJugadores.setSpacing(20);

		VBox contenedorConBoton = new VBox(contenedorJugadores, botonComenzar);
		contenedorConBoton.setAlignment(Pos.CENTER);
		contenedorConBoton.setSpacing(150);

		VBox contenedorPrincipal = new VBox(labelTitulo, contenedorConBoton);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		contenedorPrincipal.setSpacing(450);

		// Fondo y musica
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo2.png", 1920, 1080));
		this.cambiarMusica("./recursos/sonidos/escenas/cargaJugadores.wav");

		return new Scene(contenedorPrincipal, 1920, 1080);
	}

	public Scene escenaCompraDeUnidades(int numeroJugador) {

		Jugador jugador = this.getJugador(numeroJugador);

		// Titulo
		Label labelTitulo = new Label(jugador.getNombre() + " - Elegi tus unidades");
		labelTitulo.setFont(Font.font("Times New Roman", 48));

		// Puntos restantes
		Label puntosJugador = new Label("Puntos restantes: " + jugador.getPuntos());
		puntosJugador.setFont(Font.font("Times New Roman", 30));

		// Caja de unidades
		CajaDeUnidades cajaUnidades = new CajaDeUnidades(this, numeroJugador, puntosJugador);
		Button botonTerminarCompra = new Button("Terminar Compra");
		botonTerminarCompra.setFont(Font.font("Verdana", 20));

		if (numeroJugador != 2) {
			botonTerminarCompra.setOnAction(new BotonCambiarAEscenaDeCompra2(this));
		} else {
			botonTerminarCompra.setOnAction(new BotonCambiarAEscenaColocarUnidades1(this));
		}

		// Creo las cajas.
		VBox contenedorSecundario = new VBox(labelTitulo, cajaUnidades, puntosJugador, botonTerminarCompra);
		contenedorSecundario.setMaxWidth(1150);
		contenedorSecundario.setMinHeight(800);
		contenedorSecundario.setAlignment(Pos.CENTER);
		contenedorSecundario.setSpacing(50);
		contenedorSecundario.setBackground(new CreadorDeFondos().crearFondo("./recursos/compra/fondo.png", 1920, 1080));

		VBox contenedorPrincipal = new VBox(contenedorSecundario);
		contenedorPrincipal.setAlignment(Pos.CENTER);

		// Fondo y musica.
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo3.png", 1920, 1080));
		this.cambiarMusica("./recursos/sonidos/escenas/mercado.wav");

		return new Scene(contenedorPrincipal, 1920, 1080);
	}

	public Scene escenaColocarUnidades(int numeroJugador) {

		// Titulo
		Label titulo = new Label("Coloca tus unidades");
		titulo.setFont(Font.font("Times New Roman", 28));

		// Caja de unidades
		VistaUnidadSeleccionada unidadSeleccionada = new VistaUnidadSeleccionada();
		CajaDeUnidadesVertical cajaUnidades = new CajaDeUnidadesVertical(this, numeroJugador, unidadSeleccionada);

		// Tablero
		VistaTablero tablero = new VistaTablero(this, this.tablero);
		tablero.compartamientoColocarUnidades(unidadSeleccionada);

		// Boton para terminar de colocar unidades.
		Button botonTerminarColocacion = new Button("Termine");
		botonTerminarColocacion.setFont(Font.font("Verdana", 20));

		if (numeroJugador != 2) {
			botonTerminarColocacion.setOnAction(new BotonCambiarAEscenaColocarUnidades2(this, cajaUnidades, unidadSeleccionada));
		} else {
			botonTerminarColocacion.setOnAction(new BotonCambiarAEscenaDeLucha(this, cajaUnidades, unidadSeleccionada));
		}

		// Creo las cajas.
		VBox cajaDeUnidades = new VBox(titulo, cajaUnidades, unidadSeleccionada, botonTerminarColocacion);
		cajaDeUnidades.setMinSize(370, 957);
		cajaDeUnidades.setMaxSize(370, 957);
		cajaDeUnidades.setBackground(new CreadorDeFondos().crearFondo("./recursos/compra/fondo.png", 1920, 1080));
		cajaDeUnidades.setSpacing(60);
		cajaDeUnidades.setAlignment(Pos.CENTER);

		HBox contenedorSecundario = new HBox(cajaDeUnidades, tablero);
		contenedorSecundario.setAlignment(Pos.CENTER);
		contenedorSecundario.setSpacing(150);

		VBox contenedorPrincipal = new VBox(contenedorSecundario);
		contenedorPrincipal.setAlignment(Pos.CENTER);

		// Fondo y musica.
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo4.png", 1920, 1080));
		this.cambiarMusica("./recursos/sonidos/escenas/cargaUnidades.wav");

		return new Scene(contenedorPrincipal, 1920, 1080);
	}

	public Scene escenaDeLucha(int numeroJugador) {

		Jugador jugador = this.getJugador(numeroJugador);
		this.numeroJugador = numeroJugador;

		// Titulo
		Label labelTitulo = new Label(jugador.getNombre());
		Label labelSubtitulo = new Label("Es tu turno");
		labelTitulo.setFont(Font.font("Times New Roman", 40));
		labelSubtitulo.setFont(Font.font("Times New Roman", 34));

		// Datos unidad seleccionada.
		VistaDatosUnidad unidadElegida = new VistaDatosUnidad();

		// Tablero
		VistaTablero tablero = new VistaTablero(this, this.tablero);
		tablero.comportamientoSeleccionarUnidad(unidadElegida);

		// Boton para terminar turno.
		Button botonTerminarTurno = new Button("Terminar Turno");
		botonTerminarTurno.setOnAction(new BotonCambiarDeTurno(this));
		botonTerminarTurno.setFont(Font.font("Verdana", 20));

		// Creo las XBox
		VBox titulares = new VBox(labelTitulo, labelSubtitulo);
		titulares.setSpacing(10);
		titulares.setAlignment(Pos.CENTER);

		VBox datosUnidad = new VBox(titulares, unidadElegida, botonTerminarTurno);
		datosUnidad.setMinSize(370, 957);
		datosUnidad.setMaxSize(370, 957);
		datosUnidad.setSpacing(70);
		datosUnidad.setAlignment(Pos.CENTER);
		datosUnidad.setBackground(new CreadorDeFondos().crearFondo("./recursos/compra/fondo.png", 1920, 1080));

		HBox contenedorSecundario = new HBox(datosUnidad, tablero);
		contenedorSecundario.setAlignment(Pos.CENTER);
		contenedorSecundario.setSpacing(150);

		VBox contenedorPrincipal = new VBox(contenedorSecundario);
		contenedorPrincipal.setAlignment(Pos.CENTER);

		// Fondo y musica.
		contenedorPrincipal.setBackground(new CreadorDeFondos().crearFondo("./recursos/fondos/fondo4.png", 1920, 1080));
		this.cambiarMusica("./recursos/sonidos/escenas/lucha.wav");

		return new Scene(contenedorPrincipal, 1920, 1080);
	}

	public Scene escenaFinal(int numeroJugador) {

		Button botonNuevaPartida = new Button("Volver a Jugar");
		botonNuevaPartida.setFont(Font.font("Verdana", 20));
		botonNuevaPartida.setOnAction(new BotonVolverAJugar(this));

		Button botonSalir = new Button("Salir");
		botonSalir.setFont(Font.font("Verdana", 20));
		botonSalir.setOnAction(new BotonSalirDelJuego());

		VBox contenedorPrincipal = new VBox(botonNuevaPartida, botonSalir);
		contenedorPrincipal.setSpacing(20);
		contenedorPrincipal.setAlignment(Pos.CENTER);

		// Fondo y musica.
		contenedorPrincipal.setBackground(
				new CreadorDeFondos().crearFondo("./recursos/fondos/final" + numeroJugador + ".png", 1920, 1080));
		this.cambiarMusica("./recursos/sonidos/escenas/finDelJuego.wav");

		return new Scene(contenedorPrincipal, 1920, 1080);
	}

	private void cambiarMusica(String ruta) {

		if (this.reproductor != null) {
			this.reproductor.stop();
		}

		this.sonido = new Media(new File(ruta).toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.setOnEndOfMedia(new Runnable() {
			public void run() {
				reproductor.seek(Duration.ZERO);
			}
		});
		this.reproductor.play();
	}

	public Jugador getJugador(int numeroJugador) {

		return this.jugadores[numeroJugador - 1];
	}

	public Bando getBando(int numeroJugador) {

		return bandos[numeroJugador - 1];
	}

	public int getNumeroJugador() {

		return this.numeroJugador;
	}

	public void asignarNombreJugadores(String jugador1, String jugador2) {

		this.jugadores[0].setNombre(jugador1);
		this.jugadores[1].setNombre(jugador2);
	}
}