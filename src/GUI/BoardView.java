package GUI;

import Game.WhichPlayer;
import board.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BoardView extends JPanel{

    private final int size = 10;
    private final ArrayList<ArrayList<Field>> boardFieldsCollection;
    private final WhichPlayer player;

    public BoardView(WhichPlayer player) {
        //panel = new JPanel();
        this.player = player;
        boardFieldsCollection = new ArrayList<ArrayList<Field>>();
        this.setPreferredSize( new Dimension( 640, 480 ) );
        this.init();
        this.addButtons();
    }

    public WhichPlayer getPlayer() {
        return player;
    }
    public void resetAll(){
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                if(boardFieldsCollection.get(i).get(j).getStateSetPermanently()){
                    boardFieldsCollection.get(i).get(j).setStateSetPermanently(false);

                }
                boardFieldsCollection.get(i).get(j).setEnabled(true);
                boardFieldsCollection.get(i).get(j).setBackground(new Color(255,255,255));

            }
        }
    }

    public void setAllFieldsEnabled(Boolean state){
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                if(!boardFieldsCollection.get(i).get(j).getStateSetPermanently()){
                    boardFieldsCollection.get(i).get(j).setEnabled(state);
                }
                else{
                    //Don't change state
                }

            }
        }
    }
    public void setSpecificFieldEnabled(int x, int y, Boolean state, boolean isStateSetPermanently){
        boardFieldsCollection.get(x-1).get(y-1).setEnabled(state);
        boardFieldsCollection.get(x-1).get(y-1).setStateSetPermanently(isStateSetPermanently);
    }

    public void changeColorOfAllFields(Color color){
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                boardFieldsCollection.get(i).get(j).setBackground(color);
            }
        }
    }
    public void changeColorOfSpecificField(int x, int y, Color color){
        boardFieldsCollection.get(x-1).get(y-1).setBackground(color);
    }

    public void addListenerToFields(ActionListener listener){
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                boardFieldsCollection.get(j).get(i).addActionListener(listener);
            }
        }
    }

    private void addButtons() {
        GridLayout layout = new GridLayout(10,10);
        this.setLayout(layout);
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                this.add(boardFieldsCollection.get(j).get(i));
            }
        }
    }
    private void init(){
        for(int i = 0; i < size; i++ ){
            boardFieldsCollection.add(new ArrayList<Field>());
            for(int j = 0 ; j < size ; j++){
                Field tmp = new Field();
                if(i==0 && j==0){
                    tmp.setText("" + (char)(j+65) + (i+1));
                }
                else if(i==0){
                    tmp.setText("" +(j+1));

                }
                else if(j==0){
                    tmp.setText("" + (char)(i+65));
                }
                tmp.setBackground(Color.WHITE);
                tmp.setActionCommand("" + (char)(i+65) + (j+1));
                boardFieldsCollection.get(i).add(tmp);
            }
        }

    }


}
