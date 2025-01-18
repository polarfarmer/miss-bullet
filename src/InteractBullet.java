public class InteractBullet
{
    private int interact_Bullet(int x, int y,int dir,int bullet) {
        if (bullet==1 || bullet == 2){ // 기본 탄막과 큰 탄막
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

        return 0;
    }
}
