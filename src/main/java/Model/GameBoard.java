package Model;

import Model.Field.ChanceCard;
import Model.Field.ChanceField;
import Model.Field.StartField;
import gui_fields.*;
import gui_main.GUI;
import java.util.Scanner;
import java.awt.*;

public class GameBoard {
    private boolean gameOver;
    private Player[] players;
    private GUI_Player[] guiPlayers;

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

    public GameBoard() {
            initPlayers();

            GUI_Start start = new GUI_Start("Start", "Modtag: $2", "Modtag $2, når du passerer start", Color.white, Color.black);
            GUI_Street burgerbar = new GUI_Street("Burgerbaren", "$1", "Spis en burger", "1", new Color(165, 42, 42), Color.black);
            GUI_Street pizzahouse = new GUI_Street("Pizzahuset", "$1", "Spis en pizza", "1", new Color(165, 42, 42), Color.black);
            GUI_Chance chance1 = new GUI_Chance("?", "CHANCE", "Tag et chancekort", Color.white, Color.black);
            GUI_Street candyshop = new GUI_Street("Slikbutikken", "$1", "Slik her", "1", new Color(135, 210, 255), Color.black);
            GUI_Street iceshop = new GUI_Street("Iskiosken", "$1", "Is her", "1", new Color(135, 210, 255), Color.black);
            GUI_Jail visitJail = new GUI_Jail("default", "Besøg fængslet", "På besøg", "Du er på besøg i fængslet", Color.white, Color.black);
            GUI_Street museum = new GUI_Street("Museet", "$2", "Se flotte ting her", "2", Color.pink, Color.black);
            GUI_Street library = new GUI_Street("Biblioteket", "$2", "Læs bøger her", "2", Color.pink, Color.black);
            GUI_Chance chance2 = new GUI_Chance("?", "CHANCE", "Tag et chancekort", Color.white, Color.black);
            GUI_Street skatepark = new GUI_Street("Skateparken", "$2", "Hurtig hurtig", "2", new Color(255, 153, 51), Color.black);
            GUI_Street swimmingpool = new GUI_Street("Swimmingpoolen", "$2", "Svøm lille fisk", "2", new Color(255, 153, 51), Color.black);
            GUI_Refuge pause = new GUI_Refuge("default", "Gratis parkering", "Gratis parkering", "Gratis parkering", Color.white, Color.black);
            GUI_Street arcade = new GUI_Street("Spillehallen", "$3", "Spillehallen", "3", Color.red, Color.black);
            GUI_Street cinema = new GUI_Street("Biografen", "$3", "Biografen", "3", Color.red, Color.black);
            GUI_Chance chance3 = new GUI_Chance("?", "CHANCE", "Tag et chancekort", Color.white, Color.black);
            GUI_Street toystore = new GUI_Street("Legetøjsbutikken", "$3", "Legetøjsbutikken", "3", Color.yellow, Color.black);
            GUI_Street petshop = new GUI_Street("Dyrehandlen", "$3", "Dyrehandlen", "3", Color.yellow, Color.black);
            GUI_Jail gotoJail = new GUI_Jail("default", "Gå i fængslet", "Gå til fængsel", "Du skal i fængsel!!", Color.white, Color.black);
            GUI_Street bowling = new GUI_Street("Bowlinghallen", "$4", "Bowlinghallen", "4", new Color(36, 154, 50, 253), Color.black);
            GUI_Street zoo = new GUI_Street("ZOO", "$4", "ZOO", "4", new Color(36, 154, 50, 253), Color.black);
            GUI_Chance chance4 = new GUI_Chance("?", "CHANCE", "Tag et chancekort", Color.white, Color.black);
            GUI_Street waterpark = new GUI_Street("Vandlandet", "$5", "Vandlandet", "5", Color.blue, Color.black);
            GUI_Street seafront = new GUI_Street("Strandpromenaden", "$5", "Strandpromenaden", "5", Color.blue, Color.black);

            GUI_Field[] juniorFields = new GUI_Field[]{
                    start, burgerbar, pizzahouse, chance1, candyshop, iceshop, visitJail, museum, library, chance2, skatepark, swimmingpool,
                    pause, arcade, cinema, chance3, toystore, petshop, gotoJail, bowling, zoo, chance4, waterpark, seafront
            };
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
                        start.setCar(player, true);
                        guiPlayers[i] = player;
                        break;
                    case 3:
                        player = new GUI_Player(players[i].getName(), 18, car);
                        gui.addPlayer(player);
                        start.setCar(player, true);
                        guiPlayers[i] = player;
                        break;
                    case 4:
                         player = new GUI_Player(players[i].getName(), 16, car);
                        gui.addPlayer(player);
                        start.setCar(player, true);
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
                    guiPlayers[playerIndex].setBalance(guiPlayers[playerIndex].getBalance() + new StartField().getBonus());
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
                        ChanceField chanceField = new ChanceField();
                        ChanceCard chanceCard = chanceField.getRandomCard();
                        gui.displayChanceCard(chanceCard.getName());
                        chanceCard.action(juniorFields, currentPlayer, guiPlayers[playerIndex],guiPlayers,players);
                        break;
                    case "GUI_Jail":
                        GUI_Jail guiJail = (GUI_Jail) juniorFields[currentPlayer.getPosition()];
                        if(guiJail == gotoJail){
                            guiJail.setCar(guiPlayers[playerIndex], false);
                            visitJail.setCar(guiPlayers[playerIndex], true);
                            currentPlayer.setPosition(6);
                            guiPlayers[playerIndex].setBalance(guiPlayers[playerIndex].getBalance() - 1);
                        }
                        if(guiJail == visitJail){
                            //Ingen ting sker her
                        }
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
    }

