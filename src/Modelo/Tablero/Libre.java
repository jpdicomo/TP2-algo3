package Modelo.Tablero;

import Modelo.Unidad.Entidad;

public class Libre extends Estado {
    @Override
    public void agregarEntidad(Entidad entidad, Casillero casillero) {
        entidad.setCasillero(casillero);
    }
}
