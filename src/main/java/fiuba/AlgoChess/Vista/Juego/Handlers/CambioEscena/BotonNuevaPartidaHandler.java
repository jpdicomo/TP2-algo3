package fiuba.AlgoChess.Vista.Juego.Handlers.CambioEscena;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonNuevaPartidaHandler implements EventHandler<ActionEvent> {
    private Stage escenario;
    private Scene escenaCreacionPersonajes;
    public BotonNuevaPartidaHandler(Stage escenario, Scene escenaCreacionPersonajes){
        this.escenario = escenario;
        this.escenaCreacionPersonajes = escenaCreacionPersonajes;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.escenario.setScene(this.escenaCreacionPersonajes);
    }
}
