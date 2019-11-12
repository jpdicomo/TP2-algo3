package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.*;
import fiuba.AlgoChess.Modelo.Movimiento.Movible;
import fiuba.AlgoChess.Modelo.Errores.*;
import fiuba.AlgoChess.Modelo.Movimiento.Movimiento;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

public class Soldado extends Entidad implements Atacante, Movible {

    private TipoAtaque tipoAtaque = new AtaqueMelee(10);
    private Movimiento movimiento;

    public Soldado(Casillero casillero) {
        super(casillero);
        this.vida = 100;
        this.costo = 1;
        this.movimiento = new Movimiento(this.casillero);
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
        return this.movimiento.moverseA(casilleroNuevo, this);
    }
}
