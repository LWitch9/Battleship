package ShipsManagement;

import board.Board;

import java.util.ArrayList;

public class ShipsManagement {
    private ShipsContainer shipsContainer;
    private ArrayList<Integer> possibleSizesOfShips;
    private Board board;

    public ShipsManagement() {
        this.shipsContainer = new ShipsContainer();
        this.possibleSizesOfShips = new ArrayList<Integer>();
        this.board = new Board();
    }
    public void setShip(int x1, int x2, int y1, int y2){
        //TODO
        /*
        * Requirements:
        * -Check if coordinates are compatible with board size
        * -Check ships orientation (if it is horizontal or vertical) if x1!=x2 and y1!=y2 - WrongOrientation!
        * -Check ship's size ( Could it be placed? Or they are all possible ships of that size placed already)
        * -Check if chosen coordinates are Empty and Available to set
        *
        * If all conditions are met:
        * - add objects OccupiedCoordinates to required place on board
        * - add objects UnavailableCoordinates ( some function will be needed )
        * - prepare list of OccupiedCoordinates and add Ship
        *
        * */
    }
    public void hit(int x1, int y1){
        //TODO
        /*
         * Check:
         * - On board - if chosen coordinates are Empty or Occupied
         * - If occupied - search for choosen coordinate in ShipContainer
         *   There will be needed some better mechanisim for searching and checking if
         *   ship were completly drowned or just hit
         * - After checking - set chosen Coordinate in Ship to EmptyCoordinate / or maybe remove completly
         *   set chosen Coordinate Board to EmptyCoordinate
         *
         * */
    }
    private void setPossibleSizesOfShips(){
        //TODO
    }

}
