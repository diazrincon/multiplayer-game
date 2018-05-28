package controller;

import model.GameModel;
import view.GameView;

import javax.swing.*;
import java.awt.*;

public class Controller {

    private GameModel gameModel;
    private GameView gameView;

    public Controller() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel);
        initFrame();
    }

    private void initFrame() {
        JFrame jfMainWindow = new JFrame("GAME");
        jfMainWindow.setContentPane(gameView);
        jfMainWindow.setSize(new Dimension((int)gameModel.getBattlefield().getWidth(), (int)gameModel.getBattlefield().getHeight()));
        jfMainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfMainWindow.setResizable(false);
        jfMainWindow.setVisible(true);
    }


}
