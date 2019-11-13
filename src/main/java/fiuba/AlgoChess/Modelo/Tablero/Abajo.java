package fiuba.AlgoChess.Modelo.Tablero;

public class Abajo extends Direccion {

    @Override
    public Posicion aplicarDesplazamiento(Posicion posicion) {

        Posicion posAbajo = posicion.desplazar(0,-1);

        return posAbajo;
    }
}
