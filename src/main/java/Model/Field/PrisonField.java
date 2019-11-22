package Model.Field;

import Model.Player;

import java.awt.*;

public class PrisonField extends Field {
    public PrisonField(String name, String tooltip, String description) {
        super(name, tooltip, description);
    }

    public PrisonField(String name, String tooltip, String description, Color foregroundColor) {
        super(name, tooltip, description, foregroundColor);
    }

    public PrisonField(String name, String tooltip, String description, Color foregroundColor, Color backgroundColor) {
        super(name, tooltip, description, foregroundColor, backgroundColor);
    }

    @Override
    public void fieldAction(Player player) {
        //Der skal ikke ske noget her
    }
}


