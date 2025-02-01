public class Main {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void main(String[] args) {
        new Game();
    }

    public static boolean IsFrameOut(int x, int y) {
        if (x <= 0 || x >= Game.FrameSizeWidth || y <= 0 || y >= Game.FrameSizeHeight) {
            return true;
        }
        return false;
    }
}