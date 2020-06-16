import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    
    public Game() {
        handler = new Handler();
        new Window(WIDTH,HEIGHT,"Organizmy",this);
        handler.addObject(new Owca(WIDTH/2 - 32, HEIGHT/2 -32,ID.Organizm));

        
    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() { 
        try {
            thread.join();
            running = false;

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 100000000;
        double delta = 0;
        long timer =  System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer+=1000;
                System.out.println("Fps: "+frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }    
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        g.dispose();
        bs.show();
    }
    public static void main(String args[]) { //main

            new Game(); //launch new window
     }
}