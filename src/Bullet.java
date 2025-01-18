import java.util.Random;

public class Bullet  {
    int x;
    int y;
    int dir;
    int BT;

    private void New_Bullet(int bullet_type) {
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
        }else if(bullet_type==3){
            BT = 3;
            if(i == 0 || i == 1){
                x = random.nextInt(98);
                dir = 1;
            }else if(i == 2 || i == 3){
                y = random.nextInt(98);
                dir = 2;
            }
        }
    }
}