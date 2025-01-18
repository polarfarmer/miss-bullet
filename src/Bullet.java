import java.util.Random;

public class Bullet  {
    int x;
    int y;
    int dir;
    int BT;

    public Bullet(int bullet_type) {
        Random random = new Random ();
        int i = random.nextInt(4);
        if (bullet_type==1){
            BT = 1;
            if(i == 0){ //v
                x = random.nextInt(Game.GRID_SIZE);
                y = 0;
                dir = 1;
            }else if(i == 1){ //^
                x = random.nextInt(Game.GRID_SIZE);
                y = Game.GRID_SIZE;
                dir = 2;
            }else if(i == 2){//>
                x = 0;
                y = random.nextInt(Game.GRID_SIZE);
                dir = 3;
            }else if(i == 3){//<
                x = Game.GRID_SIZE;
                y = random.nextInt(Game.GRID_SIZE);
                dir = 4;
            }
        }else if(bullet_type==2){
            BT = 2;
            if(i == 0 || i == 1){
                x = random.nextInt(Game.GRID_SIZE);
                dir = 1;
            }else if(i == 2 || i == 3){
                y = random.nextInt(Game.GRID_SIZE);
                dir = 2;
            }
        }
    }
}