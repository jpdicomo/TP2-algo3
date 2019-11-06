package main.java.fiuba.AlgoChess.Modelo.Unidad;


import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Jinete extends Entidad {

    private int vida = 100;
    private int danioDistancia = 15;
    private int danioMelee = 5;
    public String estatus = "Jinete";

    Aliada jineteAliado = new Aliada();

    public Jinete(Casillero casillero){

        super(casillero);
    }

    public getEstatus(){

        return(this.estatus);
    }

    public void recibirDanio(int distancia){

        if(distancia < 2){

            this.vida -= danioMelee;
        }else
            this.vida -= danioDistancia;


    }


}