package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaNombreNoCargado;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonComenzarJuego implements EventHandler<ActionEvent> {

	private TextField jugador1;
	private TextField jugador2;
	private Main main;

	public BotonComenzarJuego(TextField jugador1, TextField jugador2, Main main) {

		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.main = main;
	}

	@Override
	public void handle(ActionEvent event) {

		if ((this.jugador1.getText().isEmpty()) || (this.jugador2.getText().isEmpty())) {

			AlertaNombreNoCargado alertaNombreFaltante = new AlertaNombreNoCargado();
			alertaNombreFaltante.mostrarAlerta();

		} else {

			this.main.asignarNombreJugadores(this.jugador1.getText(), this.jugador2.getText());
			this.main.cambiarEscenaA(this.main.escenaCompraDeUnidades(1));
		}
	}
}
