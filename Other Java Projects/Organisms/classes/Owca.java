import java.awt.Graphics;
import java.util.Random;

public class Owca extends Organizm {

    public Owca(int x, int y, ID id) {
        super(x, y, id);
        
    }

    public void tick() {
        velX = movement.nextInt(3)-1;
        velY = movement.nextInt(3)-1;
        this.x += velX;
        this.y += velY;
    }
    public void render(Graphics g) {
    g.setColor(Color.white);
        g.fillRect(x, y,32, 32);
    }
}