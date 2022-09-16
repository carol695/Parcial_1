package domain;

public class Seguros extends Squares{
    /**
     * Constructor de la clase
     *
     * @param x
     * @param y
     */
    public Seguros(int x, int y) {
        super(x, y);
    }

    public void accion(Pieces piece){
        piece.asegurada = true;
    }
}
