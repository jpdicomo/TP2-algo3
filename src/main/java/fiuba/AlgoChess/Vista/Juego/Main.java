package fiuba.AlgoChess.Vista.Juego;

import fiuba.AlgoChess.Vista.Juego.Handlers.CambioEscena.*;
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

		Button  botonAceptarNombreJugador1 = new Button("aceptar");
		Button  botonAceptarNombreJugador2 = new Button("aceptar");

		Button botonContinuar = new Button("Continuar");
		BotonContinuarHandler botonContinuarHandler = new BotonContinuarHandler(this.escenario,this.pantallaTablero());
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

		VBox contenedorPrincipal = new VBox(labelJugadores,cuadrosDeTexto,botonesAceptar,botonescCambioEscena);
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