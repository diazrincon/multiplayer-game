package view;

import model.BattlefieldModel;

import java.awt.*;

class BattlefieldView {

    private Color background;
    private BattlefieldModel battlefieldModel;

    BattlefieldView(Color background, BattlefieldModel battlefieldModel) {
        this.background = background;
        this.battlefieldModel = battlefieldModel;
    }

    void draw(Graphics graphics)  {
        graphics.setColor(background);
        graphics.fillRect(0,0, (int) battlefieldModel.getWidth(), (int) battlefieldModel.getHeight());
    }
}
