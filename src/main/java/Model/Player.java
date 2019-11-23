package Model;

import Model.Field.Field;
import Model.Field.StartField;

public class Player {
    private String name;
    private Account account;
    private boolean jailed = false;
    private boolean jailCard = false;

    private int previousFieldPosition = 0;
    private int fieldPosition = 0;

    public Player(String name, Account account){
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public boolean isJailed() {
        return jailed;
    }
    public void setJailed(boolean jailed) {
        this.jailed = jailed;
    }
    public boolean hasJailCard() {
        return jailCard;
    }
    public void setJailCard(boolean jailCard) {
        this.jailCard = jailCard;
    }

    public int getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(int fieldPosition, Field[] fields) {
        this.previousFieldPosition = this.fieldPosition;
        if(fieldPosition >= fields.length) {
            fieldPosition = fieldPosition - fields.length;
            ((StartField) fields[0]).bonusObtained(this);

            this.fieldPosition = fieldPosition;
            InterfaceGUI.setGuiPlayerPosition(this, previousFieldPosition, fieldPosition);
            InterfaceGUI.showGuiText("Spiller " + this.getName() + " landede eller passerede start og derfor modtager $1");
        }else{
            this.fieldPosition = fieldPosition;
            InterfaceGUI.setGuiPlayerPosition(this, previousFieldPosition, fieldPosition);
        }
    }
}
