package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.AtaqueCerca;
import fiuba.AlgoChess.Modelo.Jugador.Bando;


public class Soldado extends Unidad {

    // Metodos.

    public Soldado(Bando bando) {
    	
        super(bando);
        this.vida = 100;
        this.costo = 1;
        this.habilidad = new AtaqueCerca(10);
    }

    @Override
	public void interactuarCon(Unidad unaUnidad, int distancia) {

    	super.interactuarCon(unaUnidad, distancia);
    	this.bando.interactuarConUnEnemigo(unaUnidad);
		this.habilidad.usarHabilidadCon(unaUnidad, distancia);
	}
}
