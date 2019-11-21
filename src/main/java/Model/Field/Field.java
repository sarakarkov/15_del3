package Model.Field;

import java.awt.*;

abstract public class Field {
    protected int id;

    protected String name;
    protected String tooltip;
    protected String description;

    protected Color foregroundColor = Color.white;
    protected Color backgroundColor = Color.black;

    public Field(String name, String tooltip, String description){
        this.name = name;
        this.tooltip = tooltip;
        this.description = description;
    }
    public Field(String name, String tooltip, String description, Color foregroundColor){
        this.name = name;
        this.tooltip = tooltip;
        this.description = description;
        this.foregroundColor = foregroundColor;
    }
    public Field(String name, String tooltip, String description, Color foregroundColor, Color backgroundColor){
        this.name = name;
        this.tooltip = tooltip;
        this.description = description;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTooltip() {
        return tooltip;
    }
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }
    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
