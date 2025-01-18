public class Player {
    public int x = Game.FrameSizeX / 2;
    public int y = Game.FrameSizeY / 2;
    public int raduis = 5;
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
//        dead = true;
    }
}
