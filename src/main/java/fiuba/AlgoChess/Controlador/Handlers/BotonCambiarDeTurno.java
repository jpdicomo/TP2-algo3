package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class BotonCambiarDeTurno implements EventHandler<ActionEvent> {

	private Main main;

	public BotonCambiarDeTurno(Main main) {

		this.main = main;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		Scene escena;
		
		if(!this.main.getJugador(1).sigueJugando()) {
			
			escena = this.main.escenaFinal(2);
			
		} else if(!this.main.getJugador(2).sigueJugando()) {
			
			escena = this.main.escenaFinal(1);
			
		} else if(this.main.getNumeroJugador() == 2) {
		
			escena = this.main.escenaDeLucha(1);
		
		} else {
			
			escena = this.main.escenaDeLucha(2);
		}

		this.main.cambiarEscenaA(escena);
	}

}
