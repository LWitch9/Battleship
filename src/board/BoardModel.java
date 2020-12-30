package board;

import java.util.ArrayList;

public class BoardModel {
    private ArrayList<ArrayList<Coordinate>> board;
    private final int size;

    public BoardModel() {
        this.size = 10;
        this.board = new ArrayList<>(size);
        this.init();
        this.initWithCoordinates();
    }
    private void init(){
        for( int i = 0 ; i < size ; i++ ){
            board.add(new ArrayList<Coordinate>());
        }
    }
    private void initWithCoordinates(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                board.get(i).add(new Coordinate.EmptyCoordinate(i+1,j+1));
            }
        }
    }
    public void showAvailablity(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                System.out.print(board.get(j).get(i).isOccupied()+"  ");
            }
            System.out.println();
        }
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
    public void setEmptyCoordinateAt(int x, int y){
        board.get(x-1).set(y-1,new Coordinate.EmptyCoordinate(x,y));
    }
}