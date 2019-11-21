package Model;

import Model.Field.*;
import gui_fields.*;
import gui_main.GUI;
import java.util.Scanner;
import java.awt.*;

public class GameBoard {
    private boolean gameOver;
    private Player[] players;
    private GUI_Player[] guiPlayers;

    private Field[] fields;

    public void setupFields(){
        //Som en vilkårlig diskret forelæser kunne sige det. ORDER MATTERS!
        //Med andre ord det er har betydning hvilket index i listen hvert felt får fx så er Field[0] = startfeltet osv..
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

    public GameBoard() {
        initPlayers();

        setupFields();
        GUI_Field[] juniorFields = new GUI_Field[fields.length];
        for(int i = 0;i<fields.length;i++){
            Field field = fields[i];
            switch(field.getClass().getSimpleName()){
                case "StartField":
                    juniorFields[i] = new GUI_Start(field.getName(), field.getTooltip(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "StreetField":
                    juniorFields[i] = new GUI_Street(field.getName(), field.getTooltip(), field.getDescription(), ((StreetField) field).getRentString(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "ChanceField":
                    juniorFields[i] = new GUI_Chance(field.getName(), field.getTooltip(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "PrisonField":
                case "JailField":
                    juniorFields[i] = new GUI_Jail(field.getName(), field.getTooltip(), field.getDescription(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
                case "EmptyField":
                    juniorFields[i] = new GUI_Refuge(field.getName(), field.getTooltip(), field.getDescription(), field.getDescription(), field.getForegroundColor(), field.getBackgroundColor());
                    break;
            }
        }
        GUI gui = new GUI(juniorFields);

        // Sæt spillerne på GUI_Gameboard
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        GUI_Player player;
        guiPlayers = new GUI_Player[players.length];
        for (int i = 0; i < players.length; i++) {
            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(colors[i]);
            Loser loser = new Loser();

            switch (players.length) {
                case 2:
                     player = new GUI_Player(players[i].getName(), 20, car);
                    gui.addPlayer(player);
                    juniorFields[0].setCar(player, true);
                    guiPlayers[i] = player;
                    break;
                case 3:
                    player = new GUI_Player(players[i].getName(), 18, car);
                    gui.addPlayer(player);
                    juniorFields[0].setCar(player, true);
                    guiPlayers[i] = player;
                    break;
                case 4:
                     player = new GUI_Player(players[i].getName(), 16, car);
                    gui.addPlayer(player);
                    juniorFields[0].setCar(player, true);
                    guiPlayers[i] = player;
                     break;
                default:
                break;
            }

        }

        int playerIndex = 0;
        while(!gameOver){
            Player currentPlayer = players[playerIndex];
            gui.getUserButtonPressed("", "Kast terning");
            //Når koden når her til er der klikket på knappen
            Die d1 = new Die();
            Die d2 = new Die();
            d1.rollDie();
            d2.rollDie();

            int d1Value = d1.getDie();
            int d2Value = d2.getDie();

            gui.setDice(d1Value, 0, 0, d2Value, 1, 0);

            //Skift bil position
            juniorFields[currentPlayer.getPosition()].setCar(guiPlayers[playerIndex], false);
            currentPlayer.setPosition(currentPlayer.getPosition() + d1Value + d2Value);
            if(currentPlayer.getPosition() >= juniorFields.length){
                currentPlayer.setPosition(currentPlayer.getPosition() - juniorFields.length);
                //Giver penge når man lander eller passerer start
                //guiPlayers[playerIndex].setBalance(guiPlayers[playerIndex].getBalance() + new StartField().getBonus());
            }
            juniorFields[currentPlayer.getPosition()].setCar(guiPlayers[playerIndex], true);

            System.out.println(juniorFields[currentPlayer.getPosition()].getClass().getSimpleName());


            switch (juniorFields[currentPlayer.getPosition()].getClass().getSimpleName()){
                case "GUI_Start":
                    GUI_Start guiStart = (GUI_Start) juniorFields[currentPlayer.getPosition()];
                    break;
                case "GUI_Street":
                    GUI_Street guiStreet = (GUI_Street) juniorFields[currentPlayer.getPosition()];
                    if(guiStreet.getOwnerName() == null){
                        guiPlayers[playerIndex].setBalance(guiPlayers[playerIndex].getBalance() - Integer.parseInt(guiStreet.getRent()));
                        guiStreet.setOwnerName(currentPlayer.getName());
                    }
                    else if(guiStreet.getOwnerName() != currentPlayer.getName()){
                        int rent = Integer.parseInt(guiStreet.getRent());
                        guiPlayers[playerIndex].setBalance(guiPlayers[playerIndex].getBalance() - rent);
                        GUI_Player guiOwner = getGUIPlayer(guiStreet.getOwnerName());
                        guiOwner.setBalance(guiOwner.getBalance() + rent);
                    }
                    break;
                case "GUI_Refuge":
                    GUI_Refuge guiRefuge = (GUI_Refuge) juniorFields[currentPlayer.getPosition()];
                    //Gør ikke en skid
                    break;
                case "GUI_Chance":
                    GUI_Chance guiChance = (GUI_Chance) juniorFields[currentPlayer.getPosition()];
                    //ChanceField chanceField = new ChanceField();
                    //ChanceCard chanceCard = chanceField.getRandomCard();
                    //gui.displayChanceCard(chanceCard.getName());
                    //chanceCard.action(juniorFields, currentPlayer, guiPlayers[playerIndex],guiPlayers,players);
                    break;
                case "GUI_Jail":
                    GUI_Jail guiJail = (GUI_Jail) juniorFields[currentPlayer.getPosition()];
                    //if(guiJail == gotoJail){
                        guiJail.setCar(guiPlayers[playerIndex], false);
                        //visitJail.setCar(guiPlayers[playerIndex], true);
                        currentPlayer.setPosition(6);
                        guiPlayers[playerIndex].setBalance(guiPlayers[playerIndex].getBalance() - 1);
                    //}
                    //if(guiJail == visitJail){
                        //Ingen ting sker her
                    //}
                    break;
            }

            playerIndex++;
            if(playerIndex == players.length) playerIndex = 0;
        }
    }

    public GUI_Player getGUIPlayer(String name){
        for(GUI_Player guiPlayer : guiPlayers){
            if(guiPlayer.getName().equals(name)){
                return guiPlayer;
            }
        }
        return null; //Må ikke kunne lade sig gøre fordi så eksisterer spilleren ikke
    }

    public void initPlayers() {
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
                players[i] = new Player(i, playerName);
            }else {
                i--;
                System.out.println("Navnet eksisterer allerede.");
            }
        }
        System.out.println("Spillet begynder");
    }
}

