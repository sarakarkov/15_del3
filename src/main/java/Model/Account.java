package Model;

public class Account {
    private Player player;

    private int balance = 1000;

    public Account(Player player){
        this.player = player;
    }

    public void addBalance(int balance){
        this.balance += balance;
        if(this.balance < 0) setBalance(0);
    }
    public void setBalance(int balance){
        this.balance = balance;
        if(this.balance < 0) this.balance = 0;
    }


    public Player getPlayer(){ return this.player; }
    public String getBalanceString() { return Integer.toString(this.balance); }
    public int getBalance() {
        return this.balance;
    }
}
