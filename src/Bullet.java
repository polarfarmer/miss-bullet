import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Bullet implements ActionListener {
    int x;
    int y;
    int dir;
    int BT;
    private Timer timer;
    int time = 0;

    private void New_Bullet(int bullet_type) {
        Random random = new Random ();
        int i = random.nextInt(4);
        if (bullet_type==1){
            BT = 1;
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
        }else if(bullet_type==2){
            BT = 2;
            if(i == 0 || i == 1){
                x = random.nextInt(98);
                dir = 1;
            }else if(i == 2 || i == 3){
                y = random.nextInt(98);
                dir = 2;
            }
        }
    }

    private void Common_Bullet() {
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
    private void Beam() {
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time += timer.getDelay() / 1000;
    }
}