package Model.Field;

import java.awt.*;

public class StreetField extends Field {
    private int rent;


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

    public String getRentString() {
        return Integer.toString(rent);
    }
    public int getRent() {
        return rent;
    }
}
