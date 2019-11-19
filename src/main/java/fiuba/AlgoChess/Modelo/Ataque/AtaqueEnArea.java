package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class AtaqueEnArea extends Habilidad {
	
	
	public AtaqueEnArea(int poder) {
		
		super(poder);
		this.alcance = new Alcance(6, 20);
	}


	@Override
	public void usarHabilidadCon(Unidad unidad, int distancia) {

		this.alcance.estaDentroDelAlcance(distancia);
		// Buscar como extender el ataque de la catapulta.
		unidad.recibirDanio(this.poder);
	}
}
