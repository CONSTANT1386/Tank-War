

public class Bullet extends Rectangle
{
    // instance variables - replace the example below with your own
    
    public Bullet(double x, double y)
    {
        super(x,y,8,12,"red");
    }

    public void addTo(GameArena g){
        g.addRectangle(this);
    }
    
    public void move(double delta_y){
        super.setYPosition(super.getYPosition()-delta_y);
        //System.out.println(x);
        //System.out.println(y);
    }
    
}
