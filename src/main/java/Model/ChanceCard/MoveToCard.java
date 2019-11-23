package Model.ChanceCard;

import Model.Field.Field;
import Model.Field.StartField;
import Model.Player;

public class MoveToCard extends ChanceCard {
    private int position;
    public MoveToCard(String name, int position) {
        super(name);
        this.position = position;
    }

    public void movePlayerToPosition(Player player, Field[] fields){
        player.setFieldPosition(position, fields);
    }
}
