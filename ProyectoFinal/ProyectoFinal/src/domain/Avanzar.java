package domain;

public class Avanzar extends Squares{
    /**
     * Constructor de la clase
     *
     * @param x
     * @param y
     */
    public Avanzar(int x, int y) {
        super(x, y);
    }

    public void accion(Pieces piece){
        piece.movePiece(5);
    }
}
