package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public abstract class TipoAtaque{
    protected int danio;

    public TipoAtaque(int danio){
        this.danio = danio;
    }
    public abstract void atacarA(Entidad entidad);


}
