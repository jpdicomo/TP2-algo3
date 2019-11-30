package fiuba.AlgoChess.Controlador.Handlers;

import java.io.FileNotFoundException;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonCambiarAEscenaDeCompra2 implements EventHandler<ActionEvent> {

	private Main main;
	
	public BotonCambiarAEscenaDeCompra2(Main main) {
		
		this.main = main;
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {

		try {
			this.main.cambiarEscenaA(this.main.escenaCompraDeUnidades(2));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
