package Model;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class Player {
    private int id;
    private String name;
    private int positionIndex = 0;

    private Account account;

    public Player(int id, String name, Account account){
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public int getId(){ return this.id; }
    public String getName(){
        return this.name;
    }
    public Account getAccount(){ return this.account; }

    public void movePlayer(GUI_Field[] guiFields, GUI_Player currentGUIPlayer, int d1Value, int d2Value) {
        guiFields[positionIndex].setCar(currentGUIPlayer, false);
        positionIndex = this.positionIndex + d1Value + d2Value;
        if(positionIndex >= guiFields.length){
            positionIndex = positionIndex - guiFields.length;
            this.getAccount().setBalance(currentGUIPlayer, this.getAccount().getBalance() + 2);
        }
        guiFields[positionIndex].setCar(currentGUIPlayer, true);
    }
}
