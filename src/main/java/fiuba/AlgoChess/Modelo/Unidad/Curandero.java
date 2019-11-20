package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.Curacion;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class Curandero extends Unidad /*implements Movible*/{
	
	// Metodos.
    /* 
     * PRE:  El casillero esta libre.
     * POST: Crea un nuevo curandero, ubicado en un casillero.
     */
    public Curandero(Bando bando){
    	
        super(bando);
        this.vida = 75;
        this.costo= 2;
        this.habilidad = new Curacion(15);
    }
    
    
    /*
     * PRE:  La otra unidad sobre la que el curandero realizara una accion (lo curara)
     * 		 es un aliado.
     * POST: La unidad aliada es curada.
     */
    @Override
	public void interactuarCon(Casillero unCasillero) {

		super.interactuarCon(unCasillero);
		this.bando.interactuarConUnAliado(unCasillero.getUnidad());
		
		double distancia = this.casillero.medirDistanciaA(unCasillero);
		this.habilidad.usarHabilidadCon(unCasillero, distancia);
	}
}
