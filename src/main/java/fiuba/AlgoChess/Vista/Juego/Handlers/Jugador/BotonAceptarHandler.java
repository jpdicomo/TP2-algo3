package fiuba.AlgoChess.Vista.Juego.Handlers.Jugador;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class BotonAceptarHandler implements EventHandler<ActionEvent> {
        private Jugador jugador;
        private TextField textField;
        private Label labelNombre;

    public BotonAceptarHandler(Jugador jugador, TextField textField, Label labelNombre){
        this.jugador = jugador;
        this.textField = textField;
        this.labelNombre = labelNombre;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        String nombreJugador = this.textField.getText();
        this.labelNombre.setText("Jugador: " + nombreJugador);
        this.labelNombre.setTextFill(Color.rgb(255, 255, 255));
        jugador = new Jugador(nombreJugador,new Bando());
    }
}
