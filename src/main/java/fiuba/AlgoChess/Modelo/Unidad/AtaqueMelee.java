package fiuba.AlgoChess.Modelo.Unidad;

public class AtaqueMelee extends TipoAtaque {
    public AtaqueMelee(int danio) {
        super(danio);
    }

    @Override
    public void atacarA(Entidad entidad) {
        entidad.recibirDanio(this.danio);
    }
}
