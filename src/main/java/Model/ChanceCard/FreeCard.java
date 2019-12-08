package Model.ChanceCard;

import Model.Field.Field;
import Model.Player;



//Nedarver fra ChanceCard

public class FreeCard extends ChanceCard {
    private int[] fieldRanges;

    // Konstruktor som giver navn og antal man skal flytte.
    public FreeCard(String name, int[] fieldRanges) {
        super(name);
        this.fieldRanges = fieldRanges;
    }


    public void moveToRandomColorField(Player player, Field[] fields){
        int position = fieldRanges[getRandomInt(0, fieldRanges.length - 1)];
        player.setFieldPosition(position, fields);
    }
}
