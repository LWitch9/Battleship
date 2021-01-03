package GUI;

import board.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BoardView extends JPanel{
    //private JPanel panel;
    private final int size = 10;
    private ArrayList<ArrayList<Field>> boardFieldsCollection;


    public BoardView() {
        //panel = new JPanel();
        boardFieldsCollection = new ArrayList<ArrayList<Field>>();
        this.setPreferredSize( new Dimension( 640, 480 ) );
        this.init();
        this.addButtons();
    }

    private void addButtons() {
        GridLayout layout = new GridLayout(10,10);
        this.setLayout(layout);
        //TODO get rid of blank spaces between buttons
        for(int i = 0; i < size; i++ ){
            for(int j = 0 ; j < size ; j++){
                this.add(boardFieldsCollection.get(i).get(j));
            }
        }
    }

    private void init(){
        for(int i = 0; i < size; i++ ){
            boardFieldsCollection.add(new ArrayList<Field>());
            for(int j = 0 ; j < size ; j++){
                Field tmp = new Field();
                if(i==0 && j==0){
                    tmp.setText("" + (char)(i+65) + (j+1));
                }
                else if(i==0){
                    tmp.setText("" + (char)(j+65));
                }
                else if(j==0){
                    tmp.setText("" +(i+1));
                }
                tmp.setBackground(Color.WHITE);
                boardFieldsCollection.get(i).add(tmp);
            }
        }

    }

    //TODO Czy te funkcje powinny być w view czy w controllerze
    public void changeStateOfAll(String state){

    }
    public void changeColorOfAll(String color){

    }
    public void changeStateOfSpecificField(int x, int y, String state){

    }
    public void changeColorOfSpecificField(int x, int y, String color){
        boardFieldsCollection.get(x-1).get(y-1).setBackground(Color.decode(color));
    }
    public Field getField(int x, int y){
        return boardFieldsCollection.get(x-1).get(y-1);
    }


}
