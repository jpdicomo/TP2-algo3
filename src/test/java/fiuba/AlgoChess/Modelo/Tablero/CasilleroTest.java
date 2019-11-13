package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;

import org.junit.Assert;
import org.junit.Test;


public class CasilleroTest {

	@Test
	public void Test01SeColocaEntidadEnCasilleroLibre() {

		Jugador fede = new Jugador("Fede");

		Casillero casillero = new Casillero(1, 1, fede.getBando());
		
		Jinete jinete = new Jinete(fede.getBando());
		casillero.agregarNuevaUnidad(jinete);
		
		Assert.assertEquals(jinete, casillero.getUnidad());
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void Test02NoSeColocaEntidadEnCasilleroOcupado() {

		Jugador fede = new Jugador("Fede");
		
		Casillero casillero = new Casillero(1, 1, fede.getBando());
		
		Jinete jinete = new Jinete(fede.getBando());
		casillero.agregarNuevaUnidad(jinete);

		Jinete otroJinete = new Jinete(fede.getBando());
		casillero.agregarNuevaUnidad(otroJinete);
	}

	@Test(expected = DistintoBandoException.class)
	public void Test03NoSeColocaEntidadAliadaEnCasilleroEnemigo() {

		Jugador fede = new Jugador("Fede");
		Jugador juampi = new Jugador("Juampi");
		
		Casillero casillero = new Casillero(1, 1, fede.getBando());
		Jinete jinete = new Jinete(juampi.getBando());
		
		casillero.agregarNuevaUnidad(jinete);
	}

}