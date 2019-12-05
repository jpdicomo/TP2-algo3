package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Controlador.Alertas.AlertaHayUnidadesSinColocar;
import fiuba.AlgoChess.Vista.Juego.Main;
import fiuba.AlgoChess.Vista.Juego.Colocacion.CajaDeUnidadesVertical;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonCambiarAEscenaDeLucha implements EventHandler<ActionEvent> {

	private Main main;
	private int jugadorInicial;
	private Media sonido;
	private MediaPlayer reproductor;
	private CajaDeUnidadesVertical cajaUnidades;

	public BotonCambiarAEscenaDeLucha(Main main, CajaDeUnidadesVertical cajaUnidades) {

		this.main = main;
		this.cajaUnidades = cajaUnidades;
		this.jugadorInicial = (int) (Math.random() * 2 + 1);
	}

	@Override
	public void handle(ActionEvent event) {

		if (this.hayUnidadesSinColocar()) {

			AlertaHayUnidadesSinColocar alertaUnidadesSinColocar = new AlertaHayUnidadesSinColocar();
			alertaUnidadesSinColocar.mostrarAlerta();

		} else {

			this.reproducirSonido();
			this.main.cambiarEscenaA(this.main.escenaDeLucha(this.jugadorInicial));
		}
	}

	private boolean hayUnidadesSinColocar() {

		boolean haySoldadosSinColocar = this.cajaUnidades.getUnidades("Soldado").isEmpty();
		boolean hayCuranderosSinColocar = this.cajaUnidades.getUnidades("Curandero").isEmpty();
		boolean hayJinetesSinColocar = this.cajaUnidades.getUnidades("Jinete").isEmpty();
		boolean hayCatapultasSinColocar = this.cajaUnidades.getUnidades("Catapulta").isEmpty();

		return (haySoldadosSinColocar && hayCuranderosSinColocar && hayJinetesSinColocar && hayCatapultasSinColocar);
	}

	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
