package main.java.fiuba.AlgoChess.Modelo.Unidad;

import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Curandero extends Entidad {

    private int vida = 100;
    private int danioDistancia;
    private int danioMelee;

    public Curandero(Casillero casillero){
        super(casillero);
    }

    void curar(Aliada aliada){

        aliada.recibirCura();
    }
}