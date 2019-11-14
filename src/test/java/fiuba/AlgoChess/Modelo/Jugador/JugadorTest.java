package fiuba.AlgoChess.Modelo.Jugador;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;

public class JugadorTest {

    @Test
    public void Test01JugadorPuedeColocarUnaUnidadSiTienePuntos(){

        Jugador jose = new Jugador("Jose");
        Jinete jinete = new Jinete(jose.getBando());

        jose.agregarUnidad(jinete);
        
        Assert.assertEquals(true, jose.sigueJugando());
    }


    /*
     * Se agregan unidades al jugador hasta que este se queda sin puntos.
     */
    @Test (expected = PuntosInsuficientesException.class)
    public void Test02JugadorNoPuedeColocarUnaUnidadSiNoTienePuntos(){
    	
        Jugador jose = new Jugador("Jose");

        for (int i = 0; i < 20; i++) {
			
        	Jinete unJinete = new Jinete(jose.getBando());
        	jose.agregarUnidad(unJinete);
		}
    }
    
    
    @Test
    public void Test03JugadorPierdeSiNoTieneUnidades(){

        Jugador jose = new Jugador("Jose");

        Assert.assertEquals(false, jose.sigueJugando());
    }
    
    
    @Test
    public void Test04JugadorSigueJugandoSiTieneEntidades(){

        Jugador jose = new Jugador("Jose");
        Jinete jinete = new Jinete(jose.getBando());
        jose.agregarUnidad(jinete);

        Assert.assertEquals(true, jose.sigueJugando());
    }
}