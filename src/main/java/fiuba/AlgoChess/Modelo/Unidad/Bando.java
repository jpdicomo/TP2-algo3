package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.TipoAtaque;

public abstract class Bando {

    public abstract void atacarA(Entidad entidad, TipoAtaque tipoAtaque);

    public abstract void curarA(Entidad entidad, int curacion);

    public abstract void serCuradoPorAliado(Entidad entidad,int curacion);

    public abstract void serCuradoPorEnemigo(Entidad entidad, int curacion);

    public abstract void serAtacadaPorAliado(Entidad entidad, TipoAtaque tipoAtaque);

    public abstract void serAtacadaPorEnemigo(Entidad entidad, TipoAtaque tipoAtaque);

    public abstract int getBando();
}
