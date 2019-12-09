package Model.ChanceCard;

import Model.InterfaceGUI;
import Model.Player;


// Nedarver metoder fra ChanceCard
public class MoneyCard extends ChanceCard {

    // Opretter atributten income
    private int income;


    // Set-konstruktor til at sætte værdien for navn og income
    public MoneyCard(String name, int income) {
        super(name);
        this.income = income;
    }


    // Get metode så man kan hente den nye income
    public void playerGetIncome(Player player){
        player.getAccount().setBalance(player.getAccount().getBalance() + income);
        InterfaceGUI.setGuiPlayerBalance(player); //Ændrer i GUI
    }


    // Get metode til at hente income fra de andre spillere
    public void playerGetIncomeFromOther(Player player, Player[] players){
        // For loop som trækker income fra de andre spiller og ligger det til spilleren selv
        for(Player otherPlayer : players){
            otherPlayer.getAccount().setBalance(otherPlayer.getAccount().getBalance() - income);
            player.getAccount().setBalance(player.getAccount().getBalance() + income);
            InterfaceGUI.setGuiPlayerBalance(otherPlayer);
        }
        InterfaceGUI.setGuiPlayerBalance(player); //Sætter den nye balance for spillerne i GUI
    }
}
