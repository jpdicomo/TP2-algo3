package Modelo.Tablero;

import Modelo.Errores.CasilleroOcupado;
import Modelo.Unidad.Entidad;

public abstract class Estado {


    public abstract void agregarEntidad(Entidad entidad,Casillero casillero ) throws CasilleroOcupado;
}
