package fiuba.AlgoChess.Controlador.Handlers;

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
		
		this.main.cambiarEscenaA(main.escenaCargaDeJugadores());
	}
}
