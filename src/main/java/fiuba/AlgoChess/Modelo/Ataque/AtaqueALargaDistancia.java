package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public class AtaqueALargaDistancia extends TipoAtaque {
    public AtaqueALargaDistancia(int danio) {
        super(danio);
    }

    @Override
    public void atacarA(Unidad unidad) {
        unidad.recibirDanio(this.danio);
    }
}
