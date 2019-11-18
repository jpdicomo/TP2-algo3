package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public abstract class Ataque{
    protected int danio;

    public Ataque(int danio){
        this.danio = danio;
    }
    public abstract void atacarA(Unidad unidad);


}
