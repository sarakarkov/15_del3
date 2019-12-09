package Model.ChanceCard;

import Model.Player;

//Nedarver metoder fra chancekort

public class JailCard extends ChanceCard {

    // Set-konstruktor som
    public JailCard(String name) {
        super(name);
    }


    //
    public void activateOnPlayer(Player player){
        player.setJailCard(true);
    }
}
