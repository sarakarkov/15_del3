package Model.Field;

import Model.Player;

import java.awt.*;

public class JailField extends Field {
    public JailField(String name, String tooltip, String description) {
        super(name, tooltip, description);
    }

    public JailField(String name, String tooltip, String description, Color foregroundColor) {
        super(name, tooltip, description, foregroundColor);
    }

    public JailField(String name, String tooltip, String description, Color foregroundColor, Color backgroundColor) {
        super(name, tooltip, description, foregroundColor, backgroundColor);
    }

    @Override
    public void fieldAction(Player player) {
        player.setJailed(true);
        player.setPlayerLocation(6);
    }
}

