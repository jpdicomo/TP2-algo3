package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class AtaqueALargaDistancia extends TipoAtaque {
    public AtaqueALargaDistancia(int danio) {
        super(danio);
    }

    @Override
    public void atacarA(Entidad entidad) {
        entidad.recibirDanio(this.danio);
    }
}
