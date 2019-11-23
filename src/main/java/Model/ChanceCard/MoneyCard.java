package Model.ChanceCard;

import Model.InterfaceGUI;
import Model.Player;

public class MoneyCard extends ChanceCard {
    private int income;

    public MoneyCard(String name, int income) {
        super(name);
        this.income = income;
    }

    public void playerGetIncome(Player player){
        player.getAccount().setBalance(player.getAccount().getBalance() + income);
        InterfaceGUI.setGuiPlayerBalance(player);
    }

    public void playerGetIncomeFromOther(Player player, Player[] players){
        for(Player otherPlayer : players){
            otherPlayer.getAccount().setBalance(otherPlayer.getAccount().getBalance() - income);
            player.getAccount().setBalance(player.getAccount().getBalance() + income);
            InterfaceGUI.setGuiPlayerBalance(otherPlayer);
        }
        InterfaceGUI.setGuiPlayerBalance(player);
    }
}
