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
        if(this.balance < 0) this.balance = 0;
    }

    @Override
    public String toString() {
        return Integer.toString(this.balance);
    }
}
