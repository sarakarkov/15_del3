package Model.Field;

import java.awt.*;

abstract public class Field {

    //Atributer
    private String name, subtext, description;
    private Color foregroundColor = Color.white, backgroundColor = Color.black;


    // Set-konstruktorer for de forskellige attribut parametre

    public Field(String name, String subtext, String description){
        this.name = name;
        this.subtext = subtext;
        this.description = description;
    }

    public Field(String name, String subtext, String description, Color foregroundColor){
        this.name = name;
        this.subtext = subtext;
        this.description = description;
        this.foregroundColor = foregroundColor;
    }

    public Field(String name, String subtext, String description, Color foregroundColor, Color backgroundColor){
        this.name = name;
        this.subtext = subtext;
        this.description = description;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
    }

    // Get-metoder til at hente parametrene i konstruktoren

    public String getName() {
        return name;
    }

    public String getSubtext() {
        return subtext;
    }

    public String getDescription() {
        return description;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
}
