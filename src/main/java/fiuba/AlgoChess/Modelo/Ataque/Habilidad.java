package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public abstract class Habilidad {

	
	// Atributos.

	protected int poder;
	protected Alcance alcance;

	
	// Metodos.

	/*
	 * POST: 
	 */
	public Habilidad(int poder) {

		this.poder = poder;
	}
	
	
	/*
	 * 
	 */
	public void usarHabilidadCon(Unidad unidad, int distancia) {
		
		this.alcance.estaDentroDelAlcance(distancia);
	}

}
