package Model;

import Model.Field.Field;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class Player {
    private int id;
    private String name;
    private int oldPositionIndex = 0;
    private int positionIndex = 0;
    private boolean isJailed = false;
    private boolean haveJailCard = false;

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
    public int getOldPositionIndex() {return this.oldPositionIndex;}
    public int getPositionIndex() {return this.positionIndex;}

    public boolean IsJailed(){return this.isJailed;}
    public void setJailed(boolean jailed){this.isJailed = jailed;}

    public void setPlayerLocation(int location) {
        oldPositionIndex = positionIndex;
        positionIndex = location;
    }

    public void setHaveJailCard(boolean haveJailCard) {
        this.haveJailCard = haveJailCard;
    }
    public boolean isHavingJailCard() {
        return haveJailCard;
    }
}
