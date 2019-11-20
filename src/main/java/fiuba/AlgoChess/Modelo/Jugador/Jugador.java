package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
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
     * 		 una cierta cantidad de puntos para jugar.
     */
    public Jugador(String nombre, Bando bando){

        this.nombre = nombre;
        this.puntos = 20;
        this.cantidadEntidades = 0;
        this.bando = bando;
    }
    
    
    /* Este metodo esta bien.
     * 
     * POST: Devuelve el nombre del Jugador.
     */
    public String getNombre() {
    	
    	return this.nombre;
    }
    
    
//    /* Este metodo esta bien.
//     * 
//     * POST: Devuelve la cantidad de puntos del Jugador.
//     */
//    public int getPuntos() {
//    	
//    	return this.puntos;
//    }


    /* Este metodo esta bien.
     * 
     * PRE:  El Jugador cuenta con puntos suficientes para colocar una nueva Unidad en el Tablero.
     * POST: Se agrega una nueva Unidad al Jugador.
     *
     */
    public void agregarUnidad(Unidad unaUnidad){

        if (this.puntos >= unaUnidad.getCosto()) {
        	
            this.puntos-= unaUnidad.getCosto();
            this.cantidadEntidades++;

        } else {

            throw new PuntosInsuficientesException();
        }
    }
    
    
//    /*
//     * POST: Devuelve el bando al que pertenece el Jugador.
//     */
//    public Bando getBando() {
//
//		return this.bando;
//	} 
    
    
    /* Este metodo CAPAZ HAY QUE BORRARLO.
     * 
     * POST: Indica si el Jugador aún tiene fichas para continuar jugando.
     */
    public boolean sigueJugando() {

        return (this.cantidadEntidades > 0);
    }


    /* 
     * PRE:  ...
     * POST: ...
     */
    public Posicion elegirCasillero(){

        System.out.print("Ingresa fila: ");
        int y = consola.nextInt();

        System.out.print("\nIngresa columna: ");
        int x = consola.nextInt();

        return new Posicion(x,y);
    }
}