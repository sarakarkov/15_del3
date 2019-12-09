package Model;

import gui_fields.GUI_Player;

public class Account {
    private int balance;

    public Account(int balance){ //Opretter likviditetskonto
        this.balance = balance;
    }

    public int getBalance() { //Int som henter likviditeten, og derefter returnerer den.
        return this.balance;
    }
    public void setBalance(int balance){ //Void som opdaterer likviditeten, returnerer intet.
        this.balance = balance;
    }

    @Override
    public String toString() {
        return Integer.toString(this.balance); //String som returnerer likviditeten.
    }
}
