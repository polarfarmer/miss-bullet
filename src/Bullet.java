import java.util.Random;

public class Bullet {
    int x;
    int y;
    int dir;

    private void New_Bullet() {
        Random random = new Random ();
        int i = random.nextInt(4);
        if(i == 0){ //v
            x = random.nextInt(98);
            y = 0;
            dir = 1;
        }else if(i == 1){ //^
            x = random.nextInt(98);
            y = 98;
            dir = 2;
        }else if(i == 2){//>
            x = 0;
            y = random.nextInt(98);
            dir = 3;
        }else if(i == 3){//<
            x = 98;
            y = random.nextInt(98);
            dir = 4;
        }
    }

    private void Move_Bullet() {
        if(dir==1) {
            y++;
        }
        if(dir==2) {
            y--;
        }
        if(dir==3) {
            x++;
        }
        if(dir==4) {
            x--;
        }
    }
}