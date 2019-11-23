package Model.Field;

import java.awt.*;

public class RefugeField extends Field {
    public RefugeField(String name, String subtext, String description) {
        super(name, subtext, description);
    }

    public RefugeField(String name, String subtext, String description, Color foregroundColor) {
        super(name, subtext, description, foregroundColor);
    }

    public RefugeField(String name, String subtext, String description, Color foregroundColor, Color backgroundColor) {
        super(name, subtext, description, foregroundColor, backgroundColor);
    }
}
