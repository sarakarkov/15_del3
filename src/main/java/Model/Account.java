package Model;

import gui_fields.GUI_Player;

public class Account {
    private int balance;

    public Account(int balance){
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }

    @Override
    public String toString() {
        return Integer.toString(this.balance);
    }
}
