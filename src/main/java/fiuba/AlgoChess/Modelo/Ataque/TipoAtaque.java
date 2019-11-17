package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public abstract class TipoAtaque{
    protected int danio;

    public TipoAtaque(int danio){
        this.danio = danio;
    }
    public abstract void atacarA(Unidad unidad);


}
