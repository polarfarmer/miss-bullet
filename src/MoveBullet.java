public class MoveBullet
{
    private void Common_Bullet(int x, int y,int dir) {
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
