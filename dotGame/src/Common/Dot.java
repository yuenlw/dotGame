package Common;
public class Dot implements Constantes{
    
    public Target target;
    public int[] currentPosition;
    public int[] lastPosition;

    public Dot(){
        currentPosition = new int[2];
        currentPosition[X] = 0;
        currentPosition[Y] = 0;

        lastPosition = new int[2];
        lastPosition[X] = 0;
        lastPosition[Y] = 0;

        target = new Target();
    }


    public void move(){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
    
        if(target[X] != currentPosition[X]){
            currentPosition[X] += (target[X]-currentPosition[X])/Math.abs(target[X]-currentPosition[X]);
        }
        if(target[Y] != currentPosition[Y]){
            currentPosition[Y] += (target[Y]-currentPosition[Y])/Math.abs(target[Y]-currentPosition[Y]);
        }
    }

}
