package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class AtaqueCerca extends Habilidad {
	
	
	public AtaqueCerca(int poder) {
		
		super(poder);
		this.alcance = new Alcance(1, 2);
	}
	
	
	@Override
	public void usarHabilidadCon(Casillero unCasillero, double distancia) {
		
		super.usarHabilidadCon(unCasillero, distancia);
		unCasillero.recibirDanio(this.poder);
	}
}
