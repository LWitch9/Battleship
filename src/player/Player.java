package player;

import ShipsManagement.ShipsManagement;

public class Player {
    private final String name;
    private ShipsManagement shipsManagement;

    public Player(String name) {
        this.name = name;
        this.shipsManagement = new ShipsManagement();
    }
    public void setShip(int x1, int y1, int x2, int y2){
        shipsManagement.setShip(x1, y1, x2, y2);
    }
    public void shoot(int x, int y){
        shipsManagement.hit(x,y);
    }
}
