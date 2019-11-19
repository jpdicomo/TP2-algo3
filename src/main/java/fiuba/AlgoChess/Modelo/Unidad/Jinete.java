package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.AtaqueCerca;
import fiuba.AlgoChess.Modelo.Jugador.Bando;

public class Jinete extends Unidad {

    // Metodos.

    public Jinete(Bando bando){
    	
        super(bando);
        this.vida = 100;
        this.costo = 3;
        this.habilidad = new AtaqueCerca(10);
    }

    @Override
	public void interactuarCon(Unidad unaUnidad, int distancia) {

    	super.interactuarCon(unaUnidad, distancia);
    	this.bando.interactuarConUnEnemigo(unaUnidad);
		this.habilidad.usarHabilidadCon(unaUnidad, distancia);
	}
}