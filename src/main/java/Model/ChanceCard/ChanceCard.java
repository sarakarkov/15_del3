package Model.ChanceCard;

abstract public class ChanceCard {

    //Opretter en atribut "name", da alle chancekortene indeholder navne

    private String name;

    //Opretter set-konstruktor så man kan sætte værdien "navnet" for parameteren når man opretter et chancekort

    public ChanceCard(String name){
        this.name = name;
    }

    // Get - metoder så man kan kalde parameteren, herunder navnet

    public String getName() {
        return name;
    }

    // Get metode som returnerer et random helttal (int)
    protected int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
