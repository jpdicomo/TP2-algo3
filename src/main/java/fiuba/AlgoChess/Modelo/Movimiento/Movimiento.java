package fiuba.AlgoChess.Modelo.Movimiento;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public class Movimiento {

    private Casillero casillero;

    public Movimiento(Casillero casillero){
        this.casillero = casillero;
    }

    public boolean moverseALaDerecha(Tablero tablero, Unidad unidad){
        Casillero casilleroNuevo = tablero.getDerecha(this.casillero);
        try{moverseA(casilleroNuevo, unidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseALaIzquierda(Tablero tablero, Unidad unidad){
        Casillero casilleroNuevo = tablero.getIzquierda(this.casillero);
        try{moverseA(casilleroNuevo, unidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseArriba(Tablero tablero, Unidad unidad){
        Casillero casilleroNuevo = tablero.getArriba(this.casillero);
        try{
        	moverseA(casilleroNuevo, unidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseAbajo(Tablero tablero, Unidad unidad){
        Casillero casilleroNuevo = tablero.getAbajo(this.casillero);
        try{
        	moverseA(casilleroNuevo, unidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseA(Casillero casilleroNuevo, Unidad unidad) {
        try{
            casilleroNuevo.agregarUnidad(unidad);
        }catch(CasilleroOcupadoException e){
            return false;
        }
        this.casillero.quitarEntidad();
        this.casillero = casilleroNuevo;
        return true;
    }

}

