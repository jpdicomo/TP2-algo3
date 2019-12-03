package fiuba.AlgoChess.Modelo.Unidad;

import java.util.ArrayList;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;


public class Batallon {
	
	private ArrayList<Posicion> posicionIntegrantes;
	private boolean hayBatallon;
	
	
	public Batallon(boolean hayBatallon) {
		
		this.hayBatallon = hayBatallon;
	}

	
	public Batallon(Posicion posicion1, Posicion posicion2, Posicion posicion3, boolean hayBatallon) {

		this.posicionIntegrantes = new ArrayList<Posicion>();
		this.posicionIntegrantes.add(posicion1);
		this.posicionIntegrantes.add(posicion2);
		this.posicionIntegrantes.add(posicion3);
		this.hayBatallon = hayBatallon;
	}


	public boolean hayBatallon() {
		
		return this.hayBatallon;
	}
	
	
	public Posicion posicionIntegrante(int indiceIntegrante) {
		
		return this.posicionIntegrantes.get(indiceIntegrante);
	}
}
