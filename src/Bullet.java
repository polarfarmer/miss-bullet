import java.util.Random;

public class Bullet {
    protected int[][] bullet_map = new int[99][99];
    public Bullet() {
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                bullet_map[i][j] = 0;
            }
        }
    }
    private void New_Bullet() {
        Random random = new Random ();
        for (int i = 0; i < 4; i++) {
            if(i == 0){
                bullet_map[random.nextInt(98)][0] = 1;
            }else if(i == 1){
                bullet_map[random.nextInt(98)][98] = 2;
            }else if(i == 2){
                bullet_map[0][random.nextInt(98)] = 3;
            }else if(i == 3){
                bullet_map[98][random.nextInt(98)] = 4;
            }
        }
    }
}