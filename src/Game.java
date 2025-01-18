import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JFrame implements ActionListener {
    private int GRID_SIZE = 99;
    private ArrayList<Bullet> bullets;
    private Player player;
    private Timer timer;
    private int score = 0;
    public Game() {
        player = new Player();
        setSize(400, 300);
        setVisible(true);
        timer = new Timer(1000,this);
        timer.start();

        addKeyListener(new TAdapter());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    score ++;
    System.out.println(score);
    }

    class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch(keycode){
                case KeyEvent.VK_UP :
                    player.y += 1;
                    break;
                case KeyEvent.VK_DOWN:
                    player.y -= 1;
                    break;
                case KeyEvent.VK_RIGHT:
                    player.x += 1;
                    break;
                case KeyEvent.VK_LEFT:
                    player.x -= 1;
                    break;

            }

            System.out.println(player.x + ", " + player.y);
        }
    }
}
