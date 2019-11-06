package fiuba.AlgoChess.Modelo.Jugador;


import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;


public class Jugador {

    private int puntos = 20;

    public boolean colocarEntidad(Entidad unaEntidad){


        if(this.puntos >= unaEntidad.getCosto()){ //precioentidad
            this.puntos-= unaEntidad.getCosto();
            return true;

        }else{
            return false;
        }

    }

}
