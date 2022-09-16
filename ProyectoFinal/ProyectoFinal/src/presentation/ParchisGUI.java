package presentation;

import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ParchisGUI extends JFrame{

    private Board board;
    private Parchis parchis;
    private JButton buttonRoll , buttonMove1, buttonMove2, buttonMove3, buttonMove4;
    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem salve, abra, cerrar;
    private JFileChooser fileChooser;





    private ParchisGUI() throws parchisException {
            prepareElements();
    }

    public static void main(String[] args) throws parchisException {
        ParchisGUI par = new ParchisGUI();
        par.setVisible(true);
    }


    private void prepareElements() throws parchisException {



        JTextField playersNumber = new JTextField(5);
        JTextField player1 = new JTextField(5);
        JTextField player2 = new JTextField(5);
        JTextField player3 = new JTextField(5);
        JTextField player4 = new JTextField(5);


        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Players Number:"));
        myPanel.add(playersNumber);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Player 1:"));
        myPanel.add(player1);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Player 2:"));
        myPanel.add(player2);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Player 3:"));
        myPanel.add(player3);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Player 4:"));
        myPanel.add(player4);

        JOptionPane.showConfirmDialog(null, myPanel,
                "Introduzca numero de jugadores y sus nombres", JOptionPane.OK_CANCEL_OPTION);

        int nPlayer = Integer.parseInt(playersNumber.getText());
        String p1 = player1.getText();
        String p2 = player2.getText();
        String p3 = player3.getText();
        String p4 = player4.getText();

        if(nPlayer < 2 || nPlayer > 4){
            throw new parchisException(parchisException.NUMERO_JUGADORES);
        }

        String[] tipoTablero = {"Normal", "Comodines"};

        String getTablero = (String) JOptionPane.showInputDialog(
                null,
                "Tipo de tablero?",
                "Eliga Tablero",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipoTablero,
                tipoTablero[0]);

        String[] tipoFichas = {"Normales", "Ventajosas"};

        String getFichas = (String) JOptionPane.showInputDialog(
                null,
                "Tipo de fichas?",
                "Eliga fichas",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipoFichas,
                tipoFichas[0]);


        board = new Board(p1, p2, p3, p4, getTablero);

        parchis = new Parchis(nPlayer, board, getFichas, getTablero);

        setLayout(new BorderLayout());
        add(parchis, BorderLayout.CENTER);
        setSize(820, 650);
        setTitle("PARCHÍS");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonRoll=new JButton("Roll Dices");
        add(buttonRoll, BorderLayout.SOUTH);



        JPanel complementos = new JPanel();
        complementos.setLayout(new BoxLayout(complementos, BoxLayout.Y_AXIS));
        complementos.setBorder(BorderFactory.createTitledBorder("Movements"));




        buttonMove1 = new JButton("Piece 1");
        buttonMove2 = new JButton("Piece 2");
        buttonMove3 = new JButton("Piece 3");
        buttonMove4 = new JButton("Piece 4");

        complementos.add(Box.createVerticalStrut(200));
        complementos.add(buttonMove1);
        complementos.add(Box.createVerticalStrut(20));
        complementos.add(buttonMove2);
        complementos.add(Box.createVerticalStrut(20));
        complementos.add(buttonMove3);
        complementos.add(Box.createVerticalStrut(20));
        complementos.add(buttonMove4);
        complementos.add(Box.createVerticalStrut(20));

        add(complementos, BorderLayout.EAST);

        fileChooser = new JFileChooser();

        prepareElementsMenu();
        prepareActions();

    }

    public void prepareElementsMenu(){
        menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");

        salve = new JMenuItem("Salvar") ;
        abra =  new JMenuItem("Abrir") ;
        cerrar = new JMenuItem("Cerrar");

        archivo.add(salve);
        archivo.add(abra);
        archivo.add(cerrar);

        menuBar.add(archivo);

        setJMenuBar(menuBar);
    }

    private void prepareActions(){
        buttonRoll.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        buttonDicesAction();
                    }
                });

        buttonMove1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        try {
                            buttonPlayAction(0);
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(null,"Error moving","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
        buttonMove2.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        try {
                            buttonPlayAction(1);
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(null,"Error moving","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
        buttonMove3.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        try {
                            buttonPlayAction(2);
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(null,"Error moving","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
        buttonMove4.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        try {
                            buttonPlayAction(3);
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(null,"Error moving","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
        prepareAccionesMenu();
    }


    public void prepareAccionesMenu() {

        cerrar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        accionCerrar();
                    }
                });

        salve.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionSalvar();
                        } catch (parchisException a) {
                            JOptionPane.showMessageDialog(null, a.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                });


        abra.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionAbrir();
                        } catch (parchisException a) {
                            JOptionPane.showMessageDialog(null, a.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                });
    }



    private void buttonDicesAction(){
        parchis.rollDices();
        repaint();
    }

    private void buttonPlayAction(int piece) throws parchisException {
            parchis.play(piece);
            repaint();
    }

    public void accionSalvar() throws parchisException{
        fileChooser.setVisible(true );
        fileChooser.setFileFilter( new FileNameExtensionFilter("Extension File .dat","dat"));
        int answ = fileChooser.showSaveDialog(this);

        if( answ == fileChooser.APPROVE_OPTION) {
            if (parchis.iniciado()) {
                parchis.salvar(fileChooser.getSelectedFile());
            } else {
                throw new parchisException("Primero debe iniciar el juego");
            }
        }
    }

    public void accionAbrir() throws parchisException{
        fileChooser.setVisible(true );
        fileChooser.setFileFilter( new FileNameExtensionFilter("Extension archivo .dat","dat"));
        int answ = fileChooser.showOpenDialog(this);

        if( answ == fileChooser.APPROVE_OPTION){
            parchis.setParchis( parchis.abrir(fileChooser.getSelectedFile()) );
            parchis.repaint();
        }
    }

    public void accionCerrar() {
        System.exit(0);
    }

}
