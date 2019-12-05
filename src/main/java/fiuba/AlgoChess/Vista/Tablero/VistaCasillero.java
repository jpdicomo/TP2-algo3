package fiuba.AlgoChess.Vista.Tablero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Juego.CreadorDeFondos;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCasillero extends ToggleButton {

	private Posicion posicion;
	private Casillero casillero;
	
	
	public VistaCasillero(Casillero casillero, int numeroJugador, int fila, int columna) {

		super();
		
		this.casillero = casillero;
		this.posicion = new Posicion(fila, columna);

		try {
			
			this.colocarUnidad(casillero, numeroJugador);
			
		} catch (CasilleroLibreException e) {
			
			String direccion = "./recursos/tablero/";
			
			if(numeroJugador == 1) {
				
				direccion += "rojo";
			} else {
				direccion += "verde";
			}
			
			if((fila + columna)% 2 == 0) {
				direccion += "1.png";
			}else {
				direccion += "2.png";
			}
			
			this.setBackground(new CreadorDeFondos().crearFondo(direccion, 40, 40));
		}
		this.setPrefSize(45, 45);
		this.setMaxSize(45, 45);
	}
	
	
	private void colocarUnidad(Casillero casillero, int numeroJugador) {
		
		Unidad unidad = casillero.getUnidad();
		
		try {
			
			unidad.interactuarConUnAliado(casillero.getBando());
			
		} catch (DistintoBandoException e) {
			
			numeroJugador = 3 - numeroJugador;
		}
		
		String direccion = "./recursos/unidades/" + unidad.getClass().getSimpleName() + numeroJugador + ".png";
		
		Image imagenUnidad = null;
		
		try {
			
			imagenUnidad = new Image(new FileInputStream(direccion));
		
		} catch(FileNotFoundException e) {
		}
		
		ImageView imagen = new ImageView();
        imagen.setFitHeight(29);
        imagen.setFitWidth(29);
        imagen.setPreserveRatio(true);
        imagen.setImage(imagenUnidad);
        
        this.setGraphic(imagen);
	}

	public Posicion getPosicion() {

		return this.posicion;
	}
	
	public Casillero getCasillero() {
		
		return this.casillero;
	}
}
