package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;

import fiuba.AlgoChess.Modelo.Ataque.*;

public class Jinete extends Unidad {

	// Atributos.
	
    private Ataque tipoAtaque;
    private int danioMelee = 5;

    // Metodos.

    public Jinete(Bando bando){
    	
        super(bando);
        this.tipoAtaque = new AtaqueMelee(this.danioMelee);
        this.vida = 100;
        this.costo = 3;
    }

    @Override
	public void interactuarCon(Unidad otraUnidad) {

    	super.interactuarCon(otraUnidad);
		this.bando.interactuarConUnEnemigo(otraUnidad);
		this.tipoAtaque.atacarA(otraUnidad);
	}
    
    
    // Metodo de clase (estatico)
    public int getCosto() {
    	
    	return this.costo;
    }
}