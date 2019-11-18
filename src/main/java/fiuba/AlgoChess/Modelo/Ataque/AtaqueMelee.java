package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class AtaqueMelee extends Ataque {

	public AtaqueMelee(int danio) {
	
		super(danio);
	}

	@Override
	public void atacarA(Unidad unaUnidad) {

		unaUnidad.recibirDanio(this.danio);
	}
}
