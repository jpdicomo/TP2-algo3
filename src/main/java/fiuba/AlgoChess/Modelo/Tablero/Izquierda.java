package fiuba.AlgoChess.Modelo.Tablero;

public class Izquierda extends Direccion{

    @Override
    public Posicion aplicarDesplazamiento(Posicion posicion) {


        Posicion posIzquierda = posicion.desplazar(-1,0);

        return posIzquierda;
    }
}
