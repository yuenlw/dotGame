package Client;
import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Common.Casilla;
import Common.Constantes;
import Common.Dot;
import Common.Mapa;
import Common.Target;

import java.net.*;
import java.io.*;

public class GUI implements ActionListener, Constantes{

    JFrame ventana;
    JButton next;
    Mapa mapa;
    Target target;

    Dot dot;

    Socket client;
    ObjectOutputStream output;
    
    public GUI(){

        ventana = new JFrame();
        mapa = new Mapa(this);


        ventana.add(mapa.panelTablero);

        next = new JButton("continuar");
        next.setActionCommand("next");

        ventana.add(next, BorderLayout.SOUTH);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);

        target = new Target();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mapa.tablero[target.coords[X]][target.coords[Y]].clearTarget();
        ((Casilla)e.getSource()).setAsTarget();
        target.coords = ((Casilla)e.getSource()).getCoords();

        try {
            client = new Socket("127.0.0.1", 4444);
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(target);
            output.flush();
            output.close();
            client.close();
        } catch (Exception ex) {
            //TODO: handle exception
        }
    }

    public void moveDot(){
        mapa.tablero[dot.lastPosition[X]][dot.lastPosition[Y]].clearDot();
        mapa.tablero[dot.currentPosition[X]][dot.currentPosition[Y]].setAsDot();
    
    }

    public void run(){
        while (true){
            dot.move();
            moveDot();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }

}