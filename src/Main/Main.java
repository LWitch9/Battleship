package Main;

import Controller.Controller;
import GUI.View;
import Game.GameManagement;
import Game.WhichPlayer;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        GameManagement game = new GameManagement();
        Controller controller = new Controller(view, game);
    }
}
