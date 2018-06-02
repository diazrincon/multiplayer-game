package controller;

import model.GameModel;
import view.GameView;

import javax.swing.*;
import java.awt.*;

public class Controller implements Runnable{

    private GameModel gameModel;
    private GameView gameView;

    //GAMELOOP
    private int tickCount;
    private boolean running;

    public Controller() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel);
        initFrame();
    }

    private void initFrame() {
        JFrame jfMainWindow = new JFrame(GameModel.NAME);

        jfMainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfMainWindow.setLayout(new BorderLayout());

        jfMainWindow.add(gameView, BorderLayout.CENTER);
        jfMainWindow.pack();

        jfMainWindow.setResizable(false);
        jfMainWindow.setLocationRelativeTo(null);
        jfMainWindow.setVisible(true);
    }

    public void tick() {
        tickCount++;
    }

    public void render()    {

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/60D;

        int ticks = 0, frames = 0;
        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        long now;
        boolean shouldRender;
        while(running)  {
            now = System.nanoTime();
            delta += (now - lastTime)/nsPerTick;
            lastTime = now;
            shouldRender = true;
            while(delta >= 1)   {
                ticks++;
                tick();
                delta--;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(shouldRender) {
                frames++;
                render();
            }

            //FRAMES AND TICKS PER SECOND
            if(System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                System.out.println("Frames: " + frames + " | Ticks: " + ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    public synchronized void start() {
        this.running = true;
        new Thread(this).start();
    }

    public synchronized void stop() {
        this.running = false;
    }
}
