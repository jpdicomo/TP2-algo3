package Modelo.Unidad;

import Modelo.Tablero.Casillero;

public class Curandero extends Entidad {
    private int vida;
    private int danioDistancia;
    private int danioMelee;

    public Curandero(Casillero casillero){
        this.casillero = casillero;
    }



}