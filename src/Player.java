public class Player {
    public int x = 0;
    public int y = 0;

    public void Move_Player(int dir) {
        if(dir==1) {
            y++;
        }
        else if(dir==2) {
            y--;
        }
        else if(dir==3) {
            x++;
        }
        else if(dir==4) {
            x--;
        }
    }
}
