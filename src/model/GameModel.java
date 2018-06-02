package model;

public class GameModel {

    public static final double WIDTH = 160;
    public static final double HEIGHT = WIDTH / 12 * 9;
    public static final double SCALE = 3;
    public static final String NAME = "GAME";

    private BattlefieldModel battlefield;
    private PlayerModel player;

    public GameModel()  {
        battlefield = new BattlefieldModel(HEIGHT, WIDTH);
        player = new PlayerModel(25,25,100,100);
    }

    public BattlefieldModel getBattlefield() {
        return battlefield;
    }

    public PlayerModel getPlayer() {
        return player;
    }
}
