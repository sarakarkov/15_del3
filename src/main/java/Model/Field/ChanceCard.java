package Model.Field;

import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.util.Random;

public class ChanceCard {

    private String name;

    public ChanceCard(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
