package Model.Field;

import java.util.Random;

public class ChanceField extends Field {
    ChanceCard[] chanceCards;

    public ChanceField(){
        chanceCards = new ChanceCard[]{
            new ChanceCard("Chance1# Ryk frem til start og modtag M2", "#1"),
            new ChanceCard("Chance2# Ryk ryk 5 felter frem", "#2"),
            new ChanceCard("Chance3# Ryk frem til et vilkårligt orange felt. Hvis det er ledigt får du det gratis ellers skal du betale leje til ejeren", "#3"),
            new ChanceCard("Chance4# Ryk et felt frem og tag et chancekort mere", "#4"),
            new ChanceCard("Chance5# Du har spist for meget slik betal M2 til banken", "#5"),
            new ChanceCard("Chance6# Gratis felt. Ryk frem til et vilkårligt grønt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren", "#6"),
            new ChanceCard("Chance7# Gratis felt. Ryk frem til et vilkårligt lyse blåt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren", "#7"),
            new ChanceCard("Chance8# Du løslades uden omkostninger. Behold dette kort indtil du får brug for det", "#8"),
            new ChanceCard("Chance9# Ryk til Strandpromenaden", "#9"),
            new ChanceCard("Chance10# Det er din fødselsdag. Alle giver dig M1. Tillykke med fødselsdagen", "#10"),
            new ChanceCard("Chance11# Gratis felt. Ryk frem til et vilkårligt pink eller vilkårligt mørkeblåt felt. Hvis det er ledigt får du det gratis, ellers skal du betale leje til ejeren", "#11"),
            new ChanceCard("Chance12# Du har lavet alle dine lektier. Modtag M3 fra banken", "#12"),
            new ChanceCard("Chance13# Gratis felt. Ryk frem til et vilkårligt rødt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren", "#13"),
            new ChanceCard("Chance14# Gratis felt. Ryk frem til Skaterparken for at lave det perfekte grind! Hvis ingen ejer det, får du den gratis ellers skal du betale leje til ejeren", "#14")
        };
    }

    public ChanceCard getRandomCard(){
        Random rand = new Random();
        int index = rand.nextInt(chanceCards.length);
        return chanceCards[index];
        // action mangler at købe, og når andre lander skal de betale via chancekortet
    }
}
