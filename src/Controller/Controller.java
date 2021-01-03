package Controller;

import GUI.View;
import Game.GameManagement;
import Game.WhichPlayer;
import ShipsManagement.ShipsManagement;
import board.Coordinate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private View view ;
    private GameManagement game ;
    private ArrayList<String> clicked;

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
                this.settingShipGrneral(clicked);
                clicked.removeAll(clicked);
            }



        }

        private void settingShipGrneral(ArrayList<String > clicked){
            int x1,y1,x2,y2;

            x1= clicked.get(0).charAt(0)-64;
            y1 = Integer.parseInt(clicked.get(0).substring(1));

            x2= clicked.get(1).charAt(0)-64;
            y2 = Integer.parseInt(clicked.get(1).substring(1));

            ShipsManagement actualPlayer;

            if(game.getPlayer1().getOwner() == game.getTurn())
                actualPlayer = game.getPlayer1();
            else
                actualPlayer = game.getPlayer2();

            actualPlayer.setShip(x1,y1,x2,y2);
            Boolean result = actualPlayer.getActionFinishedProperly();

            view.displayMessageOnCommunicationLabel(actualPlayer.getResultCommunicat());
            if(result){
                //Success
                //Put ship on view
                setShipOnView(actualPlayer,game.getTurn());
            }

        }
        private void setShipOnView(ShipsManagement actualPlayer, WhichPlayer turn){
            for(Coordinate coor :actualPlayer.getShipsContainer().getLastShip().getCoordinates()){
                view.changeColorOfSpecificField(coor.getX(),coor.getY(),new Color(0,0,0), turn);
                view.setSpecificFieldEnabled(coor.getX(),coor.getY(),false, turn);

            }

        }
    }
}
