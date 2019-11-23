package Model.ChanceCard;

import Model.Field.Field;
import Model.Field.StreetField;
import Model.GameBoard;
import Model.InterfaceGUI;
import Model.Player;

public class FreeCard extends ChanceCard {
    private int[] fieldRanges;
    public FreeCard(String name, int[] fieldRanges) {
        super(name);
        this.fieldRanges = fieldRanges;
    }

    public void moveToRandomColorField(Player player, Field[] fields){
        int position = fieldRanges[getRandomInt(0, fieldRanges.length - 1)];
        player.setFieldPosition(position, fields);
    }
}
