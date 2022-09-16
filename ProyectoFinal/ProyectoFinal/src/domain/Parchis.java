package domain;
import presentation.*;
import persistance.*;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.Serializable;

import static domain.Path.*;


public class Parchis extends JPanel implements Serializable {

    public static  ParchisIO parchisIO;
    private static final long serialVersionUID = 3370254807680571940L;

    Squares[] tablero;
    Board board;
    boolean iniciado = false, usoDado1, usoDado2;
    int jugadorActual, dado1, dado2;
    int pNumber;
    Player[] players;
    int turnoVentajosa = 1;

    public Parchis(int playersNumber, Board board, String tipoFichas, String tipoTablero)throws parchisException{
        if(playersNumber == 1){
            throw new parchisException(parchisException.NUMERO_JUGADORES);
        }
        jugadorActual = -1;
        this.board = board;
        tablero = new Squares[68];
        dado1 = 0;
        dado2 = 0;
        players = new Player[playersNumber];
        pNumber = playersNumber;
            for (int i = 0; i < playersNumber; i++) {
                players[i] = new Player(tipoFichas);
            }

        tablero = new Squares[68];
        for (int i = 0; i < 68; i++) {
            tablero[i] = new Squares(tableroX[i], tableroY[i]);
            for (int j = 0; j < 12; j++) {
                if (tablero[i].getX() == casillasAseguradasX[j] && tablero[i].getX() == casillasAseguradasY[j]) {
                    tablero[i] = new Seguros(tableroX[i], tableroY[i]);
                }
            }
        }
        // por el momento crea los comodines a mano
        if(tipoTablero == "Comodines"){
            tablero[4] = new Carcel(tableroX[4],tableroY[4]);
            tablero[25] = new Avanzar(tableroX[25],tableroY[25]);
            tablero[44] = new Retroceder(tableroX[44],tableroY[44]);
        }

    }


    /**
     * Metodo
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        board.paintComponent(g);
        for (int i = 0; i < pNumber; i++) {
            players[i].paintComponents((Graphics2D) g, i);
        }

        if (jugadorActual == 0) {
            g.setColor(Color.decode("#A2012C"));
        }

        //texto verde
        else if (jugadorActual == 1) {
            g.setColor(Color.decode("#117D60"));
        }

        //texto amarillo
        else if (jugadorActual == 2) {
            g.setColor(Color.decode("#F7A814"));
        }

        //texto azul
        else if (jugadorActual == 3) {
            g.setColor(Color.decode("#163791"));
        }
        // Dibuja los numeros de los dados

        g.setFont(new Font("sanserif", Font.PLAIN, 30));
        g.drawString(" Dice 1: " + dado1, 580, 290);
        g.drawString(" Dice 2: " + dado2, 580, 320);

    }

    public void rollDices() {
        dado1 = 1 + (int) (Math.random() * 6);
        dado2 = 1 + (int) (Math.random() * 6);
        usoDado1 = false;
        usoDado2 = false;
        turnoVentajosa += 1;
        if(turnoVentajosa== 3){
            turnoVentajosa = 1;
        }
        int siguienteJugador = jugadorActual +1;
        if(siguienteJugador == pNumber){
            jugadorActual = 0;
        }
        else{
            jugadorActual += 1;
        }
    }


    public void play(int pieceNumber){

        Pieces p = players[jugadorActual].getPiece(pieceNumber);

        if(p.getCasilla() == -1 && dado1 != 5 && dado2 != 5){
            JOptionPane.showMessageDialog(null,"No puede salir de casa, ninguno de sus dados es 5, ceda el turno o intente mover otra ficha",":(",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            // Inicia las fichas
            if (dado1 == 5 && !usoDado1 && p.getCasilla() == -1) {
                p.initiateXY(jugadorActual);
                p.initiatePiece();
                accionCasilla(getCasilla(p.getX(), p.getY()), p);
                usoDado1 = true;
                iniciado = true;
            } else if (dado2 == 5 && !usoDado2 && p.getCasilla() == -1) {
                p.initiateXY(jugadorActual);
                p.initiatePiece();
                accionCasilla(getCasilla(p.getX(), p.getY()), p);
                usoDado2 = true;
                iniciado = true;
            }
            // Mueve por fuera de cada casa las fichas
            else if (!usoDado1 && p.getCasilla() != -1) {
                p.movePiece(dado1);
                p.checkPoder(dado1, turnoVentajosa);
                p.setXY(jugadorActual, p.casillaActual);
                accionCasilla(getCasilla(p.getX(), p.getY()), p);
                usoDado1 = true;
            } else if (!usoDado2 && p.getCasilla() != -1) {
                p.movePiece(dado2);
                p.checkPoder(dado2, turnoVentajosa);
                p.setXY(jugadorActual, p.casillaActual);
                accionCasilla(getCasilla(p.getX(), p.getY()), p);
                usoDado2 = true;
            }

            if(players[jugadorActual].gana()){
                JOptionPane.showMessageDialog(null,"Felicitaciones ganaste " ,":)",JOptionPane.INFORMATION_MESSAGE);
            }

            for (int i = 0; i < pNumber; i++) {
                if (jugadorActual != i) {
                    for (int j = 0; j < 4; j++) {
                        Pieces piece2 = players[i].getPiece(j);
                        if (p.getX() == piece2.getX() && p.getY() == piece2.getY() && !piece2.getAsegurada()) {
                            piece2.comida();
                        }
                    }
                }
            }
        }
    }

    public Squares getCasilla(int x, int y){
        Squares casilla = null;
        for (int i = 0; i < 68; i++) {
            if(x == tablero[i].getX() && y == tablero[i].getY()){
                casilla = tablero[i];
            }
        }
        return casilla;
    }

    public void accionCasilla(Squares casilla, Pieces piece){
        casilla.accion(piece);
    }

    public void salvar( File f ) throws parchisException{
        parchisIO.salvarO1(f ,this);
    }


    public Parchis abrir( File f ) throws parchisException{
        return parchisIO.abrirO1(f);
    }

    public void setFicha(int i,int j, Pieces p){
        players[i].setPiece(j, p);
    }

    public void setParchis( Parchis p ){
        for (int i = 0; i < p.pNumber; i++) {
            for (int j = 0; j < 4; j++) {
                Pieces piece = p.players[i].getPiece(j);

                if (piece instanceof Normales){
                    this.setFicha(i, j , piece);
                }

                if (piece instanceof Ventajosa){
                    this.setFicha(i, j , piece);
                }

            }
        }
    }

    public boolean iniciado() {
        return iniciado;
    }
}

