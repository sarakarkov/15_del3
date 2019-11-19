package Model;

public class Loser {

    private boolean loser;

    private int loserLimit = 0;

    public void setLoser(boolean loser) {this.loser=loser;}

    public boolean isLoser(){return loser;}


    public void hasLost(int balance) {
        if(loserLimit>balance)
        setLoser(true);
        else
            setLoser(false);
    }
}
