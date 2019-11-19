package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class AtaqueCerca extends Habilidad {

	
	public AtaqueCerca(int poder) {

		super(poder);
		this.alcance = new Alcance(1, 2);
	}


	@Override
	public void usarHabilidadCon(Unidad unidad, int distancia) {

		this.alcance.estaDentroDelAlcance(distancia);
		unidad.recibirDanio(this.poder);
	}
}
