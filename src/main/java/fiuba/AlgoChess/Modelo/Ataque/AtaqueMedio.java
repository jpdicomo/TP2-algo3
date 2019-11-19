package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class AtaqueMedio extends Habilidad {
	
	public AtaqueMedio(int poder) {

		super(poder);
		this.alcance = new Alcance(3, 5);
	}


	@Override
	public void usarHabilidadCon(Unidad unidad, int distancia) {

		this.alcance.estaDentroDelAlcance(distancia);
		unidad.recibirDanio(this.poder);
	}
}
