package fiuba.AlgoChess.Modelo.Tablero;

public class Derecha extends Direccion {


    @Override
    public Posicion aplicarDesplazamiento(Posicion posicion) {


        Posicion posDerecha = posicion.desplazar(1,0);

        return posDerecha;

    }
}
