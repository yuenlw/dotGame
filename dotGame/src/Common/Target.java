package Common;

import java.io.Serializable;

public class Target implements Serializable, Constantes{

    public int[] coords;

    public Target(){
        coords = new int[2];
        coords[X] = 0;
        coords[Y] = 0;
    }
    
}
