package Model;

import Model.ChanceCard.*;
import Model.Field.*;

import java.awt.*;
import java.util.Scanner;

public class GameBoard {
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
                Account account = new Account(20);;
                if(totalPlayers == 3) account = new Account(18);
                else if(totalPlayers == 4) account = new Account(16);
                players[i] = new Player(playerName, account);
            }else {
                i--;
                System.out.println("Navnet eksisterer allerede.");
            }
        }
        System.out.println("Spillet begynder. GUI'en bliver åbnet.");
    }

    public void setupFields(){
        fields = new Field[]{
            new StartField("Start", "Modtag: $1", "Modtag $1, når du passerer start"), //0
            new StreetField("Burgerbaren", "$1", "Bli tyk her", 1, new Color(165,42,42)), //1
            new StreetField("Pizzahuset", "$1", "Bli også tyk her", 1, new Color(165,42,42)), //2
            new ChanceField("?", "CHANCE", "Tag et chancekort"), //3
            new StreetField("Slikbutikken", "$1", "Slik noget", 1, new Color(135,210,255)), //4
            new StreetField("Iskiosken", "$1", "Bli kølet ned", 1, new Color(135,210,255)), //5
            new JailField("default", "Besøg fængslet", "På besøg"), //6
            new StreetField("Museet", "$2", "Se noget gammelt", 2, Color.pink), //7
            new StreetField("Biblioteket", "$2", "Se noget andet gammelt", 2, Color.pink), //8
            new ChanceField("?", "CHANCE", "Tag et chancekort"), //9
            new StreetField("Skaterparken", "$2", "Kom til skade", 2, new Color(255,153,51)), //10
            new StreetField("Swimmingpoolen", "$2", "Mulighed for at drukne", 2, new Color(255,153,51)), //11
            new RefugeField("default", "Gratis parkering", "Gratis parkering"), //12
            new StreetField("Spillehallen", "$3", "Ludomani kan forekomme", 3, Color.red), //13
            new StreetField("Biografen", "$3", "Tag en lur", 3, Color.red), //14
            new ChanceField("?", "CHANCE", "Tag et chancekort"), //15
            new StreetField("Legetøjsbutikken", "$3", "Bazookaer osv..", 3, Color.yellow), //16
            new StreetField("Dyrehandlen", "$3", "Vi har kun pingviner", 3, Color.yellow), //17
            new JailField("default", "Gå i fængslet", "Gå til fængsel"), //18
            new StreetField("Bowlinghallen", "$4", "Vi har ingen bander!", 4, new Color(36,154,50, 253)), //19
            new StreetField("ZOO", "$4", "Find holger her", 4, new Color(36,154,50, 253)), //20
            new ChanceField("?", "CHANCE", "Tag et chancekort"), //21
            new StreetField("Vandlandet", "$5", "Drukne død version 2", 5, Color.blue), //22
            new StreetField("Strandpromenaden", "$5", "HUSK SOLCREME!", 5, Color.blue) //23
        };
    }

    public GameBoard() {
        setupPlayers();
        setupFields();

        InterfaceGUI.InitGui(fields, players);

        playGame();
    }

    public void playGame(){
        Die d1, d2;
        d1 = new Die();
        d2 = new Die();


        int currentPlayerIndex = 0;
        boolean gameover = false;
        while(!gameover){
            Player currentPlayer = players[currentPlayerIndex];
            InterfaceGUI.showGuiText("Nu er det " + currentPlayer.getName() + "'s tur.");

            InterfaceGUI.waitDicesBtnClicked();
            d1.rollDie();
            d2.rollDie();
            InterfaceGUI.setDices(d1.getDie(), d2.getDie());
            currentPlayer.setFieldPosition(currentPlayer.getFieldPosition() + d1.getDie() + d2.getDie(), fields);

            if(currentPlayer.isJailed()){
                if(currentPlayer.hasJailCard()) {
                    currentPlayer.setJailCard(false);
                    InterfaceGUI.showGuiText("Spiller " + currentPlayer.getName() + " brugte sit fængsel kort til at komme ud af fængslet");
                }
                else {
                    currentPlayer.getAccount().setBalance(currentPlayer.getAccount().getBalance() - 1);
                    InterfaceGUI.setGuiPlayerBalance(currentPlayer);
                    InterfaceGUI.showGuiText("Spiller " + currentPlayer.getName() + " betalte 1$ for at komme ud af fængslet");
                }
                currentPlayer.setJailed(false);
            }

            fieldAction(currentPlayer, false);

            if(hasSomeoneLost()){
                gameover = true;
            }

            InterfaceGUI.showGuiText("Spiller " + currentPlayer.getName() + "'s tur er slut.");
            currentPlayerIndex++;
            if(currentPlayerIndex >= players.length) currentPlayerIndex = 0;
        }
    }

    public boolean hasSomeoneLost(){
        Player richestPlayer = players[0];
        for(Player player : players){
            if(player.getAccount().getBalance() > richestPlayer.getAccount().getBalance()){
                richestPlayer = player;
            }
            if(player.getAccount().getBalance() < 0){
                InterfaceGUI.showGuiText("Spillet slutter da " + player.getName() + " har tabt. Vinderen, den rigeste spiller, er " + richestPlayer.getName());
                return true;
            }
        }
        return false;
    }

    public void fieldAction(Player player, boolean freeStreet){
        Field field = fields[player.getFieldPosition()];
        switch(field.getClass().getSimpleName()){
            case "StartField":
                //Gør ingen ting da bonusen ikke kun bliver modtaget når man lander på feltet men også når man passerer derfor er dette lavet længere oppe. (movePlayer)
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " landede på start feltet.");
                break;
            case "StreetField":
                StreetField streetField = ((StreetField) field);

                Player owner = streetField.getOwner();
                if(owner != null){
                    if(owner == player){
                        InterfaceGUI.showGuiText("Spiller " + player.getName() + " landede på grunden " + streetField.getName() + " og hyggede sig på sin egen grund ");
                    }else {
                        owner.getAccount().setBalance(owner.getAccount().getBalance() + streetField.getRent());
                        player.getAccount().setBalance(player.getAccount().getBalance() - streetField.getRent());
                        InterfaceGUI.setGuiPlayerBalance(player);
                        InterfaceGUI.setGuiPlayerBalance(owner);
                        InterfaceGUI.showGuiText("Spiller " + player.getName() + " landede på grunden " + streetField.getName() + " og betalte leje til " + owner.getName());
                    }
                }else{
                    streetField.setOwner(player);
                    if(freeStreet){
                        InterfaceGUI.setGuiFieldOwner(streetField, player);
                        InterfaceGUI.showGuiText("Spiller " + player.getName() + " landede på grunden " + streetField.getName() + " og fik det gratis det.");
                    }else{
                        player.getAccount().setBalance(player.getAccount().getBalance() - streetField.getRent());
                        InterfaceGUI.setGuiPlayerBalance(player);
                        InterfaceGUI.setGuiFieldOwner(streetField, player);
                        InterfaceGUI.showGuiText("Spiller " + player.getName() + " landede på grunden " + streetField.getName() + " og købte det.");
                    }
                }
                break;
            case "ChanceField":
                chanceCardAction(player, ((ChanceField) field));
                break;
            case "JailField":
                if(player.getFieldPosition() == 18) { //18 er gå til fængsel og 6 er besøg fængsel (6 gør intet)
                    player.setFieldPosition(6, fields);
                    player.setJailed(true);
                    InterfaceGUI.showGuiText("Spiller " + player.getName() + " er røget i fængsel.");
                }else{
                    InterfaceGUI.showGuiText("Spiller " + player.getName() + " er på besøg i fængslet.");
                }
                break;
            case "RefugeField":
                //Gør ingen ting. Det er et pause felt
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " tager en pause på pause feltet.");
                break;
        }
    }

    public void chanceCardAction(Player player, ChanceField chanceField){
        int cardIndex = chanceField.getRandomCardIndex();
        ChanceCard chanceCard = chanceField.getChanceCard(cardIndex);
        InterfaceGUI.setGuiCard(chanceCard.getName());
        InterfaceGUI.showGuiText("Spiller " + player.getName() + " trækker et chancekort.");
        switch(cardIndex){
            case 0:
            case 8:
                MoveToCard moveToCard = (MoveToCard) chanceCard;
                moveToCard.movePlayerToPosition(player, fields);
                InterfaceGUI.hideGuiCard();
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " har fået rykket sin position.");
                fieldAction(player, false);
            break;


            case 1:
                MoveForwardCard moveForwardCard1 = (MoveForwardCard) chanceCard;
                moveForwardCard1.movePlayer(player, fields);
                InterfaceGUI.hideGuiCard();
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " har fået rykket sin position.");
                fieldAction(player, false);
            break;
            case 3:
                MoveForwardCard moveForwardCard2 = (MoveForwardCard) chanceCard;
                moveForwardCard2.movePlayer(player, fields);
                InterfaceGUI.hideGuiCard();
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " har fået rykket sin position og skal trække et kort mere efter spilleren har foretaget aktionen på den nye position.");
                fieldAction(player, false);
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " trækker nu sit ekstra chance kort.");
                chanceCardAction(player, chanceField); //Rekursivt kald
            break;


            case 2:
            case 5:
            case 6:
            case 10:
            case 12:
            case 13:
                FreeCard freeCard = (FreeCard) chanceCard;
                freeCard.moveToRandomColorField(player, fields);
                InterfaceGUI.hideGuiCard();
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " har fået rykket sin position og skal nu foretage en aktion på den grund han er landet på.");
                fieldAction(player, true);
            break;


            case 4:
            case 11:
                MoneyCard moneyCard1 = (MoneyCard) chanceCard;
                moneyCard1.playerGetIncome(player); //Hvis det er kort 5 (index 4) så mister spilleren 2
                InterfaceGUI.hideGuiCard();
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " har fået opdateret sin balance.");
            break;
            case 9:
                MoneyCard moneyCard2 = (MoneyCard) chanceCard;
                moneyCard2.playerGetIncomeFromOther(player, players);
                InterfaceGUI.hideGuiCard();
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " har fået penge fra de andre spillere");
            break;


            case 7:
                JailCard jailCard = (JailCard) chanceCard;
                jailCard.activateOnPlayer(player);
                InterfaceGUI.hideGuiCard();
                InterfaceGUI.showGuiText("Spiller " + player.getName() + " har fået et fængsel kort.");
            break;
        }
    }
}

