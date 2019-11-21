package Model.Field;

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
}
