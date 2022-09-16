package domain;
import java.awt.*;

public class Squares {
    int x, y;
    boolean seguro;

    /**
     * Constructor de la clase
     *
     * @param x
     * @param y
     */
    public Squares(int x, int y) {
        this.x = x;
        this.y = y;
        seguro = false;
    }

    public void accion(Pieces piece){
        piece.asegurada = false;
    };

    public int getX(){return x;}

    public int getY(){return y;}



}
