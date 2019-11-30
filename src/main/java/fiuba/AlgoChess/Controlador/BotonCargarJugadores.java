package fiuba.AlgoChess.Controlador;

import java.io.FileNotFoundException;

import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Vista.Compra.CajaDeUnidades;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class BotonCargarJugadores implements EventHandler<ActionEvent> {
	
	private String jugador1;
    private String jugador2;
    private Main main;

    public BotonCargarJugadores(TextField jugador1, TextField jugador2, Main main){
    	
        this.jugador1 = jugador1.getText();
        this.jugador2 = jugador2.getText();
        this.main = main;
    }

    @Override
	public void handle(ActionEvent event) {
    	
    	System.out.println(jugador1 + jugador2);

        if(!(this.jugador1.isEmpty()) && !(this.jugador2.isEmpty())) {
        
        	this.main.crearJugadores(this.jugador1, this.jugador2);
        	try {
				main.cambiarEscenaA(this.main.escenaCompraDeUnidades1());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
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

