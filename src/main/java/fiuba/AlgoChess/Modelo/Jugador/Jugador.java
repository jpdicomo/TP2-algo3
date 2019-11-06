package fiuba.AlgoChess.Modelo.Jugador;


import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;


public class Jugador {

    private int puntos = 20;
    private int cantidadEntidades = 0;

    public boolean colocarEntidad(Entidad unaEntidad){


        if(this.puntos >= unaEntidad.getCosto()){ //precioentidad
            this.puntos-= unaEntidad.getCosto();
            this.cantidadEntidades ++;
            return true;

        }else{
            return false;
        }

    }
    //funciona como controlador de estado de jugador.
    public boolean sigueJugando(){
        return(this.cantidadEntidades >0);

    }

}
