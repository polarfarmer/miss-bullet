import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JFrame implements ActionListener {
    public static int GRID_SIZE = 99;
    public static int FrameSizeX = 400;
    public static int FrameSizeY = 300;
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private Player player;
    private Timer timer;
    private int score = 0;

    private JPanel gamePanel;

    public Game() {
        player = new Player();
        timer = new Timer(50,this);
        timer.start();
        addKeyListener(new TAdapter());

        setSize(400, 300);
        gamePanel = new JPanel();
        add(gamePanel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        score++;
        for (Bullet bullet : bullets) {
            bullet.Move();
        }
        FrameSizeX = getWidth();
        FrameSizeY = getHeight();
        bullets.add(new Bullet(1));
        repaint();
    }

    class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch(keycode){
                case KeyEvent.VK_UP :
                    player.Move_Player(1);
                    break;
                case KeyEvent.VK_DOWN:
                    player.Move_Player(2);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.Move_Player(3);
                    break;
                case KeyEvent.VK_LEFT:
                    player.Move_Player(4);
                    break;
            }

            System.out.println(player.x + ", " + player.y);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.MAGENTA);
        for (Bullet bullet : bullets) {
            g.fillOval(bullet.x - bullet.radius, bullet.y - bullet.radius, bullet.radius * 2, bullet.radius * 2);
        }

        g.setColor(Color.BLACK);
        g.fillOval(player.x - player.raduis, player.y - player.raduis, player.raduis * 2, player.raduis * 2);
    }
}
