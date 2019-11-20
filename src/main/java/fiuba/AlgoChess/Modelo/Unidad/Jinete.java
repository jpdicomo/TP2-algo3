package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.AtaqueCerca;
import fiuba.AlgoChess.Modelo.Ataque.AtaqueMedio;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;

public class Jinete extends Unidad {
	
    // Metodos.

    public Jinete(Bando bando){
    	
        super(bando);
        this.vida = 100;
        this.costo = 3;
    }

    
    @Override
	public void interactuarCon(Casillero unCasillero) {

		super.interactuarCon(unCasillero);
		this.bando.interactuarConUnEnemigo(unCasillero.getUnidad());
		this.hayEnemigosCerca();
		
		double distancia = this.casillero.medirDistanciaA(unCasillero);
		this.habilidad.usarHabilidadCon(unCasillero, distancia);
	}
    
    
    private void hayEnemigosCerca() {
    	
    	if(this.casillero.hayEnemigosCerca(this.bando)) {
    		
    		this.habilidad = new AtaqueCerca(5);
    		
    	} else {
    		
    		this.habilidad = new AtaqueMedio(15);
    	}
    }
    
}