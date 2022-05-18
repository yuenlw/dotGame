package Common;
import java.io.Serializable;

public class Target implements Serializable, Constantes{
    
    public int [] coords;

    public Target(){
        coords = new int[2];
        coords[X] = 0;
        coords[Y] = 0;
    }

    public void setCoords(int x, int y){
        coords[X] = x;
        coords[Y] = y;
    }

    public String toString(){
        return "coords: (" + coords[X] + ", " + coords[Y] + ")";  
    }
    
}
