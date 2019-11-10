package fiuba.AlgoChess.Modelo.Unidad;

public abstract class Bando {

    public abstract void atacarA(Unidad unidad, TipoAtaque tipoAtaque);

    public abstract void curarA(Unidad unidad, int curacion);

    public abstract void serCuradoPorAliado(Unidad unidad, int curacion);

    public abstract void serCuradoPorEnemigo(Unidad unidad, int curacion);

    public abstract void serAtacadaPorAliado(Unidad unidad, TipoAtaque tipoAtaque);

    public abstract void serAtacadaPorEnemigo(Unidad unidad, TipoAtaque tipoAtaque);

}
