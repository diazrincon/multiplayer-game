package model;

public class GameModel {

    private BattlefieldModel battlefield;
    private PlayerModel player;

    public GameModel()  {
        battlefield = new BattlefieldModel(200, 200);
        player = new PlayerModel(25,25,100,100);
    }

    public BattlefieldModel getBattlefield() {
        return battlefield;
    }

    public PlayerModel getPlayer() {
        return player;
    }
}
