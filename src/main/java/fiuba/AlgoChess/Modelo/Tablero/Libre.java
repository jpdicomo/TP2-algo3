package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Libre extends Estado {

    @Override
    public void agregarEntidad(Entidad entidad, Casillero casillero) {

        entidad.setCasillero(casillero);
    }
}
