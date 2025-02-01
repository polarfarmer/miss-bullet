import java.awt.*;
import java.util.Random;

public class Bullet  {
    int x;
    int y;
    Main.Direction dir;
    public boolean dead = false;

    public int radius = 5;
    int speed;
    public Color color;
    Player player = Game.player;

    public Bullet(int type) {
        Random random = new Random ();
        Main.Direction dir = Main.Direction.values()[random.nextInt(Main.Direction.values().length)];

        switch (type) {
            case 0:
                speed = 6;
                color = Color.MAGENTA;
                break;
            case 1:
                speed = 10;
                color = Color.RED;
                radius = 7;
                break;
        }

        if(dir == Main.Direction.UP){
            x = random.nextInt(Game.FrameSizeWidth);
            y = 0;
            this.dir = dir;
        }else if(dir == Main.Direction.DOWN){
            x = random.nextInt(Game.FrameSizeWidth);
            y = Game.FrameSizeHeight;
            this.dir = dir;
        }else if(dir == Main.Direction.LEFT){
            x = 0;
            y = random.nextInt(Game.FrameSizeHeight);
            this.dir = dir;
        }else if(dir == Main.Direction.RIGHT){
            x = Game.FrameSizeWidth;
            y = random.nextInt(Game.FrameSizeHeight);
            this.dir = dir;
        }
    }

    public void Move() {
        if (dead)
            return;

        if(dir == Main.Direction.UP) {
            y += speed;
        }
        else if(dir == Main.Direction.DOWN) {
            y -= speed;
        }
        else if(dir == Main.Direction.LEFT) {
            x += speed;
        }
        else if(dir == Main.Direction.RIGHT) {
            x -= speed;
        }
    }

    public boolean Interact() {
        boolean isInteract = false;
        double distance = Math.sqrt(Math.pow(Game.player.x - x, 2) + Math.pow(Game.player.y - y, 2));

        if (distance <= player.radius + radius) {
            isInteract = true;
        }

        return isInteract;
    }

    public void die() {
        dead = true;
    }
}