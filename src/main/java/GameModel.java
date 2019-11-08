public class GameModel {
    private boolean gameOver;

    public PlayerModel p1, p2;
    public AccountModel a1, a2;

    public GameModel(PlayerModel p1, PlayerModel p2){
        this.gameOver = false;
        this.p1 = p1;
        this.p2 = p2;
        this.a1 = new AccountModel(p1);
        this.a2 = new AccountModel(p2);
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public void endGame(){
        gameOver = true;
    }
}

