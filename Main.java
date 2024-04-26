import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GameArena g=new GameArena(800,600);
        Goodies player = new Goodies(400,500);
        squad s = new squad(100,100,30);

        double e_x = 100;
        double e_y = 100;
        double p_x = 400;
        double p_y = 500;
        ArrayList<Bullet> BL = new ArrayList<Bullet>();
        double bullet_speed = 2;

        player.addTo(g);
        s.addTo(g);

        while(true){
            if(e_y<0){
                s = new squad(100,100,30);
                s.addTo(g);
            }
            e_x = s.getXPosition();
            e_y = s.getYPosition();
            p_x = player.getXPosition();
            p_y = player.getYPosition();
            e_y -= 0.5;

            //System.out.println(1);
            //int bulletNum = BL.size();
            for(int j = 0; j<BL.size(); j++){
                Bullet b = BL.get(j);
                b.move(bullet_speed);
                double x = b.getXPosition();
                double y = b.getYPosition();
                ArrayList<Enemies> enemyList = s.getList();
                for(int i=0; i<enemyList.size(); i++){
                    Enemies e = enemyList.get(i);
                    if(Math.abs(e.getXPosition()-x) < 5 && Math.abs(e.getYPosition()-y)<5){
                        s.removeEnemy(e,g);
                        g.removeRectangle(b);
                        BL.remove(j);
                    }
                }
                // System.out.println(B);
                // System.out.println(B.getR());
            }
            //System.out.println(p_x);
            if(g.upPressed()){
                p_y -= 3;
            }
            if(g.downPressed()){
                p_y += 3;
            }
            if(g.leftPressed()){
                p_x -= 3;
            }
            if(g.rightPressed()){
                p_x += 3;
            }
            if(g.FPressed()){
                Bullet B = new Bullet(p_x, p_y);
                B.addTo(g);
                BL.add(B);
            }
            
            if(s.checkCross(p_x,p_y)){
                g.throwMessage("Failed","Game Over!");
                break;
            }
            player.move(p_x,p_y);
            //System.out.println(p_x);

            s.move(e_x, e_y);
            g.pause();
        }
    }
}
