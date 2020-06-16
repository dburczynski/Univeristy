import java.awt.Graphics;
import java.util.Random;

public abstract class GameObject {
    protected int x,y;
    protected ID id;
    protected int velX, velY;
    protected int prevVelX, prevVelY;
    protected Random movement;
    
    public GameObject(int x, int y, ID id,int prevVelX, int prevVelY) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.movement = new Random();
        this.prevVelX = prevVelX;
        this.prevVelY = prevVelY;
        
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    
    public void setX(int x){ 
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setID(ID id) {
        this.id = id;
    }
    public ID getID() {
        return id;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
    public void setPrevVelX(int prevVelX){ 
        this.prevVelX = prevVelx;
    }
    public void setPrevVelY(int prevVelY){ 
        this.prevVelY = prevVelY;
    }
    public int getPrevVelX() {
        return prevVelX;
    }
    public int getPrevVely() {
        return prevVelY;
    }


}