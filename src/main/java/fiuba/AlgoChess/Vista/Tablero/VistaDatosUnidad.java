package fiuba.AlgoChess.Vista.Tablero;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaDatosUnidad extends VBox {

	
	public VistaDatosUnidad(Unidad unidad) {

		super();

		Label nombre = new Label(unidad.getClass().getSimpleName());
		nombre.setFont(Font.font("Times New Roman", 28));

		Label vida = new Label("Vida: " + unidad.getVida());
		vida.setFont(Font.font("Times New Roman", 16));

		this.setSpacing(15);
		this.getChildren().add(nombre);
//		this.getChildren().add(); <-- Agregar fotito de la unidad.
		this.getChildren().add(vida);
		// Agregar botoncitos de ataque y movimiento.
	}
}
