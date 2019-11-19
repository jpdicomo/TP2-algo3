package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;

import fiuba.AlgoChess.Modelo.Ataque.*;

public class Jinete extends Unidad {

	// Atributos.
	
    private Ataque ataque;
    private int danioMelee = 5;

    // Metodos.

    public Jinete(Bando bando){
    	
        super(bando);
        this.ataque = new AtaqueMelee(this.danioMelee);
        this.vida = 100;
        this.costo = 3;
    }

    @Override
	public void interactuarCon(Unidad otraUnidad) {

    	super.interactuarCon(otraUnidad);
		this.bando.interactuarConUnEnemigo(otraUnidad);
		this.ataque.atacarA(otraUnidad);
	}
}