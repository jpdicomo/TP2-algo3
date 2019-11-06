package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Ocupado extends Estado {

    @Override
    public void agregarEntidad(Entidad entidad, Casillero casillero){

        throw new CasilleroOcupadoException();
    }
}

