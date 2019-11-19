package Model.Field;

public class ChanceCard {


    private String [] card;

    public ChanceCard() { MakeChanceCard();}

    public void MakeChanceCard()  {


        card = new String[14];

        card[0]="Chance1#Ryk frem til start og modtag M2";

        card[1]="Chance2#Ryk ryk op til 5 felter frem";

        card[2]="Chance3#Ryk frem til et orange felt. Hvis det er ledigt får du det gratis ellers skal du betale leje til ejeren";

        card[3]="Chance4#Ryk et felt frem og tag et chancekort mere";

        card[4]="Chance5#Du har spist for meget slik betal M2 til banken";

        card[5]="Chance6#Gratis felt. Ryk frem til et orange eller grønt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren";

        card[6]="Chance7#Gratis felt. Ryk frem til et lyse blåt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren";

        card[7]="Chance8#Du løslades uden omkostninger. Behold dette kort indtil du får brug for det";

        card[8]="Chance9#Ryk til Strandpromenaden";

        card[9]="Chance10#Det er din fødselsdag. Alle giver dig M1. Tillykke med fødselsdagen";

        card[10]="Chance11#Gratis felt. Ryk frem til et pink eller mørkeblåt felt. Hvis det er ledigt får du det gratis, ellers skal du betale leje til ejeren";

        card[11]="Chance12#Du har lavet alle dine lektier. Modtag M3 fra banken";

        card[12]="Chance13#Gratis felt. Ryk frem til et rødt felt. Hvis det er ledig får du det gratis, ellers skal du betale leje til ejeren";

        card[13]="Chance14#Gratis felt. Ryk frem til Skaterparken for at lave det perfekte grind! Hvis ingen ejer det, får du den gratis ellers skal du betale leje til ejeren";

         shuffleCard();

    }

    public String pickCard(){
        String card1 = card[0];
        for(int i=0; i<card.length-1;i++){
            card[i]=card[i+1];

        }

        card[card.length-1]= card1;
        return card1;

    }

    public void shuffleCard(){
        String[] card1 = card;
        int i=0;
        card1 = new String[card.length];
        while(i < card1.length) {

           int value = (int)Math.random()*card1.length;
            if (card1[value]==null){
                card1[value]=card[i];

                i++;

            }
        }

        card = card1;

    }




}
