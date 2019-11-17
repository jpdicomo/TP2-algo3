package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;


public class CuranderoTest {

	
    @Test
    public void test00CuranderoRecienCreadoTiene75DeVida(){
    	
    	Bando bandoJose = new Bando();
        Curandero curandero = new Curandero(bandoJose);

        Assert.assertEquals(75, curandero.getVida());
    }
    
    
    @Test
    public void test01CuranderoCuraACuranderoAliadoNoDaniadoSumaSusPuntosDeVidaMaximos(){
        
    	Bando bandoJose = new Bando();
    	
    	Curandero curandero1 = new Curandero(bandoJose);
        Curandero curandero2 = new Curandero(bandoJose);

        curandero1.interactuarCon(curandero2);

        Assert.assertEquals(75 + 15,curandero2.getVida());
    }
    
    
    @Test
    public void test02CuranderoCuraACuranderoAliadoDaniadoSumaSusPuntosDeVida(){
    	
    	Bando bandoJose = new Bando();
    	
    	Curandero curandero1 = new Curandero(bandoJose);
        Curandero curandero2 = new Curandero(bandoJose);
        
        curandero2.recibirDanio(15);
        curandero1.interactuarCon(curandero2);

        Assert.assertEquals(75,curandero2.getVida());
    }
    
    
    @Test (expected = DistintoBandoException.class)
    public void test03CuranderoCuraACuranderoEnemigoTiraError(){
    	
    	Bando bandoJose = new Bando();
		Curandero curandero1 = new Curandero(bandoJose);

		Bando bandoJuan = new Bando();
		Curandero curandero2 = new Curandero(bandoJuan);

		curandero1.interactuarCon(curandero2);
    }
}
