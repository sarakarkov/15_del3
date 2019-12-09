package Model.ChanceCard;

import Model.Field.Field;
import Model.Player;



//Nedarver metoder fra ChanceCard

public class FreeCard extends ChanceCard {

    //Array
    private int[] fieldRanges;

    // Konstruktor som gør at man kan sætte navn og antal den skal flytte
    public FreeCard(String name, int[] fieldRanges) {
        super(name); //Henter name fra konstruktoren i ChanceCard klassen
        this.fieldRanges = fieldRanges;
    }

    //
    public void moveToRandomColorField(Player player, Field[] fields){
        int position = fieldRanges[getRandomInt(0, fieldRanges.length - 1)];
        player.setFieldPosition(position, fields);
    }
}
