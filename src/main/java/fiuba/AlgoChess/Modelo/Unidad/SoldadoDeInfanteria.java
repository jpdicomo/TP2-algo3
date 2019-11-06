package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class SoldadoDeInfanteria extends Entidad {

    private int vida = 100;
    private int danioCuerpoACuerpo = 10;
    private int danioADistancia = 0;

    Aliada SoldadoDeInfanteriaAliado = new Aliada();
    public SoldadoDeInfanteria(Casillero casillero) {
        super(casillero);
    }

    public void recibirDanio(distancia){

        if (distancia < 2){

            this.vida -= danioCuerpoACuerpo;

        }else{
            this.vida -= danioADistancia;
        }

    }


    public void atacar(Entidad otraEntidad){

        if( distanciaCon(otraEntidad) < 3){

            otraEntidad.recibirDanio(distancia);
        }

    }
}
