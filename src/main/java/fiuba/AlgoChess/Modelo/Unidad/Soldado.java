package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Ataque.*;


public class Soldado extends Unidad {

	// Atributos.
	
	private TipoAtaque tipoAtaque = new AtaqueMelee(10);

    // Metodos.

    public Soldado(Bando bando) {
    	
        super(bando);
        this.vida = 100;
        this.costo = 1;
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
