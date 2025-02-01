import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game extends JFrame implements ActionListener {
    public static int FrameSizeWidth = 800;
    public static int FrameSizeHeight = 600;
    private final int delay = 50;

    public static Player player;
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private Timer timer;
    private Random random = new Random();
    private int score = 0;
    private int wave = 0;
    private int timeCount = 0;
    private int bulletSpawnTime = 1000;

    private JPanel gamePanel;
    private JLabel textLabel;
    private JLabel overLabel;

    public Game() {
        player = new Player();
        timer = new Timer(delay,this);
        timer.start();
        addKeyListener(new TAdapter());

        setSize(FrameSizeWidth, FrameSizeHeight);
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        add(gamePanel);

        textLabel = new JLabel("score: 0 wave: 0");
        textLabel.setFont(new Font("Times", Font.PLAIN, 20));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gamePanel.add(textLabel, BorderLayout.NORTH);

        overLabel = new JLabel("Game Over!");
        overLabel.setVisible(false);
        overLabel.setFont(new Font("Times", Font.BOLD, 70));
        overLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gamePanel.add(overLabel, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(player.dead){
            timer.stop();
            overLabel.setVisible(true);
        }
        timeCount++;

        if (timeCount % (1000 / delay) == 0) {//1초에 실행
            score++;
        }

        if (timeCount % (5000 / delay) == 0) {//5초에 실행
            wave++;
            bulletSpawnTime = Math.max(bulletSpawnTime - 100, 100);
        }

        if (timeCount % (bulletSpawnTime / delay) == 0) {//총알 생성
            int rand = random.nextInt(10);

            if (rand == 0) {
                bullets.add(new Bullet(1));
            }
            else {
                bullets.add(new Bullet(0));
            }
        }

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);

            bullet.Move();
            if (bullet.Interact()) {
                player.die();
            }
            if (Main.IsFrameOut(bullet.x, bullet.y)) {
                bullet.die();
                bullets.remove(i);
                i--;
            }
        }

        FrameSizeWidth = getWidth();
        FrameSizeHeight = getHeight();
        repaint();
        textLabel.setText("score: " + score + " wave: " + wave);
    }

    class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch(keycode){
                case KeyEvent.VK_UP :
                    player.Move_Player(Main.Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    player.Move_Player(Main.Direction.DOWN);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.Move_Player(Main.Direction.RIGHT);
                    break;
                case KeyEvent.VK_LEFT:
                    player.Move_Player(Main.Direction.LEFT);
                    break;
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.MAGENTA);
        for (Bullet bullet : bullets) {
            g.fillOval(bullet.x - bullet.radius, bullet.y - bullet.radius, bullet.radius * 2, bullet.radius * 2);
        }

        g.setColor(Color.BLACK);
        g.fillOval(player.x - player.radius, player.y - player.radius, player.radius * 2, player.radius * 2);
    }
}
