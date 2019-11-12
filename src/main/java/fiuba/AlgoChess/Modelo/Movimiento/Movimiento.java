package fiuba.AlgoChess.Modelo.Movimiento;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Movimiento {

    private Casillero casillero;

    public Movimiento(Casillero casillero){
        casillero = casillero;
    }

    public boolean moverseALaDerecha(Tablero tablero, Entidad entidad){
        Casillero casilleroNuevo = tablero.getDerecha(this.casillero);
        try{moverseA(casilleroNuevo, entidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseALaIzquierda(Tablero tablero, Entidad entidad){
        Casillero casilleroNuevo = tablero.getIzquierda(this.casillero);
        try{moverseA(casilleroNuevo, entidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseArriba(Tablero tablero, Entidad entidad){
        Casillero casilleroNuevo = tablero.getArriba(this.casillero);
        try{moverseA(casilleroNuevo, entidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseAbajo(Tablero tablero, Entidad entidad){
        Casillero casilleroNuevo = tablero.getAbajo(this.casillero);
        try{moverseA(casilleroNuevo, entidad);
        }catch(CasilleroOcupadoException e) {
            return false;
        }catch(DistintoBandoException e){
            return false;
        }
        return true;
    }

    public boolean moverseA(Casillero casilleroNuevo, Entidad entidad) {
        try{
            casilleroNuevo.agregarEntidad(entidad);
        }catch(CasilleroOcupadoException e){
            return false;
        }
        this.casillero.quitarEntidad();
        this.casillero = casilleroNuevo;
        return true;
    }
}
