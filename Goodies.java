
import java.util.ArrayList;

public class Goodies 
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private ArrayList<Rectangle> tank;

    public Goodies(double x, double y)
    {
        this.x = x;
        this.y = y;
        tank = new ArrayList<Rectangle>();
        tank.add(new Rectangle(x,y,12,15,"green"));
        tank.add(new Rectangle(x-8,y,5,15,"white"));
        tank.add(new Rectangle(x+8,y,5,15,"white"));
        tank.add(new Rectangle(x,y-7,3,13,"white"));
    }
    
    public void addTo(GameArena gameArena){
        for(Rectangle rectangle: tank){
            gameArena.addRectangle(rectangle);
        }
    }
    
    public void move(double x, double y){
        this.x = x;
        this.y = y;
        tank.get(0).setXPosition(x);
        tank.get(0).setYPosition(y);
        tank.get(1).setXPosition(x-8);
        tank.get(1).setYPosition(y);
        tank.get(2).setXPosition(x+8);
        tank.get(2).setYPosition(y);
        tank.get(3).setXPosition(x);
        tank.get(3).setYPosition(y-7);
    }
    
    public double getXPosition(){
        return this.x;
    }
    
    public double getYPosition(){
        return this.y;
    }
    
}
