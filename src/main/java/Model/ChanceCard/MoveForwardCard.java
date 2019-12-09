package Model.ChanceCard;

import Model.Field.Field;
import Model.Player;

 // Nedarver metoder fra chancecard
public class MoveForwardCard extends ChanceCard {

    //Attribut positionForward
    private int positionForward;

    //Set konstruktor som gør at man kan sætte parametrene name og positionForward
    public MoveForwardCard(String name, int positionForward) {
        super(name);
        this.positionForward = positionForward;
    }

    // Metode som tager den nuværende player, og rykker antal felter man trækker
    public void movePlayer(Player player, Field[] fields){
        player.setFieldPosition(player.getFieldPosition() + positionForward, fields);
    }
}



