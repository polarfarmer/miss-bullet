import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteractBullet implements ActionListener {
    private Timer timer;
    private boolean damage = false;
    private void interact_Bullet(int x, int y,int dir,int bullet) {
        if (bullet==1 || bullet == 2){ // 기본 탄막과 큰 탄막
            damage = true;
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
        if (bullet==3){ //빔
            timer = new Timer(1000,this);
            timer.start();
            if(dir==1) {
                 y=1000; //전체 라인
            }
            if(dir==2) {
                x=1000;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        damage = true;
    }
}
