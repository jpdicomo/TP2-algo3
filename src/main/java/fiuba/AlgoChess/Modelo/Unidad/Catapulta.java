package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerCuradaException;
import fiuba.AlgoChess.Modelo.Ataque.AtaqueEnArea;
import fiuba.AlgoChess.Modelo.Jugador.Bando;


public class Catapulta extends Unidad {
    
    // Metodos.
    
    /*
     * PRE:  ...
     * POST: ... 
     */
    public Catapulta(Bando bando) {
    	
        super(bando);
        this.vida = 50;
        this.costo = 5;
        this.habilidad = new AtaqueEnArea(20);
    }


    /*
     * 
     */
	@Override
	public void serCurado(int curacion) {
	
		throw new CatapultaNoPuedeSerCuradaException();
	}


	@Override
	public void interactuarCon(Unidad unaUnidad, int distancia) {

		super.interactuarCon(unaUnidad, distancia);
		this.bando.interactuarConUnEnemigo(unaUnidad);
		this.habilidad.usarHabilidadCon(unaUnidad, distancia);
	}
}
