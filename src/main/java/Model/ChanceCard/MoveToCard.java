package Model.ChanceCard;

import Model.Field.Field;
import Model.Player;

 //Nedarver metoder fra ChanCard
public class MoveToCard extends ChanceCard {

    //Opretter ny attribut position
    private int position;

    // Set-konstruktor som gør at man kan sætte parametrene for name og position
    public MoveToCard(String name, int position) {
        super(name);
        this.position = position;
    }
    //
    public void movePlayerToPosition(Player player, Field[] fields){
        player.setFieldPosition(position, fields);
    }
}
