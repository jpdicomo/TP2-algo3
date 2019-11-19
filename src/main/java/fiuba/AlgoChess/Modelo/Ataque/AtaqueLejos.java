package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class AtaqueLejos extends Habilidad {

	
	public AtaqueLejos(int poder) {

		super(poder);
		this.alcance = new Alcance(6, 20);
	}


	@Override
	public void usarHabilidadCon(Unidad unidad, int distancia) {

		this.alcance.estaDentroDelAlcance(distancia);
		unidad.recibirDanio(this.poder);
	}
}
