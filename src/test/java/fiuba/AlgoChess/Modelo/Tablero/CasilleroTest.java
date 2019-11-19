package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;

import org.junit.Assert;
import org.junit.Test;


public class CasilleroTest {

	@Test
	public void Test01SeColocaEntidadEnCasilleroLibre() {
		
		Bando bandoJose = new Bando();
		Casillero casillero = new Casillero(1, 1, bandoJose);
		
		Jinete jinete = new Jinete(bandoJose);
		casillero.agregarNuevaUnidad(jinete);
		
		Assert.assertEquals(jinete, casillero.getUnidad());
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void Test02NoSeColocaEntidadEnCasilleroOcupado() {

		Bando bandoJose = new Bando();
		Casillero casillero = new Casillero(1, 1, bandoJose);
		
		Jinete jinete = new Jinete(bandoJose);
		casillero.agregarNuevaUnidad(jinete);

		Jinete otroJinete = new Jinete(bandoJose);
		casillero.agregarNuevaUnidad(otroJinete);
	}

	@Test(expected = DistintoBandoException.class)
	public void Test03NoSeColocaEntidadAliadaEnCasilleroEnemigo() {

		Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
		Casillero casillero = new Casillero(1, 1, bandoJose);
		Jinete jinete = new Jinete(bandoJuan);
		
		casillero.agregarNuevaUnidad(jinete);
	}
}