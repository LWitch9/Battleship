package Controller;

import GUI.View;
import Game.GameManagement;

public class Controller {
    private View v ;
    private GameManagement game ;

    public Controller() {
        this.v = new View();
        this.game = new GameManagement();
    }
}
