package fiuba.AlgoChess.Controlador.Handlers;

import java.io.FileNotFoundException;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonNuevaPartida implements EventHandler<ActionEvent> {
	
	Main main;
	
	public BotonNuevaPartida(Main main) {
		
		this.main = main;
	}

	@Override
	public void handle(ActionEvent event) {
		
		try {
			this.main.cambiarEscenaA(main.escenaCargaDeJugadores());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

//	private Scene EscenaNuevaPartida() throws FileNotFoundException {
//		
//		HBox cajaJugador1 = this.crearCajaJugador(this.nombreJugador1, 1);
//		HBox cajaJugador2 = this.crearCajaJugador(this.nombreJugador2, 2);
//		
//		VBox cajaJugadores = new VBox(cajaJugador1, cajaJugador2);
//		cajaJugadores.setAlignment(Pos.CENTER);
//		cajaJugadores.setSpacing(15);
//		
//        Button botonJugar = new Button("Jugar");
//        botonJugar.setFont(Font.font("Verdana", 16));
//        botonJugar.setOnAction(new BotonCargarJugadores(this.nombreJugador1, this.nombreJugador2, main));
//
//        VBox contenedorPrincipal = new VBox(cajaJugadores, botonJugar);
//        contenedorPrincipal.setSpacing(200);
//		contenedorPrincipal.setAlignment(Pos.CENTER);
//		
//		Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("./recursos/fondo.png")),
//                BackgroundRepeat.REPEAT,
//                BackgroundRepeat.REPEAT,
//                BackgroundPosition.CENTER,
//                new BackgroundSize(800, 600, false, false, false, false)));
//		contenedorPrincipal.setBackground(fondo);
//		
//		return new Scene(contenedorPrincipal, 800, 600);
//	}
//
//	private HBox crearCajaJugador(TextField nombreJugador, int numeroJugador) {
//		
//		Label labelJugador = new Label("Jugador " + numeroJugador);
//		labelJugador.setFont(Font.font("Verdana", 16));
//		labelJugador.setTextFill(Color.rgb(255, 255, 255));
//		
//		TextField cuadroDeTexto = new TextField();
//		cuadroDeTexto.setPromptText("Ingrese su nombre");
//		cuadroDeTexto.setFont(Font.font("Verdana", 16));
//		
//		HBox boxJugador = new HBox(labelJugador, cuadroDeTexto);
//		boxJugador.setAlignment(Pos.CENTER);
//		boxJugador.setSpacing(15);
//		
//		nombreJugador = cuadroDeTexto;
//		
//		return boxJugador;
//	}

}
