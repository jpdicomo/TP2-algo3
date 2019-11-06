package Modelo.Unidad;



public class PiezaMovible {
    enum MOV_TYPE {
        UP, DOWN, RIGHT, LEFT
    }
    int x;
    public void mover(MOV_TYPE mov){
        if (mov == MOV_TYPE.RIGHT) {
            this.x++;
        }
    }

}
