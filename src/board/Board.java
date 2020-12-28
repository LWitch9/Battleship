package board;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Coordinate>> board;
    private final int size;

    public Board() {
        this.size = 10;
        this.board = new ArrayList<>(size);
        this.init();
        this.initWithCoordinates();
    }
    public void init(){
        for( int i = 0 ; i < size ; i++ ){
            board.add(new ArrayList<Coordinate>());
        }
    }
    public void initWithCoordinates(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                board.get(i).add(new Coordinate.EmptyCoordinate(i+1,j+1));
            }
        }
    }
}
