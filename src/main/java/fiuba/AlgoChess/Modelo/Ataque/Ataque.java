package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public abstract class Ataque {

	// Atributos.

	protected int danio;

	
	// Metodos.

	/*
	 * POST: Crea un nuevo Ataque y le asigna un daño.
	 */
	public Ataque(int danio) {

		this.danio = danio;
	}

	
	/*
	 * 
	 */
	public abstract void atacarA(Casillero unCasillero);

}
