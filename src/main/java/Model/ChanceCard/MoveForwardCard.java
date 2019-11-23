package Model.ChanceCard;

import Model.Field.Field;
import Model.Player;

public class MoveForwardCard extends ChanceCard {
    private int positionForward;
    public MoveForwardCard(String name, int positionForward) {
        super(name);
        this.positionForward = positionForward;
    }

    public void movePlayer(Player player, Field[] fields){
        player.setFieldPosition(player.getFieldPosition() + positionForward, fields);
    }
}
