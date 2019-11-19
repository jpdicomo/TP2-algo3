package fiuba.AlgoChess.Modelo.Jugador;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;

public class JugadorTest {

    @Test
    public void Test01JugadorPuedeColocarUnaUnidadSiTienePuntos(){
    	
    	Bando bandoJose = new Bando();
        Jugador jose = new Jugador("Jose", bandoJose);
        Jinete jinete = new Jinete(bandoJose);

        jose.agregarUnidad(jinete);
        
        Assert.assertEquals(true, jose.sigueJugando());
    }


    /*
     * Se agregan unidades al jugador hasta que este se queda sin puntos.
     */
    @Test (expected = PuntosInsuficientesException.class)
    public void Test02JugadorNoPuedeColocarUnaUnidadSiNoTienePuntos(){
    	
    	Bando bandoJose = new Bando();
        Jugador jose = new Jugador("Jose", bandoJose);

        for (int i = 0; i < 20; i++) {
			
        	Jinete unJinete = new Jinete(bandoJose);
        	jose.agregarUnidad(unJinete);
		}
    }
    
    
    @Test
    public void Test03JugadorPierdeSiNoTieneUnidades(){

    	Bando bandoJose = new Bando();
        Jugador jose = new Jugador("Jose", bandoJose);

        Assert.assertEquals(false, jose.sigueJugando());
    }
    
    
    @Test
    public void Test04JugadorSigueJugandoSiTieneEntidades(){

    	Bando bandoJose = new Bando();
        Jugador jose = new Jugador("Jose", bandoJose);
        Jinete jinete = new Jinete(bandoJose);
        
        jose.agregarUnidad(jinete);

        Assert.assertEquals(true, jose.sigueJugando());
    }
}