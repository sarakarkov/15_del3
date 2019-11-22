package Model.Field;

import Model.Player;

import java.awt.*;

//REFUGEE feltet. (pause feltet)
public class EmptyField extends Field {
    public EmptyField(String name, String tooltip, String description) {
        super(name, tooltip, description);
    }

    public EmptyField(String name, String tooltip, String description, Color foregroundColor) {
        super(name, tooltip, description, foregroundColor);
    }

    public EmptyField(String name, String tooltip, String description, Color foregroundColor, Color backgroundColor) {
        super(name, tooltip, description, foregroundColor, backgroundColor);
    }

    @Override
    public void fieldAction(Player player) {
        //Der skal ikke ske noget her
    }
}
