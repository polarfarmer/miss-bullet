public class Player {
    public int x = Game.FrameSizeWidth / 2;
    public int y = Game.FrameSizeHeight / 2;
    public int radius = 7;
    private int speed = 8;
    public boolean dead = false;

    public void Move_Player(Main.Direction dir) {
        if (dead) {
            return;
        }

        if(dir == Main.Direction.UP && !Main.IsFrameOut(x, y - speed)) {
            y -= speed;
        }
        else if(dir == Main.Direction.DOWN && !Main.IsFrameOut(x, y + speed)) {
            y += speed;
        }
        else if(dir == Main.Direction.LEFT && !Main.IsFrameOut(x - speed, y)) {
            x -= speed;
        }
        else if(dir == Main.Direction.RIGHT && !Main.IsFrameOut(x + speed, y)) {
            x += speed;
        }

    }

    void die() {
        dead = true;
    }
}
