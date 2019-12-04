package fiuba.AlgoChess.Vista.Tablero;

import fiuba.AlgoChess.Controlador.Handlers.ClickParaColocarUnidad;
import fiuba.AlgoChess.Controlador.Handlers.ClickParaSeleccionarUnidad;
import fiuba.AlgoChess.Controlador.Handlers.ClickParaSeleccionarUnidadAAtacar;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Vista.Juego.Main;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class VistaTablero extends GridPane{
	
    private Tablero tablero;
    private Main main;
    private VistaDatosUnidad unidadElegida;
    private String estado;
    
    
    public VistaTablero(Main main, Tablero tablero) {

    	this.tablero = tablero;
        this.main = main;
        
        this.setHeight(600);
        this.setWidth(600);
        this.setVgap(3);
        this.setHgap(3);
        
        this.actualizarTablero();
	}


	public void actualizarTablero() {

		this.getChildren().clear();
		this.tablero.quitarUnidadesMuertas();
		int numeroJugador;
		
		for (int columna = 0; columna < 20; columna++) {
			
			for (int fila = 0; fila < 20; fila++) {

				numeroJugador = 1;
				if(fila > 9) {
					
					numeroJugador = 2;
				}
				
				Casillero casillero = this.tablero.getCasillero(new Posicion(fila, columna));
				VistaCasillero vistaCasillero = new VistaCasillero(casillero, numeroJugador, fila, columna);
				this.add(vistaCasillero, fila, columna);
			}
		}
	}
	
	
	public void compartamientoColocarUnidades(VistaUnidadSeleccionada unidad){
		
        for(Node nodoCasillero : this.getChildren()){
        	
            VistaCasillero vistaCasillero = (VistaCasillero) nodoCasillero;
            vistaCasillero.setOnAction(new ClickParaColocarUnidad(unidad, this.tablero, vistaCasillero, this));
        }
    }	
	
	
	public void comportamientoSeleccionarUnidad() {
		this.comportamientoSeleccionarUnidad(this.unidadElegida);
	}
	
	
	public void comportamientoSeleccionarUnidad(VistaDatosUnidad unidadElegida) {
		
		this.estado = "seleccion";
		this.unidadElegida = unidadElegida;
		
		for(Node nodoCasillero : this.getChildren()){
        	
            VistaCasillero vistaCasillero = (VistaCasillero) nodoCasillero;
            vistaCasillero.setOnAction(new ClickParaSeleccionarUnidad(this.unidadElegida, vistaCasillero, this, this.main));
        }
	}


	public void comportamientoDeAtaque(Posicion posicion) {
		
		this.estado = "ataque";
		
		for(Node nodoCasillero : this.getChildren()){
        	
            VistaCasillero vistaCasillero = (VistaCasillero) nodoCasillero;
            vistaCasillero.setOnAction(new ClickParaSeleccionarUnidadAAtacar(this.unidadElegida, posicion, this, vistaCasillero));
        }
	}


	public Tablero getTablero() {
		
		return this.tablero;
	}
	
	public String estadoActual() {
		
		return this.estado;
	}
}
