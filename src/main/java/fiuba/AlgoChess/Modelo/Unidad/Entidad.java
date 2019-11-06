package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;


public abstract class Entidad {

    protected Casillero casillero;
    protected int vida;

    public Entidad(Casillero casillero) {

        this.setCasillero(casillero);
    }

    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }

    public abstract void atacarA(Entidad entidad);

    public void recibirDanio(int danio){
        this.vida -= danio;
    }

    public int getVida(){
        return this.vida;
    }
}