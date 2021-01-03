package Controller;

import GUI.View;
import Game.GameManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private View view ;
    private GameManagement game ;
    private ArrayList<Integer> clicked; //TODO it is temporarily here

    public Controller(View view , GameManagement game) {
        this.clicked = new ArrayList<>();
        this.view = view;
        this.game = game;
        this.viewInit();
    }

    public void viewInit(){
        view.addFieldsListener(new FieldListener());
        view.addResetListener(new ResetListener());
        view.addBattleListener(new BattleListener());
    }

    class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("It works finally: Reset");
        }
    }

    class BattleListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("It works finally: Battle");
        }
    }
    class FieldListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }
}
