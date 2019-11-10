package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

public class Jinete extends Unidad implements Atacante, Movible{

    private TipoAtaque tipoAtaque;
    private int danioMelee = 5;

    public Jinete(Casillero casillero){
        super(casillero);
        this.tipoAtaque = new AtaqueMelee(this.danioMelee);
        this.vida = 100;
        this.costo = 3;
    }

    @Override
    public boolean atacarA(Unidad unidad) {
        try{
            this.bando.atacarA(unidad,tipoAtaque);
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