package fiuba.AlgoChess.Vista.Juego;

import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Vista.Juego.Handlers.CambioEscena.*;
import fiuba.AlgoChess.Vista.Juego.Handlers.Jugador.BotonAceptarHandler;
import javafx.application.Application;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

	private Stage escenario;
	private Scene sceneMenu, scene2;
	private Jugador jugador1, jugador2;


	public Main() throws FileNotFoundException {
	}

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.escenario = stage;
		this.escenario.setTitle("AlgoChess");

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
		//Creacion de los elementos de la escena
	    Label labelTitulo = new Label("Creacion de Jugadores");
		labelTitulo.setFont(Font.font("Verdana", 48));
		labelTitulo.setTextFill(Color.rgb(255, 255, 255));

		Label labelJugador1 = new Label("Jugador 1");
		labelJugador1.setFont(Font.font("TimesNewRoman",20));
        labelJugador1.setTextFill(Color.rgb(255, 255, 255));
		Label labelJugador2 = new Label("Jugador 2");
        labelJugador2.setFont(Font.font("TimesNewRoman",20));
        labelJugador2.setTextFill(Color.rgb(255, 255, 255));

		TextField textFieldJugador1 = new TextField();
		textFieldJugador1.setPromptText("Ingresa tu nombre");
		TextField textFieldJugador2 = new TextField();
		textFieldJugador2.setPromptText("Ingresa tu nombre");

		Button botonAceptarNombreJugador1 = new Button("aceptar");
		Label labelNombreJugador1 = new Label();
		BotonAceptarHandler botonAceptarJugador1Handler = new BotonAceptarHandler(jugador1,textFieldJugador1,labelNombreJugador1);
		botonAceptarNombreJugador1.setOnAction(botonAceptarJugador1Handler);

		Button  botonAceptarNombreJugador2 = new Button("aceptar");
		Label labelNombreJugador2 = new Label();
		BotonAceptarHandler botonAceptarJugador2Handler = new BotonAceptarHandler(jugador2,textFieldJugador2,labelNombreJugador2);
		botonAceptarNombreJugador2.setOnAction(botonAceptarJugador2Handler);

		Button botonContinuar = new Button("Continuar");
		BotonContinuarHandler botonContinuarHandler = new BotonContinuarHandler(this.escenario,this.selectorDeUnidades());
        botonContinuar.setOnAction(botonContinuarHandler);
		Button botonVolver = new Button("Volver");

		//No puedo hace que funcione el handler de botonVolver asi que lo hago aca directamente
		botonVolver.setOnAction(e -> {
            try {
                escenario.setScene(this.pantallaInicial());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

		//Creacion de las HBox
		HBox labelJugadores = new HBox(labelJugador1,labelJugador2);
		labelJugadores.setAlignment(Pos.CENTER);
		labelJugadores.setSpacing(500);

		HBox cuadrosDeTexto = new HBox(textFieldJugador1,textFieldJugador2);
		cuadrosDeTexto.setAlignment(Pos.CENTER);
		cuadrosDeTexto.setSpacing(310);

		HBox botonesAceptar = new HBox(botonAceptarNombreJugador1,botonAceptarNombreJugador2);
		botonesAceptar.setAlignment(Pos.CENTER);
		botonesAceptar.setSpacing(500);

		HBox botonescCambioEscena = new HBox(botonVolver,botonContinuar);
        botonescCambioEscena.setAlignment(Pos.CENTER);
        botonescCambioEscena.setSpacing(20);

        HBox labelsNombresJugadores = new HBox(labelNombreJugador1,labelNombreJugador2);
		labelsNombresJugadores.setAlignment(Pos.CENTER);
		labelsNombresJugadores.setSpacing(500);

		VBox contenedorPrincipal = new VBox(labelJugadores,cuadrosDeTexto,botonesAceptar,botonescCambioEscena,labelsNombresJugadores);
		contenedorPrincipal.setAlignment(Pos.CENTER);
		contenedorPrincipal.setSpacing(20);

		Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("texturas/pantallaCrearJugador.png")),
				BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(800, 600, false, false, false, false)));
		contenedorPrincipal.setBackground(fondo);

		return new Scene(contenedorPrincipal, 800, 600);
	}

	private Scene selectorDeUnidades() throws FileNotFoundException{
		Label labelTitulo = new Label("Personaliza tu ejercito");

		ImageView soldadoImgV = new ImageView();
		Image soldadoAliado = new Image(new FileInputStream("texturas/soldado2.png"),50,50,false,false);
		soldadoImgV.setImage(soldadoAliado);

		ImageView curanderoImgV = new ImageView();
		Image curanderoAliado = new Image(new FileInputStream("texturas/curandero2.png"),50,50,false,false);
		curanderoImgV.setImage(curanderoAliado);

		ImageView catapultaImgV = new ImageView();
		Image catapultaAliada = new Image(new FileInputStream("texturas/catapulta2.png"),50,50,false,false);
		catapultaImgV.setImage(catapultaAliada);

		ImageView jineteImgV = new ImageView();
		Image jineteAliado = new Image(new FileInputStream("texturas/jinete2.png"),50,50,false,false);
		jineteImgV.setImage(jineteAliado);

		Image agregarUnidadImg = new Image(new FileInputStream("texturas/agregarUnidad.png"),20,20,false,false);
		Image removerUnidadImg = new Image(new FileInputStream("texturas/removerUnidad.png"),20,20,false,false);

		Button agregarUnidadSoldado = new Button();
		agregarUnidadSoldado.setGraphic(new ImageView(agregarUnidadImg));
		Button removerUnidadSoldado = new Button();
		removerUnidadSoldado.setGraphic(new ImageView(removerUnidadImg));

		Button agregarUnidadCurandero = new Button();
		agregarUnidadCurandero.setGraphic(new ImageView(agregarUnidadImg));
		Button removerUnidadCurandero = new Button();
		removerUnidadCurandero.setGraphic(new ImageView(removerUnidadImg));

		Button agregarUnidadCatapulta = new Button();
		agregarUnidadCatapulta.setGraphic(new ImageView(agregarUnidadImg));
		Button removerUnidadCatapulta = new Button();
		removerUnidadCatapulta.setGraphic(new ImageView(removerUnidadImg));

		Button agregarUnidadJinete = new Button();
		agregarUnidadJinete.setGraphic(new ImageView(agregarUnidadImg));
		Button removerUnidadJinete = new Button();
		removerUnidadJinete.setGraphic(new ImageView(removerUnidadImg));

		HBox unidadesAliadas = new HBox(soldadoImgV,curanderoImgV,catapultaImgV,jineteImgV);
		unidadesAliadas.setSpacing(40);

		HBox botonesAgregarRemover = new HBox(agregarUnidadSoldado,removerUnidadSoldado,agregarUnidadCurandero,removerUnidadCurandero,agregarUnidadCatapulta,removerUnidadCatapulta,agregarUnidadJinete,removerUnidadJinete);
		botonesAgregarRemover.setSpacing(5);

		Button continuar = new Button("continuar");
		BotonContinuarHandler continuarHandler = new BotonContinuarHandler(this.escenario,pantallaTablero());
		continuar.setOnAction(continuarHandler);
		VBox layout = new VBox(labelTitulo,unidadesAliadas,botonesAgregarRemover,continuar);
		layout.setSpacing(20);
		return new Scene(layout,800,600);
	}
    private Scene pantallaTablero() throws FileNotFoundException{
	    ImageView imageView = new ImageView();
        Image imagenTablero = new Image(new FileInputStream("texturas/tableroSprite.png"));
	    imageView.setImage(imagenTablero);
	    Pane layout = new Pane(imageView);
		Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("texturas/fondoPantallaTablero.png")),
				BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(800, 600, false, false, false, false)));
		layout.setBackground(fondo);
	    return new Scene(layout,800,600);
    }
}