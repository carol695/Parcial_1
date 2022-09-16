package domain;

public class Carcel extends Squares{
    /**
     * Constructor de la clase
     *
     * @param x
     * @param y
     */
    public Carcel(int x, int y) {
        super(x, y);
    }

    public void accion(Pieces piece){
        piece.casillaActual = -1;
    }
}
