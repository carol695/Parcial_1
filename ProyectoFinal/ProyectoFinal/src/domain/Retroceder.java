package domain;

public class Retroceder extends Squares{

    /**
     * Constructor de la clase
     *
     * @param x
     * @param y
     */
    public Retroceder(int x, int y) {
        super(x, y);
    }

    public void accion(Pieces piece){
        piece.movePiece(-5);
    }
}
