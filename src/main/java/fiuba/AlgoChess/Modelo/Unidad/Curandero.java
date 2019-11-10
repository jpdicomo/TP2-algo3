package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

public class Curandero extends Unidad implements Movible{

	private int curacion;

    /*PRE:  El casillero esta libre.
     * POST: Crea un nuevo curandero, ubicado en un casillero.*/
    public Curandero(Casillero casillero){
    	
        super(casillero);
        this.vida = 75;
        this.curacion = 15;
        this.costo = 2;
    }
    /*PRE:  La unidadAliada no es una catapulta.
     * POST: Aumenta la vida de la unidadAliada tanto como le permita su poder de curación.*/
    public boolean curarA(Unidad unidad) {
        try{
            this.bando.curarA(unidad,this.curacion);
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }
    @Override
    public boolean moverseALaDerecha(Tablero tablero){
        Casillero casilleroNuevo = tablero.getDerecha(this.casillero);
        try{moverseA(casilleroNuevo);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }
    @Override
    public boolean moverseALaIzquierda(Tablero tablero){
        Casillero casilleroNuevo = tablero.getDerecha(this.casillero);
        try{moverseA(casilleroNuevo);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }
    @Override
    public boolean moverseArriba(Tablero tablero){
        Casillero casilleroNuevo = tablero.getArriba(this.casillero);
        try{moverseA(casilleroNuevo);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }
    @Override
    public boolean moverseAbajo(Tablero tablero){
        Casillero casilleroNuevo = tablero.getAbajo(this.casillero);
        try{moverseA(casilleroNuevo);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }




    @Override
    public boolean moverseA(Casillero casilleroNuevo) {
        try{
            casilleroNuevo.agregarEntidad(this);
        }catch(CasilleroOcupadoException e){
            return false;
        }
        this.casillero.quitarEntidad();
        this.casillero = casilleroNuevo;
        return true;
    }


}