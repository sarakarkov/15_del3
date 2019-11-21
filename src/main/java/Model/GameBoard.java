package Model;

import Model.Field.*;
import gui_fields.*;
import gui_main.GUI;
import java.util.Scanner;
import java.awt.*;

public class GameBoard {
    private GUI gui;
    private GUI_Player[] guiPlayers;
    private GUI_Field[] guiFields;

    private boolean gameOver;
    private Player[] players;
    private Field[] fields;


    public void setupPlayers() {
        // Initialisering af spillere
        Scanner input = new Scanner(System.in);
        int totalPlayers;
        while (true) {
            try {
                System.out.println("Indtast antal spillere mellem 2 og 4:");
                totalPlayers = input.nextInt();
                if (totalPlayers > 1 && totalPlayers < 5) break;
            } catch (Exception e) {
                input.nextLine();  // Fordi nextInt ikke kalder \n som er ny line, derfor bliver denne automatisk kaldt
            }
        }
        input.nextLine();  // Fordi nextInt ikke kalder \n som er ny line, derfor bliver denne automatisk kaldt
        players = new Player[totalPlayers];
        for (int i = 0; i < totalPlayers; i++) {
            System.out.println("Indtast spiller nr. " + (i + 1));
            String playerName = input.nextLine();
            boolean exist = false;
            for(Player p : players){
                if(p != null && p.getName().equals(playerName)){
                    exist = true;
                }
            }
            if(!exist){
                players[i] = new Player(i, playerName, new Account(20));
            }else {
                i--;
                System.out.println("Navnet eksisterer allerede.");
            }
        }
        System.out.println("Spillet begynder. GUI'en bliver åbnet.");
    }

    public void setupFields(){
        //Som en vilkårlig diskret forelæser kunne sige det. ORDER MATTERS!
        //Med andre ord det er har betydning hvilket index i listen hvert felt får fx så er Field[0] = start feltet osv..
        fields = new Field[]{
            new StartField("Start", "Modtag: $2", "Modtag $2, når du passerer start"),
            new StreetField("Burgerbaren", "$1", "Bli tyk her", 1),
            new StreetField("Pizzahuset", "$1", "Bli også tyk her", 1),
            new ChanceField("?", "CHANCE", "Tag et chancekort"),
            new StreetField("Slikbutikken", "$1", "Slik noget", 1),
            new StreetField("Iskiosken", "$1", "Bli kølet ned", 1),
            new PrisonField("default", "Besøg fængslet", "På besøg"), //default fordi sådan er GUI'en sat op til at vise på besøg billedet...
            new StreetField("Museet", "$2", "Se noget gammelt", 2),
            new StreetField("Biblioteket", "$2", "Se noget andet gammelt", 2),
            new ChanceField("?", "CHANCE", "Tag et chancekort"),
            new StreetField("Skaterparken", "$2", "Kom til skade", 2),
            new StreetField("Swimmingpoolen", "$2", "Mulighed for at drukne", 2),
            new EmptyField("default", "Gratis parkering", "Gratis parkering"),
            new StreetField("Spillehallen", "$3", "Ludomani kan forekomme", 3),
            new StreetField("Biografen", "$3", "Tag en lur", 3),
            new ChanceField("?", "CHANCE", "Tag et chancekort"),
            new StreetField("Legetøjsbutikken", "$3", "Bazookaer osv..", 3),
            new StreetField("Dyrehandlen", "$3", "Vi har kun pingviner", 3),
            new JailField("default", "Gå i fængslet", "Gå til fængsel"), //default fordi sådan er GUI'en sat op til at vise jail billedet HVIS på besøg allerede er vist før billedet...
            new StreetField("Bowlinghallen", "$4", "Vi har ingen bander!", 4),
            new StreetField("ZOO", "$4", "Find holger her", 4),
            new ChanceField("?", "CHANCE", "Tag et chancekort"),
            new StreetField("Vandlandet", "$5", "Drukne død version 2", 5),
            new StreetField("Strandpromenaden", "$5", "HUSK SOLCREME!", 5)
        };
    }

    public void setupGUI(){
        guiFields = new GUI_Field[fields.length];
        for(int i = 0;i<fields.length;i++){
            Field field = fields[i];
            switch(field.getClass().getSimpleName()){
                case "StartField":
                    guiFields[i] = new GUI_Start(field.getName(), field.getTooltip(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "StreetField":
                    guiFields[i] = new GUI_Street(field.getName(), field.getTooltip(), field.getDescription(), ((StreetField) field).getRentString(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "ChanceField":
                    guiFields[i] = new GUI_Chance(field.getName(), field.getTooltip(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "PrisonField":
                case "JailField":
                    guiFields[i] = new GUI_Jail(field.getName(), field.getTooltip(), field.getDescription(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "EmptyField":
                    guiFields[i] = new GUI_Refuge(field.getName(), field.getTooltip(), field.getDescription(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
            }
        }
        gui = new GUI(guiFields);
    }

    public void setupGUIPlayers(){
        // Sæt spillerne på GUI_Gameboard
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        GUI_Player guiPlayer;
        guiPlayers = new GUI_Player[players.length];
        for (int i = 0; i < players.length; i++) {
            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(colors[i]);
            int startingBalance = 20;
            if(players.length == 3){
                startingBalance = 18;
            }
            else if(players.length == 4){
                startingBalance = 16;
            }
            guiPlayer = new GUI_Player(players[i].getName(), startingBalance, car);
            players[i].getAccount().setBalance(guiPlayer, startingBalance);
            gui.addPlayer(guiPlayer);
            guiFields[0].setCar(guiPlayer, true); //start feltet
            guiPlayers[i] = guiPlayer;
        }
    }

    public void fieldAction(){

    }

    public boolean hasAnyoneLost(){
        for(Player player : players){
            if(player.getAccount().getBalance() < 0){
                return true;
            }
        }
        return false;
    }

    public void playGame() {
        Die d1, d2;
        d1 = new Die();
        d2 = new Die();

        int currentPlayerIndex = 0;
        Player currentPlayer;
        GUI_Player currentGUIPlayer;
        while (!gameOver) {
            currentPlayer = players[currentPlayerIndex];
            currentGUIPlayer = guiPlayers[currentPlayerIndex];

            //Kast terning
            gui.getUserButtonPressed("", "Kast terning"); //Her stopper koden indtil brugeren har klikket på knappen
            d1.rollDie();
            d2.rollDie();
            int d1Value = d1.getDie();
            int d2Value = d2.getDie();
            gui.setDice(d1Value, 0, 0, d2Value, 1, 0); //Se GUI docs for forklaring

            //Skift bil position
            currentPlayer.movePlayer(guiFields, currentGUIPlayer, d1Value, d2Value);

            //Når man lander på et felt skal der ske noget
            fieldAction();

            //checker om spillet skal stoppes
            if(hasAnyoneLost()){
                //der skal laves noget her med at spillet skal tjekke hvem der har tabt og skrive noget om vinderen..
                gameOver = true;
            }

            //tur slut
            currentPlayerIndex++;
            if(currentPlayerIndex == players.length) currentPlayerIndex = 0;
        }
    }

    public GameBoard() {
        setupPlayers();
        setupFields();
        setupGUI();
        setupGUIPlayers();

        playGame();
    }
}

