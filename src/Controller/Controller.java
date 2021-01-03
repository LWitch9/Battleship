package Controller;

import GUI.View;
import Game.GameManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private View view ;
    private GameManagement game ;
    private ArrayList<String> clicked; //TODO it is temporarily here

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
            //TODO
        }
    }

    class BattleListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("It works finally: Battle");
            //TODO
        }
    }
    class FieldListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            clicked.add(e.getActionCommand());
           if(clicked.size()==2){
                //Doing..
                int x1,y1,x2,y2;

                x1= clicked.get(0).charAt(0)-64;
                y1 = Integer.parseInt(clicked.get(0).substring(1));

                x2= clicked.get(1).charAt(0)-64;
                y2 = Integer.parseInt(clicked.get(1).substring(1));

                //TODO Add sth that will decide on which board it should be used
                // or maybe make to ActionListener classes for each board
                view.changeColorOfSpecificField(x1,y1,new Color(0,0,0));
                view.changeColorOfSpecificField(x2,y2,new Color(0,0,0));

                clicked.removeAll(clicked);

            }
            //else nothing - wait for more coordinates
            //TODO
        }
    }
}
