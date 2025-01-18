public class Player {
    public int x = 0;
    public int y = 0;
    public int raduis = 30;
    private int speed = 5;
    public boolean dead = false;

    public void Move_Player(int dir) {
        if (dead) {
            return;
        }

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

    void die() {
        dead = true;
    }
}
