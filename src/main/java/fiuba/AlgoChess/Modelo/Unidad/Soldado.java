package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Soldado extends Entidad implements Atacante{
    private TipoAtaque tipoAtaque = new AtaqueMelee(10);
    public Soldado(Casillero casillero) {
        super(casillero);
    }

    @Override
    public void atacarA(Entidad entidad) {
        this.tipoAtaque.atacarA(entidad);
    }
}
