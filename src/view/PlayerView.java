package view;

import model.PlayerModel;

import java.awt.*;

class PlayerView {

    private Color bodyColor;
    private PlayerModel playerModel;

    PlayerView(Color bodyColor, PlayerModel playerModel) {
        this.bodyColor = bodyColor;
        this.playerModel = playerModel;
    }

    void draw(Graphics graphics)  {
        graphics.setColor(bodyColor);
        graphics.fillRect((int)playerModel.getX(), (int)playerModel.getY(),
                (int)playerModel.getWidth(), (int)playerModel.getHeight());
        graphics.setColor(Color.BLACK);
        graphics.drawRect((int)playerModel.getX(), (int)playerModel.getY(),
                (int)playerModel.getWidth(), (int)playerModel.getHeight());
    }
}
