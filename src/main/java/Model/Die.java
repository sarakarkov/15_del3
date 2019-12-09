package Model;

import java.util.Random;

public class Die {
    private int value;

    public void rollDie() {
        this.value = new Random().nextInt(6) + 1;
    }
    //Void som ruller terningerne, returnerer intet.
    public int getDie() {
        return this.value;
}
    // Int som returnerer værdien af terningerne.
}