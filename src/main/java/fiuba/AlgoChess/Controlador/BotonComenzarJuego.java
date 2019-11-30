package fiuba.AlgoChess.Controlador;

import java.io.FileNotFoundException;

import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class BotonComenzarJuego implements EventHandler<ActionEvent> {
	
	private TextField jugador1;
    private TextField jugador2;
    private Main main;

    public BotonComenzarJuego(TextField jugador1, TextField jugador2, Main main){
    	
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.main = main;
    }

    @Override
	public void handle(ActionEvent event) {
    	
		if (!(this.jugador1.getText().isEmpty()) && !(this.jugador2.getText().isEmpty())) {

			this.main.asignarNombreJugadores(this.jugador1.getText(), this.jugador2.getText());

			try {
				this.main.cambiarEscenaA(this.main.escenaCompraDeUnidades(1));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
    
//    
//    private Scene escenaCompraUnidades(int numeroJugador) {
//    		
//    		Jugador jugador = this.main.getJugador(numeroJugador);
//    		
//    		Label titulo = new Label(jugador.getNombre() + " - Elegi tus unidades");
//    		titulo.setFont(Font.font("Verdana", 30));
//    		
//    		CajaDeUnidades unidades = new CajaDeUnidades(this.main, numeroJugador);
//            
//    		Button botonTerminarCompra = new Button("Terminar Compra");
//            botonTerminarCompra.setFont(Font.font("Verdana", 16));
//            
//            VBox cajaPrincipal = new VBox(titulo, unidades, botonTerminarCompra);
//            cajaPrincipal.setAlignment(Pos.CENTER);
//
//            return new Scene(cajaPrincipal, 800, 600);	
//    	}
    }

