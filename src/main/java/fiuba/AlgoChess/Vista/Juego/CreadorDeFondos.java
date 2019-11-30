package fiuba.AlgoChess.Vista.Juego;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/*
 * Devuelve fondos ya configurados
 */
public class CreadorDeFondos {

	public Background crearFondo(String direccion) {
		
		Image imagenDeFondo = null;
		
		try {
			
			imagenDeFondo = new Image(new FileInputStream(direccion));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Background fondo = new Background(new BackgroundImage(imagenDeFondo,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(800, 600, false, false, false, false)));
		
		return fondo;
	}
}
