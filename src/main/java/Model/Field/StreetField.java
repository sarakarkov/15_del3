package Model.Field;

import Model.Player;

import java.awt.*;

public class StreetField extends Field {
    private int rent;
    private Player owner = null;

    public StreetField(String name, String subtext, String description, int rent) {
        super(name, subtext, description);
        this.rent = rent;
    }

    public StreetField(String name, String subtext, String description, int rent, Color foregroundColor) {
        super(name, subtext, description, foregroundColor);
        this.rent = rent;
    }

    public StreetField(String name, String subtext, String description, int rent, Color foregroundColor, Color backgroundColor) {
        super(name, subtext, description, foregroundColor, backgroundColor);
        this.rent = rent;
    }

    public int getRent(){
        return this.rent;
    }
    public String getRentString(){
        return Integer.toString(this.rent);
    }

    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
