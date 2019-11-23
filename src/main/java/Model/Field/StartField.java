package Model.Field;

import Model.Account;
import Model.InterfaceGUI;
import Model.Player;

import java.awt.*;

public class StartField extends Field {
    private final int bonus = 1; //Sat til 1 da 2 er for meget når man har 2 terninger. (UI supporterer en terning men så kan man ikke placerer den så derfor bruger vi 2...)

    public StartField(String name, String subtext, String description) {
        super(name, subtext, description);
    }

    public StartField(String name, String subtext, String description, Color foregroundColor) {
        super(name, subtext, description, foregroundColor);
    }

    public StartField(String name, String subtext, String description, Color foregroundColor, Color backgroundColor) {
        super(name, subtext, description, foregroundColor, backgroundColor);
    }

    public void bonusObtained(Player player){
        Account playerAccount = player.getAccount();
        playerAccount.setBalance(playerAccount.getBalance() + bonus);
        InterfaceGUI.setGuiPlayerBalance(player);
    }
}
