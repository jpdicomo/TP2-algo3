package fiuba.AlgoChess.Modelo.Tablero;

public class Arriba extends Direccion {

    @Override
    public Posicion aplicarDesplazamiento(Posicion posicion) {

        Posicion posArriba = posicion.desplazar(0,+1);

        return posArriba;
    }
}
