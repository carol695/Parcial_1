package presentation;

import domain.parchisException;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{

    int x, y;
    int anchura, altura;
    String player1, player2, player3, player4, tipoTablero;

    public Board(String player1, String player2,String player3,String player4, String tipoTablero){

        this.tipoTablero = tipoTablero;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;

        x = 5;
        y = 5;
        anchura = 30;
        altura = 30;

    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.decode("#F6F7F8")); //color de fondo del TABLERO
        g.fillRect(x, y, 30 * anchura, 20 * altura); //lo que dibuja ya que son las coordenadas del TABLERO
        super.paintComponent(g);

        //dibuja la parte cuadrada que rodea la casilla
        for (int i = 0; i < 8; i++) {
            //casilla roja
            g.setColor(Color.decode("#A2012C"));
            g.fillRect(x + (i * anchura), y, anchura, altura); //barra de arriba
            g.fillRect(x, y + (i * altura), anchura, altura); //barra izquierda
            g.fillRect(x + (i * anchura), y + (7 * altura), anchura, altura); //barra de abajo
            g.fillRect(x + (7 * anchura), y + (i * altura), anchura, altura); //barra derecha

            //casilla verde
            g.setColor(Color.decode("#117D60"));
            g.fillRect(x + ((i + 11) * anchura), y, anchura, altura); //barra de arriba
            g.fillRect(x + (11 * anchura), y + (i * altura), anchura, altura); //barra izquierda
            g.fillRect(x + ((i + 11) * anchura), y + (7 * altura), anchura, altura); //barra de abajo
            g.fillRect(x + (18 * anchura), y + (i * altura), anchura, altura); //barra derecha

            //casilla amarilla
            g.setColor(Color.decode("#F7A814"));
            g.fillRect(x + ((i + 11) * anchura), y + (11 * altura), anchura, altura); //barra de arriba
            g.fillRect(x + (11 * anchura), y + ((i + 11) * altura), anchura, altura); //barra izquierda
            g.fillRect(x + ((i + 11) * anchura), y + (18 * altura), anchura, altura); //barra de abajo
            g.fillRect(x + (18 * anchura), y + ((i + 11) * altura), anchura, altura); //barra derecha

            //casilla azul
            g.setColor(Color.decode("#163791"));
            g.fillRect(x + (i * anchura), y + (11 * altura), anchura, altura); //barra de arriba
            g.fillRect(x, y + ((i + 11) * altura), anchura, altura); //barra izquierda
            g.fillRect(x + (i * anchura), y + (18 * altura), anchura, altura); //barra de abajo
            g.fillRect(x + (7 * anchura), y + ((i + 11) * altura), anchura, altura); //barra derecha
        }

        //Llena el interior de las casas
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                //interior casa roja
                g.setColor(Color.decode("#df3f48"));
                g.fillRect(x + (i * anchura), y + (j * altura), anchura, altura);
            }
        }

        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                //interior azul
                g.setColor(Color.decode("#4876cb"));
                g.fillRect(x + ( + i * anchura), y + ((11+j) * altura), anchura, altura);
            }
        }

        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                //interior verde
                g.setColor(Color.decode("#36c981"));
                g.fillRect(x + ((11 + i) * anchura), y + (j * altura), anchura, altura);
            }
        }

        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                //interior amarillo
                g.setColor(Color.decode("#fac96d"));
                g.fillRect(x + ((11 + i) * anchura), y + ((11+j) * altura), anchura, altura);
            }
        }


        //dibuja la fila que hay para llegar al final
        for (int i = 0; i < 8; i++) {
            //fila final roja
            g.setColor(Color.decode("#A2012C"));
            g.fillRect(x + (i * anchura), y + (9 * altura), anchura, altura); //esto hace que se pinten esos cuadrados y no otros

            //fila final amarilla
            g.setColor(Color.decode("#F7A814"));
            g.fillRect(x + ((11 + i) * anchura), y + (9 * altura), anchura, altura);

            //fila final verde
            g.setColor(Color.decode("#117D60"));
            g.fillRect(x + (9 * anchura), y + (i * altura), anchura, altura);

            //fila final azul
            g.setColor(Color.decode("#163791"));
            g.fillRect(x + ((9) * anchura), y + ((11 + i) * altura), anchura, altura);
        }

        //casilla del principio ROJA
        g.setColor(Color.decode("#A2012C"));
        g.fillRect(x + (8 * anchura), y + (4 * altura), anchura, altura);

        //casilla del principio AMARILLA
        g.setColor(Color.decode("#F7A814"));
        g.fillRect(x + ((10) * anchura), y + (14 * altura), anchura, altura);

        //casilla del principio VERDE
        g.setColor(Color.decode("#117D60"));
        g.fillRect(x + (14 * anchura), y + (8 * altura), anchura, altura);

        //casilla del principio AZUL
        g.setColor(Color.decode("#163791"));
        g.fillRect(x + ((4) * anchura), y + (10 * altura), anchura, altura);


        //casilla final ROJA
        g.setColor(Color.decode("#A2012C"));
        int xpoints0[] = {x + (8 * anchura), x + (8 * anchura), x + 17 + (9 * anchura)};
        int ypoints0[] = {y + (8 * altura), y + (11 * altura), y + 17 + (9 * anchura)};
        int npoints = 3;
        g.fillPolygon(xpoints0, ypoints0, npoints);

        //casilla final AMARILLA
        g.setColor(Color.decode("#F7A814"));
        int xpoints1[] = {x + (11 * anchura), x + (11 * anchura), x + 17 + (9 * anchura)};
        int ypoints1[] = {y + (8 * altura), y + (11 * altura), y + 17 + (9 * anchura)};
        int npoints1 = 3;
        g.fillPolygon(xpoints1, ypoints1, npoints1);

        //casilla final VERDE
        g.setColor(Color.decode("#117D60"));
        int xpoints2[] = {x + (8 * anchura), x + (11 * anchura), x + 17 + (9 * anchura)};
        int ypoints2[] = {y + (8 * altura), y + (8 * altura), y + 17 + (9 * anchura)};
        int npoints2 = 3;
        g.fillPolygon(xpoints2, ypoints2, npoints2);

        //casilla final AZUL
        g.setColor(Color.decode("#163791"));
        int[] xpoints3 = {x + (8 * anchura), x + (11 * anchura), x + 17 + (9 * anchura)};
        int[] ypoints3 = {y + (11 * altura), y + (11 * altura), y + 17 + (9 * anchura)};
        int npoints3 = 3;
        g.fillPolygon(xpoints3, ypoints3, npoints3);

        //dibuja los seguros

        g.setColor(Color.decode("#a6a6a6"));
        g.fillRect(x + (0 * anchura), y + (9 * altura), anchura, altura);
        g.fillRect(x + (4 * anchura), y + (8 * altura), anchura, altura);
        g.fillRect(x + (9 * anchura), y + (0 * altura), anchura, altura);
        g.fillRect(x + (10 * anchura), y + (4 * altura), anchura, altura);
        g.fillRect(x + (18 * anchura), y + (9 * altura), anchura, altura);
        g.fillRect(x + (14 * anchura), y + (10 * altura), anchura, altura);
        g.fillRect(x + (9 * anchura), y + (18 * altura), anchura, altura);
        g.fillRect(x + (8 * anchura), y + (14 * altura), anchura, altura);

        //Comodines por el momento no aleatorios
        if(tipoTablero == "Comodines") {
            g.setColor(Color.decode("#FE6F5E"));
            g.fillRect(x + ((7) * anchura), y + (8 * altura), anchura, altura);

            g.setColor(Color.decode("#7BB661"));
            g.fillRect(x + ((8) * anchura), y + (15 * altura), anchura, altura);

            g.setColor(Color.decode("#800020"));
            g.fillRect(x + ((17) * anchura), y + (10 * altura), anchura, altura);
        }


        //toda la linea negra que pinta el tablero
        // g.setStroke(new BasicStroke(2));
        g.setColor(Color.decode("#030308"));


        for (int i = 0; i < 3; i++) {
            //for usado para pintar las lineas de cada casilla del tablero
            for (int j = 0; j < 8; j++) {
                g.drawRect(x + ((i + 8) * anchura), y + (j * altura), anchura, altura); //casillas del tablero de la parte verde
                g.drawRect(x + ((j) * anchura), y + ((i + 8) * altura), anchura, altura); //casillas del tablero de la parte roja
                g.drawRect(x + ((i + 8) * anchura), y + ((j + 11) * altura), anchura, altura); //casillas del tablero de la parte azul
                g.drawRect(x + ((j + 11) * anchura), y + ((i + 8) * altura), anchura, altura); //casillas del tablero de la parte amarilla
            }
        }
        //recta del cuadrado interior de la "casa" de cada jugador
        g.drawRect(x + ((1) * anchura), y + (1 * altura), 6 * anchura, 6 * altura); //rojo
        g.drawRect(x + ((12) * anchura), y + (1 * altura), 6 * anchura, 6 * altura); //verde
        g.drawRect(x + ((1) * anchura), y + (12 * altura), 6 * anchura, 6 * altura); //azul
        g.drawRect(x + ((12) * anchura), y + (12 * altura), 6 * anchura, 6 * altura); //amarillo
        g.drawRect(x, y, 19 * anchura, 19 * altura); //cuadrado exterior del tablero

        //for(int i=0;i<2;i++) {
        //	for(int j=0;j<2;j++) {
        //    	g.drawRect(temp1+(2*i*width),temp2+(2*j*height), width, height);
        //    	g.drawRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+9*height, width, height);
        //    	g.drawRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+0*height, width, height);
        //    	g.drawRect(temp1+(2*i*width)+0*width,temp2+(2*j*height)+9*height, width, height);
        //	}
        //}
        //TRIANGULO de la casilla final
        g.drawPolygon(xpoints0, ypoints0, npoints);
        g.drawPolygon(xpoints1, ypoints1, npoints1);
        g.drawPolygon(xpoints2, ypoints2, npoints2);
        g.drawPolygon(xpoints3, ypoints3, npoints3);





        //fuente y tamaño de la letra
            g.setFont(new Font("sanserif", Font.PLAIN, 20));
            g.drawString(player1, 15, 25);
            g.drawString(player2, 500, 25);
            g.drawString(player3, 15, 565);
            g.drawString(player4, 500, 565);



    }


}




