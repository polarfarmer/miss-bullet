import java.util.Random;

public class Bullet  {
    int x;
    int y;
    int dir;
    int BT;
    int speed = 5;

    public Bullet(int bullet_type) {
        Random random = new Random ();
        int i = random.nextInt(4);
        if (bullet_type==1 || bullet_type==2) {
            if (bullet_type==1) {
                BT = 1;
            }
            if (bullet_type==2) {
                BT = 2;
            }
            if(i == 0){ //v
                x = random.nextInt(Game.FrameSizeX);
                y = 0;
                dir = 1;
            }else if(i == 1){ //^
                x = random.nextInt(Game.FrameSizeX);
                y = Game.FrameSizeY;
                dir = 2;
            }else if(i == 2){//>
                x = 0;
                y = random.nextInt(Game.FrameSizeY);
                dir = 3;
            }else if(i == 3){//<
                x = Game.FrameSizeX;
                y = random.nextInt(Game.FrameSizeY);
                dir = 4;
            }
        }else if(bullet_type==3){
            BT = 3;
            if(i == 0 || i == 1){
                x = random.nextInt(Game.FrameSizeX);
                dir = 1;
            }else if(i == 2 || i == 3){
                y = random.nextInt(Game.FrameSizeY);
                dir = 2;
            }
        }
    }

    public void Move() {
        if(dir==1) {
            y += speed;
        }
        if(dir==2) {
            y -= speed;
        }
        if(dir==3) {
            x += speed;
        }
        if(dir==4) {
            x -= speed;
        }
    }

    public void Interact() {

    }
}