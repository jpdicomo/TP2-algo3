package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;

//import fiuba.AlgoChess.Modelo.Tablero.Tablero;
//import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
//import fiuba.AlgoChess.Modelo.Movimiento.*;

public class Curandero extends Unidad /*implements Movible*/{

	// Atributos.
	private int curacion;

	// Metodos.
    /* 
     * PRE:  El casillero esta libre.
     * POST: Crea un nuevo curandero, ubicado en un casillero.
     */
    public Curandero(Bando bando){
    	
        super(bando);
        this.vida = 75;
        this.curacion = 15;
        this.costo = 2;
    }
    
    
    /* 
     * PRE:  La unidad no es una catapulta.
     * POST: Aumenta la vida de la unidad tanto como le permita su poder de curaciÃ³n.
     */
    public void curarA(Unidad unidad) {

    	unidad.serCurado(this.curacion);
    }
    
    
    /*
     * PRE:  La otra unidad sobre la que el curandero realizara una accion (lo curara)
     * 		 es un aliado.
     * POST: La unidad aliada es curada.
     */
    @Override
	public void realizarAccionSobre(Unidad otraUnidad) {

    	super.realizarAccionSobre(otraUnidad);
		this.bando.interactuarConUnAliado(otraUnidad.getBando());
		this.curarA(otraUnidad);
	}
}
