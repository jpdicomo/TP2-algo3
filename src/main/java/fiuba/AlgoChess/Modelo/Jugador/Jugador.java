package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

import java.util.ArrayList;


public class Jugador {

	private String nombre;
	private int puntos;
	private ArrayList<Unidad> unidades;
	private final Bando bando;


	public Jugador(String nombre, Bando bando) {

		this.nombre = nombre;
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
		this.bando = bando;
	}


	public void agregarUnidad(Unidad unaUnidad) {

		if (this.puntos >= unaUnidad.getCosto()) {

			this.puntos -= unaUnidad.getCosto();
			this.unidades.add(unaUnidad);

		} else {

			throw new PuntosInsuficientesException();
		}
	}


	private void quitarUnidadesMuertas() {

		for (Unidad unidad : this.unidades) {

			if(!unidad.sigoViva()) {

				this.unidades.remove(unidad);
			}
		}
	}


	public boolean sigueJugando() {

		this.quitarUnidadesMuertas();
		return (!this.unidades.isEmpty());
	}

	
	public void elegirUnidad(Unidad unidad) {

		this.bando.interactuarConUnAliado(unidad);
	}	
//
//		Scanner consola = new Scanner(System.in);
//
//		try{
//			System.out.print("Ingresa fila: ");
//
//			int y = consola.nextInt();
//
//			System.out.print("\nIngresa columna: ");
//
//			int x = consola.nextInt();
//			Posicion pos = new Posicion(x,y);//x,y
//
//			Casillero casilleroSeleccionado = tablero.getCasillero(pos);
//			Unidad unidadSeleccionada = casilleroSeleccionado.getUnidad();
//
//			unidadSeleccionada.interactuarConUnAliado(this.bando);
//
//			return new Posicion(x,y);//x,y
//
//		}catch(DistintoBandoException error) {
//
//			return null;
//		}
//	}



	public int getPuntos() {

		return this.puntos;
	}


	public String getNombre() {

		return this.nombre;
	}

	
	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	
	public ArrayList<Unidad> getUnidades() {
		

		return this.unidades;
	}
}
