package Game;

import ShipsManagement.ShipsManagement;

public class GameManagement {
    private final ShipsManagement player1;
    private final ShipsManagement player2;
    private GameState state;
    private WhichPlayer turn;

    public GameManagement() {
        this.player1 = new ShipsManagement(WhichPlayer.PLAYER1);
        this.player2 = new ShipsManagement(WhichPlayer.PLAYER2);
        this.state = GameState.SET_FAZE;
        this.turn = WhichPlayer.PLAYER1;
    }

    public ShipsManagement getPlayer1() {
        return player1;
    }

    public ShipsManagement getPlayer2() {
        return player2;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public WhichPlayer getTurn() {
        return turn;
    }

    public void setTurn(WhichPlayer turn) {
        this.turn = turn;
    }
}
