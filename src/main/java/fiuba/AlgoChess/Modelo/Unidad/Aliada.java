package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;

public class Aliada extends Bando {
    @Override
    public void atacarA(Unidad unidad, TipoAtaque tipoAtaque) {
        unidad.serAtacadaPorAliado(tipoAtaque);
    }

    @Override
    public void curarA(Unidad unidad, int curacion) {
        unidad.serCuradoPorAliado(curacion);
    }

    @Override
    public void serCuradoPorAliado(Unidad unidad, int curacion) {
        unidad.serCurado(curacion);
    }

    @Override
    public void serCuradoPorEnemigo(Unidad unidad, int curacion) {
        throw new DistintoBandoException();
    }

    @Override
    public void serAtacadaPorAliado(Unidad unidad, TipoAtaque tipoAtaque) {
        throw new MismoBandoExeption();
    }

    @Override
    public void serAtacadaPorEnemigo(Unidad unidad, TipoAtaque tipoAtaque) {
        tipoAtaque.atacarA(unidad);
    }

}
