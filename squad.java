import java.util.ArrayList;

public class squad
{
    // instance variables - replace the example below with your own
    private int number;
    private double x;
    private double y;
    private ArrayList<Enemies> list;

    public squad(double x, double y, int n)
    {
        this.x = x;
        this.y = y;
        this.number = n;
        this.list = new ArrayList<Enemies>();
        double e_x = x;
        double e_y = y;
        for(int i = 0; i<number; i++){
            Enemies e = new Enemies(e_x,e_y);
            this.list.add(e);
            e_x += 50;
            //System.out.println(i);
            if (e_x==600){
                e_y += 50;
                e_x = 100;
            }
        }
    }

    public void move(double x, double y){
        double delta_y = this.y - y;
        double delta_x = this.x - x;
        for(Enemies e: list){
            double temp_x = e.getXPosition();
            double temp_y = e.getYPosition();
            e.move(temp_x + delta_x,temp_y + delta_y);
        }
    }
    
    public void removeEnemy(Enemies e, GameArena g){
        for(Rectangle r : e.getAlian()){
            g.removeRectangle(r);
        }
        this.list.remove(e);
    }
    
    public void addTo(GameArena g){
        for(Enemies e: list){
            e.addTo(g); 
        }
    }
    
    public boolean checkCross(double x, double y){
        for(Enemies e: list){
            if(Math.abs(e.getXPosition()-x) < 5 && Math.abs(e.getYPosition()-y)<5){
                return true;
            }
        }
        return false;
    }
    
    public double getXPosition(){
        return this.x;
    }
    
    public double getYPosition(){
        return this.y;
    }
    
     public void setXPosition(double x){
        this.x = x;
    }
    
    public void setYPosition(double y){
        this.y = y;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public  ArrayList<Enemies> getList(){
        return this.list;
    }
}
