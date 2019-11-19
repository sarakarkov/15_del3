package Model;

import gui_fields.*;
import gui_main.GUI;
import java.util.Scanner;
import java.awt.*;


public class GameBoard {
    private boolean gameOver;
    private Player[] players;

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
            GUI_Street skatepark = new GUI_Street("Skateparken", "$2", "Hurtig hurtig", "2", new Color(255, 255, 128), Color.black);
            GUI_Street swimmingpool = new GUI_Street("Swimmingpoolen", "$2", "Svøm lille fisk", "2", new Color(255, 255, 128), Color.black);
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

                GUI_Player player;
            // Sæt spillerne på GUI_Gameboard
            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
            for (int i = 0; i < players.length; i++) {
                GUI_Car car = new GUI_Car();
                car.setPrimaryColor(colors[i]);
                Loser loser = new Loser();

                switch (players.length) {
                    case 2:
                         player = new GUI_Player(players[i].getName(), 20, car);
                        gui.addPlayer(player);
                        start.setCar(player, true);
                        break;
                    case 3:
                        player = new GUI_Player(players[i].getName(), 18, car);
                        gui.addPlayer(player);
                        start.setCar(player, true);
                        break;
                    case 4:
                         player = new GUI_Player(players[i].getName(), 16, car);
                        gui.addPlayer(player);
                        start.setCar(player, true);
                         break;
                    default:
                    break;
                }

            }



            }
        }




