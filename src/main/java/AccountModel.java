public class AccountModel {
    private PlayerModel player;

    private int balance = 1000;

    public AccountModel(PlayerModel player){
        //Denne klasse burde være abstract og så ville PlayerModel arve fra denne klasse i stedet..
        this.player = player;
    }

    public int getBalance() {
        return this.balance;
    }
    public String getBalanceString() { return Integer.toString(this.balance); }
    public void addBalance(int balance){
        this.balance += balance;
        if(this.balance < 0) setBalance(0);
    }
    public void setBalance(int balance){
        this.balance = balance;
        if(this.balance < 0) this.balance = 0;
    }
}
