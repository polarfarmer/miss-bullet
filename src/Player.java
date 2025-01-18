public class Player {
    public int x = 0;
    public int y = 0;
    public int raduis = 5;
    private int speed = 5;

    public void Move_Player(int dir) {
        if(dir==1) {
            y -= speed;
        }
        else if(dir==2) {
            y += speed;
        }
        else if(dir==3) {
            x += speed;
        }
        else if(dir==4) {
            x -= speed;
        }
    }
}
