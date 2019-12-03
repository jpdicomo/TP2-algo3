package fiuba.AlgoChess.Modelo.Ataque;

import java.util.ArrayList;
import java.util.HashSet;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class AtaqueEnArea extends Habilidad {
	
	
	public AtaqueEnArea(double poder) {
		
		super(poder);
		this.alcance = new Alcance(6, 20);
	}


	@Override
	public void usarHabilidadCon(Casillero unCasillero, double distancia) {

		HashSet<Casillero> atacados = new HashSet<>();
		ArrayList<Casillero> sinAtacar = new ArrayList<>();
		
		super.usarHabilidadCon(unCasillero, distancia);		
        sinAtacar.add(unCasillero);
        
		while (!sinAtacar.isEmpty()) {

			Casillero casillero = sinAtacar.remove(0);

			if (!atacados.contains(casillero)) {

				try {

					casillero.recibirDanio(this.poder);
					atacados.add(casillero);
					sinAtacar.addAll(casillero.getVecinos());

				} catch (CasilleroLibreException e) {

					atacados.add(casillero);
				}
			}
		}
	}
}
