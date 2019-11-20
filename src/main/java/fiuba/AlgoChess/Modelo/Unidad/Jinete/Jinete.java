package fiuba.AlgoChess.Modelo.Unidad.Jinete;

import fiuba.AlgoChess.Modelo.Ataque.AtaqueCerca;
import fiuba.AlgoChess.Modelo.Ataque.AtaqueMedio;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public class Jinete extends Unidad {

	// Atributos.
	
	private Estado estado;
	
	
    // Metodos.

    public Jinete(Bando bando){
    	
        super(bando);
        this.vida = 100;
        this.costo = 3;
    }

    
    @Override
	public void interactuarCon(Unidad unaUnidad, int distancia) {

    	super.interactuarCon(unaUnidad, distancia);
    	this.bando.interactuarConUnEnemigo(unaUnidad);
    	this.hayEnemigosCerca();
		this.habilidad.usarHabilidadCon(unaUnidad, distancia);
	}
    
    
    private void hayEnemigosCerca() {
    	
    	if(this.casillero.hayEnemigosCerca(this.bando)) {
    		
    		this.habilidad = new AtaqueCerca(5);
    		
    	} else {
    		
    		this.habilidad = new AtaqueMedio(15);
    	}
    }
    
}