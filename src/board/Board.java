package board;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Coordinate>> board;
    private final int size;

    public Board() {
        this.size = 10;
        this.board = new ArrayList<>(size);
        this.init();
    }


    public int getSize() {
        return size;
    }
    public Coordinate getCoordinate(int x, int y) {
        return board.get(x-1).get(y-1);
    }
    public void setOccupiedCoordinateAt(int x, int y){

        board.get(x-1).set(y-1,new Coordinate.OccupiedCoordinate(x,y));
    }
    public void setUnavailableCoordinateAt(int x, int y){
        board.get(x-1).set(y-1,new Coordinate.UnavailableCoordinate(x,y));
    }

    private void init(){
        for( int i = 0 ; i < size ; i++ ){
            board.add(new ArrayList<Coordinate>());
        }
        initWithCoordinates();
    }
    private void initWithCoordinates(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                board.get(i).add(new Coordinate.EmptyCoordinate(i+1,j+1));
            }
        }
    }
}
