import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class Casilla extends JButton{

    private int[] coordenadas;

    public Casilla(int posX, int posY){
        coordenadas = new int[2];
        coordenadas[0] = posX;
        coordenadas[1] = posY;

        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(50, 50));
    }
}
