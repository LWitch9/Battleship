package Main;

import player.Player;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("First");
        player.setShip(2,1,2,3);
        //player.setShip(2,1,2,3);
        player.setShip(2,2,4,2);
        player.shoot(2,2);
        //player.shoot(2,1);
        //player.shoot(2,3);
    }
}
