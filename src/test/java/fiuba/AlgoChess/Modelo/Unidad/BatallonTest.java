package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ubicacion.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;


public class BatallonTest {

    @Test
    public void Test00SeMueveUnSoldadoJuntoAOtroYNoActuanComoBatallon(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);

        Posicion posicionInicial1 = new Posicion(0,0);
        Posicion posicionInicial2 = new Posicion(0,1);

        Posicion posicionFinal1 = new Posicion(1,0);
        Posicion posicionFinal2 = posicionInicial2;

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicionInicial1);
        tablero.agregarNuevaUnidad(soldado2, posicionInicial2);
        tablero.moverUnidad(posicionInicial1, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(posicionFinal1));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(posicionFinal2));
    }


    @Test
    public void Test01SeMueveEnDiagonalUnSoldadoJuntoAOtrosDosYActuanComoBatallon(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(1,1);
        Posicion posicion3 = new Posicion(0,2);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(3,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(2,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(1,2)));
    }


    @Test
    public void Test02SeMueveUnBatallonPeroUnoQuedaBloqueado(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(1,1);
        Posicion posicion3 = new Posicion(0,2);

        Direccion direccion = new Sur();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(0,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(0,2)));
    }






    @Test (expected = DesplazamientoInvalidoExcepcion.class)
    public void Test03SeQuiereMoverUnBatallonPeroTodosEstanBloqueadosEnDireccionOesteYTiraError(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(1,0);
        Posicion posicion3 = new Posicion(0,0);

        Direccion direccion = new Oeste();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);
    }



    @Test
    public void Test04SeMueveUnSoldadoJuntoAOtrosTresYUnoNoSeMueveConElBatallon(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        Soldado soldado4 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(0,1);
        Posicion posicion3 = new Posicion(0,2);
        Posicion posicion4 = new Posicion(0,3);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        tablero.agregarNuevaUnidad(soldado4, posicion4);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(1,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(1,2)));
        Assert.assertEquals(soldado4, tablero.seleccionarUnidad(posicion4));
    }


    /*
     * Nota: este test es muy parecido (capz igual al test 02)
     */
    @Test
    public void Test05SeMueveUnBatallonYUnSoldadoDelMismoQuedaBloqueado(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        Soldado soldado4 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(0,1);
        Posicion posicion3 = new Posicion(0,2);
        Posicion posicion4 = new Posicion(1,1);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        tablero.agregarNuevaUnidad(soldado4, posicion4);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(posicion2));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(1,2)));
    }


    @Test (expected = CasilleroOcupadoException.class)
    public void Test05SeMueveUnBatallonDondeUnSoldadoDelMismoQuedaBloqueadoYElBatallonSeDesarma(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        Soldado soldado4 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(0,1);
        Posicion posicion3 = new Posicion(0,2);
        Posicion posicion4 = new Posicion(1,1);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        tablero.agregarNuevaUnidad(soldado4, posicion4);

        tablero.moverUnidad(posicion2, direccion);
        tablero.moverUnidad(posicion2, direccion);

        /*
         *  Al tratar de mover la pieza bloqueada, como ya no forma parte
         *  de un batallon (porque ya no existe un batallon) se lanza una
         *  excepcion.
         */
    }

    @Test
    public void Test06SeMueveUnSoldadoJuntoAOtrosDosYActuanComoBatallonEnDireccionHorizontal(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(1,0);
        Posicion posicion2 = new Posicion(1,1);
        Posicion posicion3 = new Posicion(1,2);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(2,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(2,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(2,2)));
    }


    @Test
    public void Test07SeMuevenHaciaElNortelUnSoldadoJuntoAOtrosDosYActuanComoBatallonEnDireccionVertical(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(0,1);
        Posicion posicion2 = new Posicion(1,1);
        Posicion posicion3 = new Posicion(2,1);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,1)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(2,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(3,1)));
    }
    @Test (expected = DesplazamientoInvalidoExcepcion.class)
    public void Test08SeQuiereMoverUnBatallonPeroTodosEstanBloqueadosEnDireccionOesteYTiraError(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(1,0);
        Posicion posicion3 = new Posicion(0,0);

        Direccion direccion = new Oeste();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);
    }

    @Test (expected = DesplazamientoInvalidoExcepcion.class)
    public void Test09SeQuiereMoverUnBatallonPeroTodosEstanBloqueadosEnDireccionNorteYTiraError(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(2,19);
        Posicion posicion2 = new Posicion(1,19);
        Posicion posicion3 = new Posicion(0,19);

        Direccion direccion = new Este();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);
    }

    @Test
    public void Test10UnSoldadoEstaJuntoAOtrosDeDistintoBandoYNoActuanComoBatallon(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJuan);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJuan);

        Posicion posicion1 = new Posicion(10,0);
        Posicion posicion2 = new Posicion(9,1);
        Posicion posicion3 = new Posicion(10,2);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        // Hago que se paren todos juntos
        tablero.moverUnidad(posicion2, direccion);
 
        // Se mueve solo el soldado2 porque no hay batallon
        tablero.moverUnidad(new Posicion(10, 1), direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(10,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(11,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(10,2)));
    }

    @Test
    public void Test11UnSoldadoEstaJuntoAUnSoldadoAliadoYUnOTroDeDistintoBandoYNoActuanComoBatallon(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJuan);

        Posicion posicion1 = new Posicion(9,0);
        Posicion posicion2 = new Posicion(9,1);
        Posicion posicion3 = new Posicion(10,2);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        // Ubico los soldados de Jose junto al de Juan
        tablero.moverUnidad(posicion1, direccion);
        tablero.moverUnidad(posicion2, direccion);

        // Se mueve solo el soldado del medio porque no hay batallon
        tablero.moverUnidad(new Posicion(10, 1), direccion);
        
        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(10,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(11,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(10,2)));
    }


    @Test
    public void Test12SeMuevenHaciaElSurlUnSoldadoJuntoAOtrosDosYActuanComoBatallonEnDireccionHorizontal(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(2,1);
        Posicion posicion3 = new Posicion(2,2);

        Direccion direccion = new Sur();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(1,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(1,2)));
    }


    @Test
    public void Test13SeMuevenHaciaElEsteUnSoldadoJuntoAOtrosDosYActuanComoBatallonEnDireccionHorizontal(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(0,1);
        Posicion posicion2 = new Posicion(1,1);
        Posicion posicion3 = new Posicion(2,1);

        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);

        tablero.moverUnidad(posicion2, direccion);

        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,1)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(2,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(3,1)));
    }


    /*
     * Este test es IDENTICO al test 05 (el primero) arreglar numeracion.
     */
    @Test (expected = CasilleroOcupadoException.class)
    public void Test14SeMueveUnBatallonDondeUnSoldadoDelMismoQuedaBloqueadoYElBatallonSeDesarma(){

        Bando bandoJose = new Bando();
        Bando bandoJuan = new Bando();

        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        Soldado soldado4 = new Soldado(bandoJose);

        Posicion posicion1 = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(1, 0);
        Posicion posicion3 = new Posicion(2, 0);
        Posicion posicion4 = new Posicion(1, 1);


        Direccion direccion = new Norte();

        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        tablero.agregarNuevaUnidad(soldado4, posicion4);


        tablero.moverUnidad(posicion2, direccion);
        tablero.moverUnidad(posicion2, direccion);

        /*
         *  Al tratar de mover la pieza bloqueada, como ya no forma parte
         *  de un batallon (porque ya no existe un batallon) se lanza una
         *  excepcion.
         */
    }




}
