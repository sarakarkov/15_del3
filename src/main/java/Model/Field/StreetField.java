package Model.Field;

import Model.Player;
import gui_fields.GUI_Player;

import java.awt.*;

public class StreetField extends Field {
    private int rent;
    private Player owner;


    public StreetField(String name, String tooltip, String description, int rent) {
        super(name, tooltip, description);
        this.rent = rent;
    }

    public StreetField(String name, String tooltip, String description, int rent, Color foregroundColor) {
        super(name, tooltip, description, foregroundColor);
        this.rent = rent;
    }

    public StreetField(String name, String tooltip, String description, int rent, Color foregroundColor, Color backgroundColor) {
        super(name, tooltip, description, foregroundColor, backgroundColor);
        this.rent = rent;
    }

    @Override
    public void fieldAction(Player player) {
        if(owner == null){
            owner = player;
            player.getAccount().setBalance(player.getAccount().getBalance() - rent);
        } else{
            owner.getAccount().setBalance(owner.getAccount().getBalance() + rent);
            player.getAccount().setBalance(player.getAccount().getBalance() - rent);
        }
    }

    public Player getOwner() { return owner; }
    public String getRentString() {
        return Integer.toString(rent);
    }
    public int getRent() {
        return rent;
    }
}
