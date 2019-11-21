package Model.Field;

import Model.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.util.Random;

public class ChanceCard {
    private String name;
    private String action;

    public ChanceCard(String name, String action){
        this.name = name;
        this.action = action;
    }

    public String getName(){
        return name;
    }

//    public void action(GUI_Field[] juniorFields, Player player, GUI_Player guiPlayer,GUI_Player[] guiPlayers,Player[] players){
//        switch(action){
//            case "#1":
//                juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                int startIndex = 0;
//                player.setPosition(startIndex);
//                juniorFields[startIndex].setCar(guiPlayer, true);
//                guiPlayer.setBalance(guiPlayer.getBalance() + 2);
//                break;
//            case "#2":
//                juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                int position5 = player.getPosition() + 5;
//                player.setPosition(position5);
//                juniorFields[position5].setCar(guiPlayer, true);
//                // Actionen skal kaldes på den nye grund man lander på
//                break;
//            case "#3":
//                int orangeMin = 10;
//                int orangeMax = 11;
//                int rangeOrange = orangeMax - orangeMin + 1;
//                for (int i = orangeMin; i < orangeMax; i++){
//                    int randomOrange = (int) (Math.random() * rangeOrange) +orangeMin;
//                    juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                    player.setPosition(randomOrange);
//                    juniorFields[randomOrange].setCar(guiPlayer, true);
//                }
//                // Action mangler, skal købe grund når man lander + Gratis felt
//                break;
//            case "#4":
//                juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                int position1 = player.getPosition() + 1;
//                player.setPosition(position1);
//                juniorFields[position1].setCar(guiPlayer, true);
//                // Action skal kaldes - træk et kort mere
//                break;
//            case "#5":
//                guiPlayer.setBalance(guiPlayer.getBalance() - 2);
//                break;
//            case "#6":
//                int greenMin = 19;
//                int greenMax = 20;
//                int rangeGreen = greenMax - greenMin + 1;
//                for (int i=greenMin; i<greenMax;i++){
//                    int greenRandom = (int) (Math.random() * rangeGreen) +greenMin;
//                    juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                    player.setPosition(greenRandom);
//                    juniorFields[greenRandom].setCar(guiPlayer, true);
//                }
//                // Action mangler, skal købe grund når man lander + Gratis felt
//                break;
//            case "#7":
//                int lightblueMin = 4;
//                int lightblueMax = 5;
//                int rangelightblue = lightblueMax - lightblueMin + 1;
//                for (int i=lightblueMin; i<lightblueMax;i++){
//                    int lightblueRandom = (int) (Math.random() * rangelightblue) +lightblueMin;
//                    juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                    player.setPosition(lightblueRandom);
//                    juniorFields[lightblueRandom].setCar(guiPlayer, true);
//                }
//                // Action mangler, skal købe grund når man lander + Gratis felt
//                break;
//            case "#8":
//                break;
//            case "#9":
//                juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                int position23 = 23;
//                player.setPosition(position23);
//                juniorFields[position23].setCar(guiPlayer, true);
//                // Action mangler, skal købe grund når man lander
//                break;
//            case "#10":
//                for(int i=0; i<guiPlayers.length;i++){
//                    if(!guiPlayer.getName().equals(guiPlayers[i].getName())){
//                        guiPlayers[i].setBalance(guiPlayers[i].getBalance() - 1);
//                    }
//                    else{
//                            guiPlayer.setBalance(guiPlayer.getBalance() + 1);
//                    }
//                }
//                break;
//            case "#11":
//                break;
//            case "#12":
//                guiPlayer.setBalance(guiPlayer.getBalance() - 3);
//                break;
//            case "#13":
//                int redMin = 13;
//                int redMax = 14;
//                int rangeRed = redMax - redMin + 1;
//                for (int i=redMin; i<redMax;i++){
//                    int redRandom = (int) (Math.random() * rangeRed) +redMin;
//                    juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                    player.setPosition(redRandom);
//                    juniorFields[redRandom].setCar(guiPlayer, true);
//                }
//                // Action mangler, skal købe grund når man lander + Gratis felt
//                break;
//            case "#14":
//                juniorFields[player.getPosition()].setCar(guiPlayer, false);
//                int position10 = 10;
//                player.setPosition(position10);
//                juniorFields[position10].setCar(guiPlayer, true);
//                break;
//        }
//    }
}
