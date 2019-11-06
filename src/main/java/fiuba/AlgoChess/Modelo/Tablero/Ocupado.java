package main.java.fiuba.AlgoChess.Modelo.Tablero;

import main.java.fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Ocupado extends Estado {

    @Override
    public void agregarEntidad(Entidad entidad, Casillero casillero){

        throw new CasilleroOcupadoException();
    }
}

