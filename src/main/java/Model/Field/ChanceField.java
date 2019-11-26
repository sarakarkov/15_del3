package Model.Field;

import Model.ChanceCard.*;

import java.awt.*;
import java.util.Random;

public class ChanceField extends Field {
    private ChanceCard[] chanceCards;

    public ChanceField(String name, String subtext, String description) {
        super(name, subtext, description);
        initChanceCards();
    }

    public ChanceField(String name, String subtext, String description, Color foregroundColor) {
        super(name, subtext, description, foregroundColor);
        initChanceCards();
    }

    public ChanceField(String name, String subtext, String description, Color foregroundColor, Color backgroundColor) {
        super(name, subtext, description, foregroundColor, backgroundColor);
        initChanceCards();
    }

    public void initChanceCards(){
        chanceCards = new ChanceCard[]{
            new MoveToCard("Chance1# Ryk frem til start og modtag $1", 24),
            new MoveForwardCard("Chance2# Ryk 5 felter frem", 5),
            new FreeCard("Chance3# Gratis felt. Ryk frem til et vilkårligt orange felt. Hvis det er ledigt får du det gratis ellers skal du betale leje til ejeren", new int[]{10, 11}),
            new MoveForwardCard("Chance4# Ryk et felt frem og tag et chancekort mere", 1),
            new MoneyCard("Chance5# Du har spist for meget slik betal $2 til banken", -2),
            new FreeCard("Chance6# Gratis felt. Ryk frem til et vilkårligt grønt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren", new int[]{19, 20}),
            new FreeCard("Chance7# Gratis felt. Ryk frem til et vilkårligt lyse blåt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren", new int[]{4, 5}),
            new JailCard("Chance8# Du løslades uden omkostninger. Behold dette kort indtil du får brug for det"),
            new MoveToCard("Chance9# Ryk til Strandpromenaden", 23),
            new MoneyCard("Chance10# Det er din fødselsdag. Alle giver dig $1. Tillykke med fødselsdagen", 1),
            new FreeCard("Chance11# Gratis felt. Ryk frem til et vilkårligt pink eller vilkårligt mørkeblåt felt. Hvis det er ledigt får du det gratis, ellers skal du betale leje til ejeren", new int[]{7,8,22,23}),
            new MoneyCard("Chance12# Du har lavet alle dine lektier. Modtag $3 fra banken", 3),
            new FreeCard("Chance13# Gratis felt. Ryk frem til et vilkårligt rødt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren", new int[]{13,14}),
            new FreeCard("Chance14# Gratis felt. Ryk frem til Skaterparken for at lave det perfekte grind! Hvis ingen ejer det, får du den gratis ellers skal du betale leje til ejeren", new int[]{10})
        };
    }

    public int getRandomCardIndex(){
        Random rand = new Random();
        int index = rand.nextInt(chanceCards.length);
        return index;
    }
    public ChanceCard getChanceCard(int index){
        return chanceCards[index];
    }
}