package Modelo.Unidad;

import Modelo.Tablero.Casillero;

public class SoldadoDeInfanteria extends Unidad{

    //atributos
    private int vida = 100;
    private int danioDistancia = 15;
    private int danioMelee = 5;


    //constructor
    public SoldadoDeInfanteria(Casillero casillero){this.casillero = casillero; }



}
