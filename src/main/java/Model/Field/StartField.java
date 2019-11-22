package Model.Field;

import Model.Player;

import java.awt.*;

public class StartField extends Field {
    public final int passingMoney = 2;

    public StartField(String name, String tooltip, String description) {
        super(name, tooltip, description);
    }

    public StartField(String name, String tooltip, String description, Color foregroundColor) {
        super(name, tooltip, description, foregroundColor);
    }

    public StartField(String name, String tooltip, String description, Color foregroundColor, Color backgroundColor) {
        super(name, tooltip, description, foregroundColor, backgroundColor);
    }

    @Override
    public void fieldAction(Player player) {
        //Bliver håndteret via isFieldPassed
    }

    public void isFieldPassed(Player player){
        if(player.getOldPositionIndex() > player.getPositionIndex()){ //Lidt frækt men der er ikke sandsynlighed for at den gamle position bliver mindre end den nye når man passerer start
            player.getAccount().setBalance(player.getAccount().getBalance() + this.passingMoney);
        }
    }
}
