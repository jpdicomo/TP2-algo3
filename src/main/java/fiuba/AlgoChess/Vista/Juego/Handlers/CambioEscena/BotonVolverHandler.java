package fiuba.AlgoChess.Vista.Juego.Handlers.CambioEscena;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverHandler implements EventHandler<ActionEvent> {
    private Stage escenario;
    private Scene escenaPrincipal;

    public BotonVolverHandler(Stage escenario, Scene escenaPrincipal){
        this.escenario = escenario;
        this.escenaPrincipal = escenaPrincipal;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.escenario.setScene(this.escenaPrincipal);
    }
}
