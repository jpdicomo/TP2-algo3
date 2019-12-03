package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCambiarAEscenaColocarUnidades1 implements EventHandler<ActionEvent> {

	private Main main;

	public BotonCambiarAEscenaColocarUnidades1(Main main) {

		this.main = main;
	}
	
	@Override
	public void handle(ActionEvent event) {

		this.main.cambiarEscenaA(this.main.escenaColocarUnidades(1));
	}

}
