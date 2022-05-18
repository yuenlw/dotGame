package Common;
import java.awt.Dimension;

import javax.swing.JButton;

public class Casilla extends JButton implements Constantes{

    private int[] coordenadas;

    public Casilla(int posX, int posY){
        coordenadas = new int[2];
        coordenadas[X] = posX;
        coordenadas[Y] = posY;

        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(CASILLA_WIDTH, CASILLA_HEIGHT));
    }

    public int[] getCoords(){
        return coordenadas;
    }

    public void setAsTarget(){
        setBackground(TARGET_COLOR);
    }

    public void clearTarget(){
        setBackground(BG_COLOR);
    }

    public void setAsDot(){
        setBackground(DOT_COLOR);
    }

    public void clearDot(){
        setBackground(BG_COLOR);
    }

}
