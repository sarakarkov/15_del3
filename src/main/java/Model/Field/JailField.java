package Model.Field;

import java.awt.*;

public class JailField extends Field {
    public JailField(String name, String subtext, String description) {
        super(name, subtext, description);
    }

    public JailField(String name, String subtext, String description, Color foregroundColor) {
        super(name, subtext, description, foregroundColor);
    }

    public JailField(String name, String subtext, String description, Color foregroundColor, Color backgroundColor) {
        super(name, subtext, description, foregroundColor, backgroundColor);
    }
}

