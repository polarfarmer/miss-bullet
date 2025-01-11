import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JFrame implements ActionListener {
    private int GRID_SIZE = 99;
    private ArrayList<Bullet> bullets;

    public Game() {
        setSize(400, 300);
        setVisible(true);

        addKeyListener(new TAdapter());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            System.out.println(keycode + "");
        }
    }
}
