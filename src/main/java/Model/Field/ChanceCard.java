package Model.Field;

import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class ChanceCard {
    private String name;
    private String action;

    public ChanceCard(String name, String action){
        this.name = name;
        this.action = action;
    }

    public String getName(){
        return name;
    }

    public void action(GUI_Field[] juniorFields, Player player, GUI_Player guiPlayer){
        switch(action){
            case "#1":
                juniorFields[player.getPosition()].setCar(guiPlayer, false);
                int startIndex = 0;
                player.setPosition(startIndex);
                juniorFields[startIndex].setCar(guiPlayer, true);
                guiPlayer.setBalance(guiPlayer.getBalance() + 2);
                break;
            case "#2":
                break;
            case "#3":
                break;
            case "#4":
                break;
            case "#5":
                break;
            case "#6":
                break;
            case "#7":
                break;
            case "#8":
                break;
            case "#9":
                break;
            case "#10":
                break;
            case "#11":
                break;
            case "#12":
                break;
            case "#13":
                break;
            case "#14":
                break;
        }
    }
}
