package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;

import fiuba.AlgoChess.Modelo.Ataque.*;
//import fiuba.AlgoChess.Modelo.Errores.*;
//import fiuba.AlgoChess.Modelo.Movimiento.*;
//import fiuba.AlgoChess.Modelo.Tablero.*;

public class Jinete extends Unidad /*implements Atacante, Movible*/ {

	// Atributos.
	
    private TipoAtaque tipoAtaque;
    private int danioMelee = 5;
//  private Movimiento movimiento;

    
    // Metodos.
    
    /*
     * 
     */
    public Jinete(Bando bando){
    	
        super(bando);
        this.tipoAtaque = new AtaqueMelee(this.danioMelee);
        this.vida = 100;
        this.costo = 3;
//      this.movimiento = new Movimiento(this.casillero);
    }
    
    
    /*
     * 
     */
    @Override
	public void realizarAccionSobre(Unidad otraUnidad) {

    	super.realizarAccionSobre(otraUnidad);
		this.bando.interactuarConUnEnemigo(otraUnidad.getBando());
		this.tipoAtaque.atacarA(otraUnidad);
	}

    
//    @Override
//    public boolean moverseALaDerecha(Tablero tablero){
//        return this.movimiento.moverseALaDerecha(tablero, this);
//    }
//    
//    
//    @Override
//    public boolean moverseALaIzquierda(Tablero tablero){
//         return this.movimiento.moverseALaIzquierda(tablero, this);
//    }
//    
//    
//    @Override
//    public boolean moverseArriba(Tablero tablero){
//        return this.movimiento.moverseArriba(tablero, this);
//    }
//    
//    
//    @Override
//    public boolean moverseAbajo(Tablero tablero){
//       return this.movimiento.moverseAbajo(tablero,this);
//    }
//    
//
//    @Override
//    public boolean moverseA(Casillero casilleroNuevo) {
//        return this.movimiento.moverseA(casilleroNuevo, this);
//    }
}