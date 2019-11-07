package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import fiuba.AlgoChess.Modelo.Errores..CatapultaNoPuedeSerCuradaException;

public class Catapulta extends Entidad implements Atacante {
    private TipoAtaque tipoAtaque = new AtaqueALargaDistancia(20);
    public Catapulta(Casillero casillero) {
        super(casillero);
        this.vida = 50;
    }

    @Override
    public void atacarA(Entidad entidad) {
        this.tipoAtaque.atacarA(entidad);
    }
    
	@Override
	public void serCurado(int curacion) {
	
		throw new CatapultaNoPuedeSerCuradaException();
	}
}
