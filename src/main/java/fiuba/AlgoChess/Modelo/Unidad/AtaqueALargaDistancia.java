package fiuba.AlgoChess.Modelo.Unidad;

public class AtaqueALargaDistancia extends TipoAtaque {
    public AtaqueALargaDistancia(int danio) {
        super(danio);
    }

    @Override
    public void atacarA(Entidad entidad) {
        entidad.recibirDanio(this.danio);
    }
}
