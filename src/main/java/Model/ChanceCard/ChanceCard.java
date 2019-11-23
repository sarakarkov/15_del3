package Model.ChanceCard;

abstract public class ChanceCard {
    private String name;
    public ChanceCard(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    protected int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
