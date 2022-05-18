package Client;

import Server.*;
import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Common.Casilla;
import Common.Constantes;
import Common.Mapa;
import Common.Target;

public class GUI implements Constantes, ActionListener{
    JFrame ventana;
    JButton next;
    Mapa mapa;
    Target target;
    
    public GUI(){

        ventana = new JFrame();
        mapa = new Mapa(this);


        ventana.add(mapa.panelTablero);

        next = new JButton("continuar");
        next.addActionListener(this);
        next.setActionCommand("next");

        ventana.add(next, BorderLayout.SOUTH);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);

        target = new Target();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            mapa.tablero[target.coords[X]][target.coords[Y]].clearTarget();
            target.coords = ((Casilla)e.getSource()).getCoords();
            ((Casilla)e.getSource()).setAsTarget();

            Socket cliente = new Socket("127.0.0.1", 4444);
            ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
            output.writeObject(target);
            output.flush();
            output.close();
            cliente.close();
        
            
        } catch (Exception ex) {
            //TODO: handle exception
        }


    }


}
