import java.awt.Graphics;
import java.util.Random;

public abstract class Organizm extends GameObject {
    private int power;
    private int initiative;
    private int liveLength;
    private int powerToReproduce;
    public Organizm(int x, int y,ID id) {
        super(x,y,id);
    }
    public abstract void tick();
    public abstract void render(Graphics g);

    public void setPower(int power) {
        this.power = power;
    }

        
    
}