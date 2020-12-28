import ShipsManagement.ShipsManagement;
import board.Board;

public class Player {
    private final String name;
    private ShipsManagement shipsManagement;

    public Player(String name) {
        this.name = name;
        this.shipsManagement = new ShipsManagement();
    }
}
