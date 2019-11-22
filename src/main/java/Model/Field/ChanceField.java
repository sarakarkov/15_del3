package Model.Field;

import Model.GameBoard;
import Model.Player;

import java.awt.*;
import java.util.Random;

public class ChanceField extends Field {

    int currentRandomCardIndex;
    ChanceCard[] chanceCards;

    public ChanceField(String name, String tooltip, String description) {
        super(name, tooltip, description);
        setupCards();
    }

    public ChanceField(String name, String tooltip, String description, Color foregroundColor) {
        super(name, tooltip, description, foregroundColor);
        setupCards();
    }

    public ChanceField(String name, String tooltip, String description, Color foregroundColor, Color backgroundColor) {
        super(name, tooltip, description, foregroundColor, backgroundColor);
        setupCards();
    }

    @Override
    public void fieldAction(Player player) {
        currentRandomCardIndex = getRandomCardIndex();
        switch(currentRandomCardIndex){
            case 0:
                player.setPlayerLocation(0);
                break;
            case 1:
                player.setPlayerLocation(player.getPositionIndex() + 5);
                break;
            case 2:
                int randomOrangeFieldLocation = getRandomInt(10, 11);
                player.setPlayerLocation(randomOrangeFieldLocation);
                break;
            case 3:
                player.setPlayerLocation(player.getPositionIndex() + 1);
                break;
            case 4:
                player.getAccount().setBalance(player.getAccount().getBalance() - 2);
                break;
            case 5:
                int randomGreenFieldLocation = getRandomInt(19, 20);
                player.setPlayerLocation(randomGreenFieldLocation);
                break;
            case 6:
                int randomBlueFieldLocation = getRandomInt(4, 5);
                player.setPlayerLocation(randomBlueFieldLocation);
                break;
            case 7:
                player.setHaveJailCard(true);
                break;
            case 8:
                player.setPlayerLocation(23);
                break;
            case 9:
                //bliver lavet ude fra gameboard
                break;
            case 10:
                int randomPinkFieldLocation = getRandomInt(7, 8);
                int randomDarkBlueFieldLocation = getRandomInt(22, 23);
                if(getRandomInt(1, 2) == 1){ //1 eller 2
                    player.setPlayerLocation(randomPinkFieldLocation);
                }else{
                    player.setPlayerLocation(randomDarkBlueFieldLocation);
                }
                break;
            case 11:
                player.getAccount().setBalance(player.getAccount().getBalance() + 3);
                break;
            case 12:
                int randomRedFieldLocation = getRandomInt(13, 14);
                player.setPlayerLocation(randomRedFieldLocation);
                break;
            case 13:
                player.setPlayerLocation(10);
                break;
            default:
                //Et kort er ikke blevet implemteret hvis dette bliver kaldt.
                break;
        }
        System.out.println(chanceCards[currentRandomCardIndex].getName());
    }

    public void setupCards() {
        chanceCards = new ChanceCard[]{
                new ChanceCard("Chance1# Ryk frem til start og modtag M2"),
                new ChanceCard("Chance2# Ryk 5 felter frem"),
                new ChanceCard("Chance3# Ryk frem til et vilkårligt orange felt. Hvis det er ledigt får du det gratis ellers skal du betale leje til ejeren"),
                new ChanceCard("Chance4# Ryk et felt frem og tag et chancekort mere"),
                new ChanceCard("Chance5# Du har spist for meget slik betal M2 til banken"),
                new ChanceCard("Chance6# Gratis felt. Ryk frem til et vilkårligt grønt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren"),
                new ChanceCard("Chance7# Gratis felt. Ryk frem til et vilkårligt lyse blåt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren"),
                new ChanceCard("Chance8# Du løslades uden omkostninger. Behold dette kort indtil du får brug for det"),
                new ChanceCard("Chance9# Ryk til Strandpromenaden"),
                new ChanceCard("Chance10# Det er din fødselsdag. Alle giver dig M1. Tillykke med fødselsdagen"),
                new ChanceCard("Chance11# Gratis felt. Ryk frem til et vilkårligt pink eller vilkårligt mørkeblåt felt. Hvis det er ledigt får du det gratis, ellers skal du betale leje til ejeren"),
                new ChanceCard("Chance12# Du har lavet alle dine lektier. Modtag M3 fra banken"),
                new ChanceCard("Chance13# Gratis felt. Ryk frem til et vilkårligt rødt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren"),
                new ChanceCard("Chance14# Gratis felt. Ryk frem til Skaterparken for at lave det perfekte grind! Hvis ingen ejer det, får du den gratis ellers skal du betale leje til ejeren")
        };
    }

    public int getRandomCardIndex(){
        Random rand = new Random();
        int index = rand.nextInt(chanceCards.length);
        return index;
    }
    public int getCurrentRandomCardIndex() {
        return currentRandomCardIndex;
    }

    public int getRandomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
