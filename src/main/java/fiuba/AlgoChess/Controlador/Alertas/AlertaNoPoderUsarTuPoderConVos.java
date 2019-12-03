package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaNoPoderUsarTuPoderConVos extends Alert {
	
    public AlertaNoPoderUsarTuPoderConVos() {
    	
        super(AlertType.INFORMATION);
        this.setTitle("¡ATAQUE INVALIDO!");
        this.setContentText("Una unidad no puede usar su poder consigo misma");
    }
}
