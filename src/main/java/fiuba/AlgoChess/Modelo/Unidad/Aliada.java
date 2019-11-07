package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;

public class Aliada extends Bando {
    @Override
    public void atacarA(Entidad entidad, TipoAtaque tipoAtaque) {
        entidad.serAtacadaPorAliado(tipoAtaque);
    }

    @Override
    public void curarA(Entidad entidad, int curacion) {
        entidad.serCuradoPorAliado(curacion);
    }

    @Override
    public void serCuradoPorAliado(Entidad entidad, int curacion) {
        entidad.serCurado(curacion);
    }

    @Override
    public void serCuradoPorEnemigo(Entidad entidad, int curacion) {
        throw new DistintoBandoException();
    }

    @Override
    public void serAtacadaPorAliado(Entidad entidad, TipoAtaque tipoAtaque) {
        throw new MismoBandoExeption();
    }

    @Override
    public void serAtacadaPorEnemigo(Entidad entidad, TipoAtaque tipoAtaque) {
        tipoAtaque.atacarA(entidad);
    }
}
