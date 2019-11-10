package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import java.util.Scanner;


public class Jugador {

    // Atributos.

    private String nombre;
    private int puntos;
    private int cantidadEntidades;
    private final Bando bando;
    Scanner consola = new Scanner(System.in);


    // Metodos.

    /*
     * POST: Crea un nuevo Jugador al cual se le ha asignado un nombre y
     * una cierta cantidad de puntos para jugar.
     */
    public Jugador(String nombre){

        this.nombre = nombre;
        this.puntos = 20;
        this.cantidadEntidades = 0; // Abria que eliminar esto luego o buscar una solución mejor.
        this.bando = new Bando(this);
    }


    /*
     * PRE:  El Jugador cuenta con puntos suficientes para colocar una nueva Entidad en el Tablero.
     * POST: Se agrega una nueva Entidad al Tablero y al Jugador.
     *
     * NOTA: Revisar este metodo a ver si puedo mejorarlo.
     */
    public boolean agregarUnidad(Unidad unaUnidad){

        this.elegirUnidad();
        this.elegirCasillero();

        if (this.puntos >= unaUnidad.getCosto()) { //precioentidad

            this.puntos-= unaUnidad.getCosto();
            this.cantidadEntidades++;
            return true;

        } else {

            return false;
        }
    }


    /*
     * POST: Indica si el Jugador aún tiene fichas para continuar jugando.
     */
    public boolean sigueJugando() {

        return(this.cantidadEntidades > 0);
    }


    /*
     * PRE:  -...
     * POST: -...
     */
    public int[] elegirCasillero(){

        int[] posicion = new int[2];

        System.out.print("Ingresa fila: ");
        posicion[0] = consola.nextInt();

        System.out.print("\nIngresa columna: ");
        posicion[1] = consola.nextInt();

        return posicion;
    }


    /* NOTA: Quitar este metodo.
     *
     * POST: ...
     */
    public void setPuntos(int puntos) {

        this.puntos = puntos;
    }
}