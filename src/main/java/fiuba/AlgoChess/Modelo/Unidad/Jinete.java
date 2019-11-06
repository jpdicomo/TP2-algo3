package main.java.fiuba.AlgoChess.Modelo.Unidad;


import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Jinete extends Entidad {

    private int vida = 100;
    private int danioDistancia = 15;
    private int danioMelee = 5;

    public Jinete(Casillero casillero){

        super(casillero);
    }

}