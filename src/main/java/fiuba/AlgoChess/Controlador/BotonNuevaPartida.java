package fiuba.AlgoChess.Controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class BotonNuevaPartida implements EventHandler<ActionEvent> {
	
	Main main;
	
	public BotonNuevaPartida(Main main) {
		
		this.main = main;
	}

	@Override
	public void handle(ActionEvent event) {
		
		try {
			
			this.main.cambiarEscenaA(this.EscenaNuevaPartida());
			
		} catch (FileNotFoundException e) {
		}
	}

	private Scene EscenaNuevaPartida() throws FileNotFoundException {
		
		VBox cajaJugadores = new VBox();
		
		for (int i = 0; i < 2; i++) {
			
			Label labelJugador = new Label("Jugador " + (i + 1));
			labelJugador.setFont(Font.font("Verdana", 16));
			labelJugador.setTextFill(Color.rgb(255, 255, 255));
			
			TextField cuadroDeTexto = new TextField();
			cuadroDeTexto.setPromptText("Ingrese su nombre");
			cuadroDeTexto.setFont(Font.font("Verdana", 16));
			
			HBox boxJugador = new HBox(labelJugador, cuadroDeTexto);
			boxJugador.setAlignment(Pos.CENTER);
			boxJugador.setSpacing(15);
			
			cajaJugadores.getChildren().add(boxJugador);
		}
		
		cajaJugadores.setAlignment(Pos.CENTER);
		cajaJugadores.setSpacing(15);
		
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setFont(Font.font("Verdana", 16));
        botonJugar.setOnAction(new BotonSalirDelJuego());

        VBox contenedorPrincipal = new VBox(cajaJugadores, botonJugar);
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
