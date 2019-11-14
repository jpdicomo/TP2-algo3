package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Ataque.*;
import fiuba.AlgoChess.Modelo.Errores.*;
import fiuba.AlgoChess.Modelo.Movimiento.*;
import fiuba.AlgoChess.Modelo.Tablero.*;

public class Jinete extends Entidad implements Atacante, Movible {

    private TipoAtaque tipoAtaque;
    private int danioMelee = 5;
    private Movimiento movimiento;

    public Jinete(Casillero casillero){
        super(casillero);
        this.tipoAtaque = new AtaqueMelee(this.danioMelee);
        this.vida = 100;
        this.costo = 3;
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
    //Hacer una clase direccion para reducir la cantidad de codigo repetido
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
       return this.movimiento.moverseAbajo(tablero,this);
    }


    @Override
    public boolean moverseA(Casillero casilleroNuevo) {
        return this.movimiento.moverseA(casilleroNuevo, this);
    }
}