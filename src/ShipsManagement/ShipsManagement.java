package ShipsManagement;

import board.Board;
import board.Coordinate;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class ShipsManagement {
    private ShipsContainer shipsContainer;
    private ArrayList<Integer> possibleSizesOfShips;
    private Board board;

    public ShipsManagement() {
        this.shipsContainer = new ShipsContainer();
        this.possibleSizesOfShips = new ArrayList<Integer>();
        setPossibleSizesOfShips();
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
        boolean lessOrEqualsSize = x1 <= board.getSize() && x2 <= board.getSize() && y1 <= board.getSize() && y2 <= board.getSize();
        boolean moreOrEqualsOne = x1 >= 1 && x2 >= 1 && y1 >= 1 && y2 >= 1;

        if( ! ( lessOrEqualsSize && moreOrEqualsOne) ){
            //TODO Out of range
            System.out.println("Out of range");
        }
        else if(x2 != x1 && y2 !=y1){
            // First condition met
            // Second condition Wrong orientation!
            System.out.println("Wrong orientation");
        }
        else {
            //Second condition met - checking orientation and calculating length
            boolean isOrientationVertical;
            int shipLength;
            int tmp;
            if( x2 != x1 ){ //Checking orientation (horizontal)
                isOrientationVertical = false;
                shipLength = abs(x2 - x1) +1 ;
                // TODO is that necessary
                if(x2 > x1){
                    tmp =x1;
                    x1 = x2;
                    x2 = tmp;
                }
            }
            else{ //Checking orientation (vertical) - includes also ships of size 1
                isOrientationVertical = true;
                shipLength = abs(y2 - y1) +1 ;
            }

            if(!possibleSizesOfShips.contains(shipLength)){
                System.out.println("Wrong Length");
            }
            else {
                Ship ship;
                if(isOrientationVertical){
                    ship =  setVertically(x1,y1,shipLength);
                }
                else{
                    ship = setHorizontally(x1,y1, shipLength);
                }

                if(ship == null){
                    System.out.println("Coordinate unavailable");
                }
                else{
                    System.out.println("Ship successfully added");
                    possibleSizesOfShips.remove(shipLength);
                    shipsContainer.addShip(ship);
                }
                // prepare coordinates that will be set
                //If they are, remove shipLength from possibleSizeOfShips

            }
        }
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

    private Ship setVertically(int x, int y1, int diff){

        ArrayList<Coordinate> tmp = new ArrayList<Coordinate>();
        //Check if available
        for( int i = 0 ; i < diff ; i++){
            if(!board.getCoordinate(x,y1+i).isSetAvailable()){
                System.out.println("Coordinate unavailable");
                return null;
            }
        }

        //Set Unavailable
        for(int j = -1 ; j <= 1 ; j++){
            for(int i = -1 ; i <= diff ; i++){
                if((x+j) <= board.getSize() && (x+j) >=1 && (y1+i) <= board.getSize() && (y1+i) >=1){
                    board.setUnavailableCoordinateAt(x+j,y1+i);
                }
            }
        }

        //Set Occupied
        for( int i = 0 ; i < diff ; i++){
            board.setOccupiedCoordinateAt(x,y1+i);
            tmp.add(new Coordinate.OccupiedCoordinate(x,y1+i));
        }



        return new Ship(tmp);
    }
    private Ship setHorizontally(int x1, int y, int diff){

        ArrayList<Coordinate> tmp = new ArrayList<Coordinate>();
        //Check if available
        for( int i = 0 ; i < diff ; i++){
            if(!board.getCoordinate(x1+i,y).isSetAvailable()){
                System.out.println("Coordinate unavailable");
                return null;
            }
        }

        //Set Unavailable
        for(int j = -1 ; j <= 1 ; j++){
            for(int i = -1 ; i <= diff ; i++){
                if((x1+i) <= board.getSize() && (x1+i) >=1 && (y+j) <= board.getSize() && (y+j) >=1){
                    board.setUnavailableCoordinateAt(x1+i,y+j);
                }
            }
        }

        //Set Occupied
        for( int i = 0 ; i < diff ; i++){
            board.setOccupiedCoordinateAt(x1+i,y);
            tmp.add(new Coordinate.OccupiedCoordinate(x1+i,y));
        }

        return new Ship(tmp);
    }
    private void setPossibleSizesOfShips(){
        for( int i = 1 ; i <= 4 ; i++ ){
            for(int j=4-i+1 ; j >= 1 ; j--){
                possibleSizesOfShips.add(i);
            }
        }
    }
}
