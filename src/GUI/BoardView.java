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
                    tmp.setText("" + (char)(j+65));
                }
                else if(j==0){
                    tmp.setText("" +(i+1));
                }
                tmp.setBackground(Color.WHITE);
                tmp.setActionCommand("" + (char)(j+65) + (i+1));
                boardFieldsCollection.get(i).add(tmp);
            }
        }

    }

    public void setAllEnabled(Boolean state){
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                boardFieldsCollection.get(i).get(j).setEnabled(state);
            }
        }
    }
    public void changeColorOfAll(Color color){
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                boardFieldsCollection.get(i).get(j).setBackground(color);
            }
        }
    }
    public void setSpecificFieldEnabled(int x, int y, Boolean state){
        boardFieldsCollection.get(x-1).get(y-1).setEnabled(state);
    }
    public void changeColorOfSpecificField(int x, int y, Color color){
        boardFieldsCollection.get(x-1).get(y-1).setBackground(color);
    }
    public Field getField(int x, int y){
        return boardFieldsCollection.get(x-1).get(y-1);
    }
    public void addListenerToFields(ActionListener listener){
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                boardFieldsCollection.get(j).get(i).addActionListener(listener);
            }
        }
    }


}
