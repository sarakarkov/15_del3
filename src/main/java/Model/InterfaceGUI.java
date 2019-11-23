package Model;

import Model.Field.Field;
import Model.Field.StreetField;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class InterfaceGUI {
    private static GUI gui;

    private static GUI_Player[] guiPlayers;
    private static GUI_Field[] guiFields;

    public static void InitGui(Field[] fields, Player[] players){
        //Rækkefølgen er vigtig
        guiFields = new GUI_Field[fields.length];
        for(int i = 0; i<fields.length;i++){
            Field field = fields[i];
            switch(field.getClass().getSimpleName()){
                case "StartField":
                    guiFields[i] = new GUI_Start(field.getName(), field.getSubtext(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "StreetField":
                    guiFields[i] = new GUI_Street(field.getName(), field.getSubtext(), field.getDescription(), ((StreetField) field).getRentString(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "ChanceField":
                    guiFields[i] = new GUI_Chance(field.getName(), field.getSubtext(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "JailField":
                    guiFields[i] = new GUI_Jail(field.getName(), field.getSubtext(), field.getDescription(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "RefugeField":
                    guiFields[i] = new GUI_Refuge(field.getName(), field.getSubtext(), field.getDescription(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
            }
        }
        gui = new GUI(guiFields);

        Color[] colors = new Color[]{Color.red, Color.green, Color.blue, Color.yellow};
        guiPlayers = new GUI_Player[players.length];
        for(int i = 0;i<players.length;i++){
            Player player = players[i];
            GUI_Car guiCar = new GUI_Car();
            guiCar.setPrimaryColor(colors[i]);
            GUI_Player guiPlayer = new GUI_Player(player.getName(), player.getAccount().getBalance(), guiCar);
            guiPlayers[i] = guiPlayer;
            gui.addPlayer(guiPlayer);
        }
    }

    public static void waitDicesBtnClicked(){
        gui.getUserButtonPressed("", "Kast terning");
    }
    public static void setDices(int d1Value, int d2Value){
        gui.setDice(d1Value, 0, 1, d2Value, 1, 1);
    }

    public static void setGuiPlayerBalance(Player player){
        getGuiPlayer(player).setBalance(player.getAccount().getBalance());
    }

    public static void setGuiFieldOwner(Field field, Player player){
        try{
            ((GUI_Street) getGuiField(field)).setOwnerName(player.getName());
        }
        catch (Exception e){
            System.out.println("Fejl. Der bliver forsøgt at sætte en ejer på et felt som ikke er af typen GUI_STREET");
        }
    }

    public static void setGuiPlayerPosition(Player player, int previousPosition, int position){
        GUI_Player guiPlayer = getGuiPlayer(player);
        guiFields[previousPosition].setCar(guiPlayer, false);
        guiFields[position].setCar(guiPlayer, true);
    }

    public static void setGuiCard(String text){
        gui.displayChanceCard(text);
    }
    public static void hideGuiCard(){
        gui.displayChanceCard("");
    }

    public static void showGuiText(String text){
        gui.showMessage(text);
    }

    public static GUI_Player getGuiPlayer(Player player){
        for(GUI_Player guiPlayer : guiPlayers) {
            if (guiPlayer.getName().equals(player.getName())) {
                return guiPlayer;
            }
        }
        return null;
    }

    public static GUI_Field getGuiField(Field field){
        for(GUI_Field guiField : guiFields) {
            if (guiField.getTitle().equals(field.getName())) {
                return guiField;
            }
        }
        return null;
    }

    public static GUI_Start getGuiStart(int index){
        try{
            return ((GUI_Start) guiFields[index]);
        }catch(Exception e){
            System.out.println("Fejl. Index: " + index + " i guiFields er ikke en GUI_Start");
            return null;
        }
    }
    public static GUI_Street getGuiStreet(int index){
        try{
            return ((GUI_Street) guiFields[index]);
        }catch(Exception e){
            System.out.println("Fejl. Index: " + index + " i guiFields er ikke en GUI_STREET");
            return null;
        }
    }
    public static GUI_Chance getGuiChance(int index){
        try{
            return ((GUI_Chance) guiFields[index]);
        }catch(Exception e){
            System.out.println("Fejl. Index: " + index + " i guiFields er ikke en GUI_Chance");
            return null;
        }
    }
    public static GUI_Jail getGuiJail(int index){
        try{
            return ((GUI_Jail) guiFields[index]);
        }catch(Exception e){
            System.out.println("Fejl. Index: " + index + " i guiFields er ikke en GUI_Jail");
            return null;
        }
    }
    public static GUI_Refuge getGuiRefuge(int index){
        try{
            return ((GUI_Refuge) guiFields[index]);
        }catch(Exception e){
            System.out.println("Fejl. Index: " + index + " i guiFields er ikke en GUI_Refuge");
            return null;
        }
    }
}
