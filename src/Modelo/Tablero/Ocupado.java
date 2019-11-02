package Modelo.Tablero;

import Modelo.Errores.CasilleroOcupado;
import Modelo.Unidad.Entidad;

public class Ocupado extends Estado {
	
    @Override
    public void agregarEntidad(Entidad entidad, Casillero casillero){
        throw new CasilleroOcupado();
    }
}
