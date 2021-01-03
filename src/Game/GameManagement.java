package Game;

public class GameManagement {
    private final Player player1;
    private final Player player2;
    private GameState state;
    private WhichPlayer player;

    public GameManagement() {
        this.player1 = new Player("Gracz1");
        this.player2 = new Player("Gracz2");
        this.state = GameState.SET_FAZE;
        this.player = WhichPlayer.PLAYER1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public WhichPlayer getPlayer() {
        return player;
    }

    public void setPlayer(WhichPlayer player) {
        this.player = player;
    }
}
