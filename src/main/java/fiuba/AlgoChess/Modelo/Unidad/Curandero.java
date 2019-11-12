package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Movimiento.*;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

public class Curandero extends Entidad implements Movible {

	private int curacion;
	private Movimiento movimiento;

    /*PRE:  El casillero esta libre.
     * POST: Crea un nuevo curandero, ubicado en un casillero.*/
    public Curandero(Casillero casillero){
    	
        super(casillero);
        this.vida = 75;
        this.curacion = 15;
        this.costo = 2;
        this.movimiento = new Movimiento(this.casillero);
    }
    /*PRE:  La unidadAliada no es una catapulta.
     * POST: Aumenta la vida de la unidadAliada tanto como le permita su poder de curación.*/
    public boolean curarA(Entidad entidad) {
        try{
            this.bando.curarA(entidad,this.curacion);
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }
    @Override
    public boolean moverseALaDerecha(Tablero tablero){
        return this.movimiento.moverseALaDerecha(tablero, this);
    }
    @Override
    public boolean moverseALaIzquierda(Tablero tablero){
        return this.movimiento.moverseALaIzquierda(tablero, this);
    }
    @Override
    public boolean moverseArriba(Tablero tablero){
        return this.movimiento.moverseArriba(tablero, this);
    }
    @Override
    public boolean moverseAbajo(Tablero tablero){
        return this.movimiento.moverseAbajo(tablero, this);
    }


    @Override
    public boolean moverseA(Casillero casilleroNuevo) {
        return this.movimiento.moverseA(casilleroNuevo,this);
    }


}