package ShipsManagement;

import Game.WhichPlayer;
import board.Board;
import board.Coordinate;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class ShipsManagement {
    private ShipsContainer shipsContainer;
    private ArrayList<String> possibleSizesOfShips;
    private Board board;
    private String resultCommunicat;
    private Boolean actionFinishedSuccessfully;
    private final WhichPlayer owner;

    public ShipsManagement(WhichPlayer owner) {
        this.owner = owner;
        this.shipsContainer = new ShipsContainer();
        this.possibleSizesOfShips = new ArrayList<String>();
        this.resultCommunicat = "";
        setPossibleSizesOfShips();
        this.board = new Board();
    }

    public WhichPlayer getOwner() {
        return owner;
    }

    public ShipsContainer getShipsContainer() {
        return shipsContainer;
    }

    public void setShip(int x1, int y1, int x2, int y2){

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
        resultCommunicat = "";
        actionFinishedSuccessfully = false;

        boolean lessOrEqualsSize = x1 <= board.getSize() && x2 <= board.getSize() && y1 <= board.getSize() && y2 <= board.getSize();
        boolean moreOrEqualsOne = x1 >= 1 && x2 >= 1 && y1 >= 1 && y2 >= 1;

        if( ! ( lessOrEqualsSize && moreOrEqualsOne) ){
            resultCommunicat = "Out of range";
        }
        else if(x2 != x1 && y2 !=y1){
            // First condition met
            // Second condition Wrong orientation!
            resultCommunicat = "Wrong orientation";
        }
        else {
            //Second condition met - checking orientation and calculating length
            boolean isOrientationVertical;
            int shipLength;
            int tmp;
            if( x2 != x1 ){ //Checking orientation (horizontal)
                isOrientationVertical = false;
                shipLength = abs(x2 - x1) +1 ;
                if(x1 > x2){
                    tmp =x1;
                    x1 = x2;
                    x2 = tmp;
                }
            }
            else{ //Checking orientation (vertical) - includes also ships of size 1
                isOrientationVertical = true;
                shipLength = abs(y2 - y1) +1 ;
                if(y1 > y2) {
                    tmp = y1;
                    y1 = y2;
                    y2 = tmp;
                }

            }
            System.out.println("Dlugosc statku: "+shipLength);

            if(!possibleSizesOfShips.contains(""+shipLength)){
                if(possibleSizesOfShips.isEmpty()){
                    //TODO Do sth that will make resultCommunicat unchangeable after setting all ships
                    resultCommunicat = "Wszystko rozstawione";
                    return;
                }

                else
                    resultCommunicat = "Wrong Length";
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
                    resultCommunicat = "Coordinate unavailable";
                }
                else{
                    resultCommunicat = "Ship successfully added";
                    actionFinishedSuccessfully = true;
                    possibleSizesOfShips.remove(""+shipLength);
                    shipsContainer.addShip(ship);
                    board.showAvailablity();
                    for(String i : possibleSizesOfShips){
                        System.out.println(i);
                    }
                }
            }
        }
    }

    public Boolean getActionFinishedSuccessfully() {
        return actionFinishedSuccessfully;
    }

    public String getResultCommunicat() {
        return resultCommunicat;
    }

    public void hit(int x, int y){
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
        actionFinishedSuccessfully = false;

        Coordinate onBoardCoord = board.getCoordinate(x,y);
        if(onBoardCoord.isOccupied()){
            actionFinishedSuccessfully = true;
            resultCommunicat = shipsContainer.removeCoordinateFromShip(x,y);
            board.setUnavailableCoordinateAt(x,y);
        }
        else{
            resultCommunicat="Pudlo";
        }


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
                possibleSizesOfShips.add(""+i);
            }
        }
    }
}
