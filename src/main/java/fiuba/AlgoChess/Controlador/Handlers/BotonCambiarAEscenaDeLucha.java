package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCambiarAEscenaDeLucha implements EventHandler<ActionEvent> {

	private Main main;
	private int jugadorInicial;

	public BotonCambiarAEscenaDeLucha(Main main) {

		this.main = main;
		this.jugadorInicial = (int) (Math.random() * 2 + 1);
	}
	
	@Override
	public void handle(ActionEvent event) {

		this.main.cambiarEscenaA(this.main.escenaDeLucha(this.jugadorInicial));
	}

}
