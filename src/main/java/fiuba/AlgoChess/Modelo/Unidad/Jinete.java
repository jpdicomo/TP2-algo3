package fiuba.AlgoChess.Modelo.Tablero;


import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;


public class Jinete extends Entidad{

    private int vida = 100;
    private int danioDistancia = 15;
    private int danioMelee = 5;
    private int costo = 3;

    public Jinete(Casillero casillero){

        super(casillero);
    }

    public int getCosto(){
        return (this.costo);
    }

}