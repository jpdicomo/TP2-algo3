package fiuba.AlgoChess.Vista.Juego.Handlers.CambioEscena;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonContinuarHandler implements EventHandler<ActionEvent> {
    private Stage escenario;
    private Scene escenaTablero;

    public BotonContinuarHandler(Stage escenario, Scene escenaTablero){
        this.escenario = escenario;
        this.escenaTablero = escenaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.escenario.setScene(this.escenaTablero);
    }
}
