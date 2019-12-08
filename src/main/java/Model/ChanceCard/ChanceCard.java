package Model.ChanceCard;

abstract public class ChanceCard {

    //Opretter en atribut med et navn

    private String name;

    //Opretter set-konstruktor
    public ChanceCard(String name){
        this.name = name;
    }

    // Get - metoder
    public String getName() {
        return name;
    }


    // Get metode som returnerer et random tal
    protected int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
