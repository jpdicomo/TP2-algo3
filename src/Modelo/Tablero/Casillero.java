package Modelo.Tablero;

import Modelo.Errores.CasilleroOcupado;
import Modelo.Unidad.Entidad;

public class Casillero {
    private int x;
    private int y;
    private Estado estado;

    public Casillero(int x, int y){
        this.x = x;
        this.y = y;
        this.estado = new Libre();
    }
    public boolean agregarEntidad(Entidad entidad){
        try {
            estado.agregarEntidad(entidad, this);
            estado = new Ocupado();
        }
        catch(CasilleroOcupado error){
            return false;
        }
        return true;
    }
}

