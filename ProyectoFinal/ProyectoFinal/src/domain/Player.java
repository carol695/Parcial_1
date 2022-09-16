package domain;

import java.awt.*;

import static domain.Path.x_inicial;
import static domain.Path.y_inicial;

public class Player {

    Pieces[] pieces = new Pieces[4];
    boolean salio = false;


    /**
     *
     * Constructor de la clase
     *
     */
    public Player(String tipoFicha) {
        if(tipoFicha == "Normales"){
            for (int i = 0; i < 4; i++) {
                pieces[i] = new Normales();
            }
        } else if (tipoFicha == "Ventajosas") {
            for (int i = 0; i < 4; i++) {
                pieces[i] = new Ventajosa();
            }
        }
    }

    /**
     * Metodo para dibujar las piezas del jugador
     *
     * @param g
     */
    public void paintComponents(Graphics2D g, int playerNumber){
            for (int j = 0; j < 4; j++) {
                pieces[j].draw(g, x_inicial[playerNumber][j], y_inicial[playerNumber][j], playerNumber); //initialx= es la posición de la primera ficha de cada jugador en la linea vertical; initialy= es la posicion de la primera ficha en la linea horizontal;
            }
    }


    public Pieces getPiece(int piece){
        return pieces[piece];
    }

    public void setPiece(int j, Pieces p){
        pieces[j] = p;
    }

    public boolean gana(){
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if(pieces[i].getCasilla() != 88){
                flag = false;
            }
        }
        return flag;
    }
}
