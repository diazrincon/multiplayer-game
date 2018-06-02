package view;

import model.GameModel;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private PlayerView player;
    private BattlefieldView battlefield;

    public GameView(GameModel gameModel) {
        player = new PlayerView(Color.GREEN, gameModel.getPlayer());
        battlefield = new BattlefieldView(Color.RED, gameModel.getBattlefield());

        setMinimumSize(new Dimension((int)(GameModel.WIDTH * GameModel.SCALE), (int)(GameModel.HEIGHT * GameModel.SCALE)));
        setMaximumSize(new Dimension((int)(GameModel.WIDTH * GameModel.SCALE), (int)(GameModel.HEIGHT * GameModel.SCALE)));
        setPreferredSize(new Dimension((int)(GameModel.WIDTH * GameModel.SCALE), (int)(GameModel.HEIGHT * GameModel.SCALE)));
    }

    @Override
    public void paint(Graphics g) {
        battlefield.draw(g);
        player.draw(g);
    }
}
