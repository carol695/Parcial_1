package domain;

public class Ventajosa extends Pieces {


    public Ventajosa() {
        super();
        casillaActual = -1;
    }


    /**
     * Metodo
     *
     * @param
     */
    public void checkPoder(int dice, int turnoJugador){
        if(dice == 3){
            casillaActual += 3;
        }
        else if(turnoJugador == 2){
            casillaActual += 3;
        }
    }
}
