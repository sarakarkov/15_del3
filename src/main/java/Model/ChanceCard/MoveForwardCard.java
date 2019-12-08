package Model.ChanceCard;

import Model.Field.Field;
import Model.Player;

public class MoveForwardCard extends ChanceCard {

    //Attribut
    private int positionForward;

    //Set metode som sætter navn og hvor meget man skal rykke sig
    public MoveForwardCard(String name, int positionForward) {
        super(name);
        this.positionForward = positionForward;
    }

    public void movePlayer(Player player, Field[] fields){
        player.setFieldPosition(player.getFieldPosition() + positionForward, fields);
    }
}



