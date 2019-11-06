package fiuba.AlgoChess.Modelo.Unidad;

public abstract class TipoAtaque{
    protected int danio;

    public TipoAtaque(int danio){
        this.danio = danio;
    }
    public abstract void atacarA(Entidad entidad);


}
