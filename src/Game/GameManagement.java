package Game;

import ShipsManagement.ShipsManagement;

public class GameManagement {
    private ShipsManagement player1;
    private ShipsManagement player2;
    private GameState state;
    private WhichPlayer turn;

    public GameManagement() {
        this.player1 = new ShipsManagement(WhichPlayer.PLAYER1);
        this.player2 = new ShipsManagement(WhichPlayer.PLAYER2);
        this.state = GameState.SET_PHASE;
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

    public void setPlayer1(ShipsManagement player1) {
        this.player1 = player1;
    }

    public void setPlayer2(ShipsManagement player2) {
        this.player2 = player2;
    }
}
