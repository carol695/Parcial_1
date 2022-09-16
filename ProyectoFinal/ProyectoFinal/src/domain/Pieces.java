package domain;

import java.awt.*;



public abstract class Pieces {


    int casillaActual, x, y, anchura, altura, posiX, posiY;
    boolean meta = false, asegurada;


    public Pieces() {
        casillaActual = -1;
        anchura = 30;
        altura = 30;
        x = 0;
        y = 0;
    }



    /**
     * Método para dibujar las fichas dentro y fuera de "Casa"
     *
     * @param g
     * @param i
     * @param j
     * @param jugador
     */
    public void draw(Graphics2D g, int i, int j, int jugador) {

        //if que afecta a las casillas que esten en "casa"
        if (casillaActual == -1) {
            int temp1 = 80 + (anchura / 2), temp2 = 50 + (altura / 2);
            x = i;
            y = j;
            //"Colorea" las fichas con el color de su jugador; es decir las fichas del jugador rojo serán rojas y así.
            // 0=rojo; 1=verde; 2=amarillo; 3=blue
            if (jugador == 0) {
                g.setColor(Color.decode("#A2012C")); //jugador rojo
            } else if (jugador == 1) {
                g.setColor(Color.decode("#117D60")); //jugador verde
            } else if (jugador == 2) {
                g.setColor(Color.decode("#F7A814")); //jugador amarillo
            } else if (jugador == 3) {
                g.setColor(Color.decode("#163791")); //jugador azul
            }
            //funciones graficas (no olvidemos que todo esto sigue definiendose si esta dentro de "casa")
            //Pd: he elegido un circulo ya que esto es lo que mas se asemeja a las fichas del parchis
            g.fillOval(temp1 + 5 + (i * anchura), temp2 + 5 + (j * altura), anchura - 10, altura - 10); //rellena el circulo
            g.setStroke(new BasicStroke(2)); //el grueso de las lineas que rodean el círculo
            g.setColor(Color.black); //color que rodea el círculo
            g.drawOval(temp1 + 6 + (i * anchura), temp2 + 6 + (j * altura), anchura - 10, altura - 10); //dibuja el circulo (su tamaño)
        }


            // Esto afecta a las fichas que esten fuera de "casa",
        else{
            int temp1 = 5, temp2 = 5;
            x = Path.ax[jugador][casillaActual];
            y = Path.ay[jugador][casillaActual];
            //If/else que colorea las fichas
            if (jugador == 0) {
                g.setColor(Color.decode("#A2012C")); //jugador rojo
            } else if (jugador == 1) {
                g.setColor(Color.decode("#117D60")); //jugador verde
            } else if (jugador == 2) {
                g.setColor(Color.decode("#F7A814")); //jugador amarillo
            } else if (jugador == 3) {
                g.setColor(Color.decode("#163791")); //jugador azul
            }
            g.fillOval(temp1 + 5 + (x * anchura), temp2 + 5 + (y * altura), anchura - 10, altura - 10); //rellenaba circulo
            g.setStroke(new BasicStroke(2)); //grueso de las lineas del circulo
            g.setColor(Color.BLACK); //color lineas del circulo
            g.drawOval(temp1 + 5 + (x * anchura), temp2 + 5 + (y * altura), anchura - 10, altura - 10); //dibuja circulo

            }
        }


    public int getCasilla(){return casillaActual;}

    public void initiatePiece(){casillaActual = 0;}
    public void checkPoder(int dice, int turnoJugador){}

    public void movePiece(int dice){casillaActual += dice;}

    public void initiateXY(int jugador){
        posiX = Path.ax[jugador][0];
        posiY = Path.ay[jugador][0];
    }

    public void setXY(int jugador, int casillaActual) {
        posiX = Path.ax[jugador][casillaActual];
        posiY = Path.ay[jugador][casillaActual];;
    }

    public int getX(){return posiX;}

    public int getY(){return posiY;}

    public void comida(){casillaActual = -1;}

    public boolean getAsegurada(){return asegurada;}


}
