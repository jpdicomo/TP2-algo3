package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

public class Soldado extends Entidad implements Atacante, Movible{

    private TipoAtaque tipoAtaque = new AtaqueMelee(10);

    public Soldado(Casillero casillero) {
        super(casillero);
        this.vida = 100;
        this.costo = 1;
    }

    @Override
    public boolean atacarA(Entidad entidad) {
        try{
            this.bando.atacarA(entidad,tipoAtaque);
        }catch(MismoBandoExeption e){
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
