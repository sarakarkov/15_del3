package Model.ChanceCard;

import Model.Player;

//Nedarver fra chancekort

public class JailCard extends ChanceCard {


    public JailCard(String name) {
        super(name);
    }

    public void activateOnPlayer(Player player){
        player.setJailCard(true);
    }
}
