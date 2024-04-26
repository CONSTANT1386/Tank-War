import java.util.*;

/**
 * Write a description of class Enemies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemies
{
    private double x;
    private double y;
    private ArrayList<Rectangle> alien;

    /**
     * Constructor for objects of class Goodie
     */
    public Enemies(double x, double y)
    {
        this.x = x;
        this.y = y;
        alien = new ArrayList<Rectangle>();
        alien.add(new Rectangle(x, y, 15, 6, "blue"));
        alien.add(new Rectangle(x-4, y, 2, 3, "white"));
        alien.add(new Rectangle(x+4, y, 2, 3, "white"));
        alien.add(new Rectangle(x-2, y-4, 3, 3, "blue"));
        alien.add(new Rectangle(x+2, y-4, 3, 3, "blue"));
        alien.add(new Rectangle(x-7, y+3, 5, 7, "blue"));
        alien.add(new Rectangle(x+7, y+3, 5, 7, "blue"));
    }
    
    public void addTo(GameArena gameArena) {
        for (Rectangle rectangle: alien) {
            gameArena.addRectangle(rectangle);
        }
    }
    
    public void move(double x, double y) {
        this.x = x;
        this.y = y;
        alien.get(0).setXPosition(x);
        alien.get(0).setYPosition(y);
        alien.get(1).setXPosition(x-4);
        alien.get(1).setYPosition(y);
        alien.get(2).setXPosition(x+4);
        alien.get(2).setYPosition(y);
        alien.get(3).setXPosition(x-2);
        alien.get(3).setYPosition(y-4);
        alien.get(4).setXPosition(x+2);
        alien.get(4).setYPosition(y-4);
        alien.get(5).setXPosition(x-7);
        alien.get(5).setYPosition(y+3);
        alien.get(6).setXPosition(x+7);
        alien.get(6).setYPosition(y+3);
    }
    
    public double getXPosition() {
        return x;
    }
    
    public double getYPosition() {
        return y;
    }
    
    public ArrayList<Rectangle> getAlian(){
        return this.alien;
    }

}
