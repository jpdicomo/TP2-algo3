package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.TipoAtaque;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;

public class Enemiga extends Bando {
    @Override
    public void atacarA(Entidad entidad, TipoAtaque tipoAtaque) {
        entidad.serAtacadaPorEnemigo(tipoAtaque);
    }

    @Override
    public void curarA(Entidad entidad, int curacion) {
        entidad.serCuradoPorEnemigo(curacion);
    }

    @Override
    public void serCuradoPorAliado(Entidad entidad, int curacion) {
        throw new DistintoBandoException();
    }

    @Override
    public void serCuradoPorEnemigo(Entidad entidad, int curacion) {
        entidad.serCurado(curacion);
    }

    @Override
    public void serAtacadaPorAliado(Entidad entidad, TipoAtaque tipoAtaque) {
        tipoAtaque.atacarA(entidad);
    }

    @Override
    public void serAtacadaPorEnemigo(Entidad entidad, TipoAtaque tipoAtaque) {
        throw new MismoBandoExeption();
    }
}
