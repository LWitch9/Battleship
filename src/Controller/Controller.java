package Controller;

import GUI.View;
import Game.GameManagement;

import Game.GameState;

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
    private boolean isTimeForShootFaze;


    public Controller(View view , GameManagement game) {
        this.isTimeForShootFaze = false;
        this.clicked = new ArrayList<>();
        this.view = view;
        this.game = game;
        this.viewInit();
    }

    private void viewInit(){
        view.setBoardEnabled(false, WhichPlayer.PLAYER2);
        view.addListenerToFields(new FieldListener());
        view.addListenerToResetButton(new ResetListener());
        view.addListenerToBattleButton(new BattleListener());
    }

    class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("It works finally: Reset");
            //TODO Reset
            /*
            * TODO
            *  change gamestate to SET_FAZE
            *   change turn to Player1
            *   remove ShipManagements of Players and replace it with new one
            *   Reset BoardView
            * */

            clicked.removeAll(clicked);
            isTimeForShootFaze = false;
            game.setPlayer1(new ShipsManagement(WhichPlayer.PLAYER1));
            game.setPlayer2(new ShipsManagement(WhichPlayer.PLAYER2));

            game.setState(GameState.SET_PHASE);
            game.setTurn(WhichPlayer.PLAYER1);

            view.resetBoards();
            view.setBoardEnabled(false,WhichPlayer.PLAYER2);
            view.displayMessageOnCommunicationLabel("Reset ...");
        }
    }

    class BattleListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            //TODO dodaj zabezpiecznia ( nie można wcisnąć dopóki nie rozstawione wszystkie statki gracza)
            //OO zrób tak: dodać do GameState SET_FaZe_END_FOR_PLAYER - i tylko w tym stanie można wcisnać battle

            //Przypadek gdy mozna wcisnąć battle
            if(game.getState() == GameState.SET_PHASE_END_FOR_PLAYER){
                if(!isTimeForShootFaze){
                    game.setState(GameState.SET_PHASE);
                    game.setTurn(WhichPlayer.PLAYER2);

                    clicked.removeAll(clicked);
                    view.setBoardEnabled(false, WhichPlayer.PLAYER1);
                    view.changeColorOfBoard(new Color(255,255,255),WhichPlayer.PLAYER1 );
                    view.setBoardEnabled(true, WhichPlayer.PLAYER2);
                    isTimeForShootFaze =true;
                    view.displayMessageOnCommunicationLabel(""+Messages.WHO_STARTS);
                }
                else{
                    clicked.removeAll(clicked);
                    game.setState(GameState.SHOOT_PHASE);
                    //TODO losowanie gracza - tymczasowo zaczyna drugi
                    game.setTurn(WhichPlayer.PLAYER2);

                    view.setBoardEnabled(false, WhichPlayer.PLAYER2);
                    view.changeColorOfBoard(new Color(255,255,255),WhichPlayer.PLAYER2 );
                    view.setBoardEnabled(true, WhichPlayer.PLAYER1);
                    view.displayMessageOnCommunicationLabel(""+Messages.WELCOME+Messages.WHO_STARTS);
                }
            }
            else if(game.getState() == GameState.SET_PHASE){
                view.displayMessageOnCommunicationLabel(""+Messages.NOT_ALL_SHIPS_SET);
            }
            else if(game.getState() == GameState.SHOOT_PHASE){
                view.displayMessageOnCommunicationLabel(""+Messages.ALREADY_IN_BATTLE);
            }
            else{
                //Komunikat ( najpierw wciśnij reset blah blah)
                view.displayMessageOnCommunicationLabel(""+Messages.END);
            }


        }
    }
    class FieldListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO remove
            //System.out.println(e.getActionCommand());
            clicked.add(e.getActionCommand());

            if(game.getState() == GameState.SET_PHASE){
                if(clicked.size()==2){
                    this.settingShipGeneral(clicked);
                    clicked.removeAll(clicked);
                }
            }
            else if(game.getState() == GameState.SHOOT_PHASE){
                this.shootingShipGeneral(clicked);
                clicked.removeAll(clicked);
            }
        }

        private void shootingShipGeneral(ArrayList<String > clicked){
            int x1,y1;

            x1= clicked.get(0).charAt(0)-64;
            y1 = Integer.parseInt(clicked.get(0).substring(1));

            ShipsManagement activeBoardShipManagement; // opposite of game.getTurn
            ShipsManagement actualPlayer; // equals game.getTurn
            WhichPlayer activeBoardPlayer; // opposite of game.getTurn

            //Active board != active player

            if(game.getPlayer1().getOwner() == game.getTurn()){
                activeBoardShipManagement = game.getPlayer2();
                activeBoardPlayer = WhichPlayer.PLAYER2;

            }
            else{
                activeBoardShipManagement = game.getPlayer1();
                activeBoardPlayer = WhichPlayer.PLAYER1;

            }


            activeBoardShipManagement.hit(x1,y1);
            Boolean result = activeBoardShipManagement.getActionFinishedSuccessfully();

            view.displayMessageOnCommunicationLabel(""+activeBoardShipManagement.getResultCommunicat());
            if(result){
                //Success
                //Put hit on view - trafiony zatopiony
                setHitOnView(x1,y1,activeBoardPlayer,new Color(255, 0, 0));
                if(activeBoardShipManagement.getShipsContainer().getSize() == 0){
                    endGame(activeBoardPlayer);
                }

            }
            else{
                setHitOnView(x1,y1,activeBoardPlayer,new Color(0, 255, 238));
                changeTurnDuringShootingPhase(activeBoardPlayer);
            }

        }
        private void settingShipGeneral(ArrayList<String > clicked){
            int x1,y1,x2,y2;

            x1= clicked.get(0).charAt(0)-64;
            y1 = Integer.parseInt(clicked.get(0).substring(1));

            x2= clicked.get(1).charAt(0)-64;
            y2 = Integer.parseInt(clicked.get(1).substring(1));

            ShipsManagement activeBoard;

            //Active board == active player
            if(game.getPlayer1().getOwner() == game.getTurn())
                activeBoard = game.getPlayer1();
            else
                activeBoard = game.getPlayer2();

            activeBoard.setShip(x1,y1,x2,y2);
            Boolean result = activeBoard.getActionFinishedSuccessfully();

            view.displayMessageOnCommunicationLabel(""+activeBoard.getResultCommunicat());
            if(result){
                //Success
                //Put ship on view
                setShipOnView(activeBoard,game.getTurn());
                //TODO Dodaj coś aby wcześniej zmienić stan game.setState(GameState.SET_FAZE_END_FOR_PLAYER);
                //Aktualnei stan zmienia się nie bezpośrednio po ustawieniu ostatniego statku
                //a dopiero po tym jak kolejny raz kliknie się dwukrotnie (co zostanie odczytane jako niepoprawne ustawinie)

            }
            else{
                if(activeBoard.getResultCommunicat() == Messages.ALL_SHIPS_SET){
                     game.setState(GameState.SET_PHASE_END_FOR_PLAYER);
                }
            }

        }
        private void setShipOnView(ShipsManagement actualPlayer, WhichPlayer turn) {
            for (Coordinate coor : actualPlayer.getShipsContainer().getLastShip().getCoordinates()) {
                view.changeColorOfSpecificField(coor.getX(), coor.getY(), new Color(0, 0, 0), turn);
                view.setSpecificFieldEnabled(coor.getX(), coor.getY(), false, turn, false);
            }
        }
        private void setHitOnView( int x, int y, WhichPlayer activeBoard, Color color){
            view.changeColorOfSpecificField(x,y, color, activeBoard);
            view.setSpecificFieldEnabled(x,y,false, activeBoard, true);
        }
        private void endGame(WhichPlayer looser){
            game.setState(GameState.END);

            view.displayMessageOnCommunicationLabel("Koniec gry! Wygrał "+game.getTurn());
            view.setBoardEnabled(false,game.getTurn());
            view.setBoardEnabled(false,looser);
        }
        private void changeTurnDuringShootingPhase(WhichPlayer player){
            view.setBoardEnabled(false, player);
            view.setBoardEnabled(true, game.getTurn());

            game.setTurn(player);

        }
    }
}
