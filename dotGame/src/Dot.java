public class Dot implements Constantes{
    
    int[] target;
    int[] currentPosition;

    public Dot(){
        currentPosition = new int[2];
        currentPosition[X] = 0;
        currentPosition[Y] = 0;

        target = new int[2];
        target[X] = 0;
        target[Y] = 0;
    }


    public void move(){
        if(target[X] != currentPosition[X]){
            currentPosition[X] += (target[X]-currentPosition[X])/Math.abs(target[X]-currentPosition[X]);
        }
        if(target[Y] != currentPosition[Y]){
            currentPosition[Y] += (target[Y]-currentPosition[Y])/Math.abs(target[Y]-currentPosition[Y]);
        }
    }

}
