package ShipsManagement;

import board.Coordinate;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class ShipsContainer {
    ArrayList<Ship> shipsCollection;
    public ShipsContainer() {

    }
    public void addShip(int x1, int x2, int y1, int y2){
        ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
        ArrayList<Coordinate> unavailableCoordinates = new ArrayList<Coordinate>();

        /*Checking orientation*/
        if (x1 != x2){
            coordinates = setHorizontally(x1,x2,y1);
        }
        else { //should also add ships of size 1
            coordinates = setVertically(x1,y1,y2);
        }
        shipsCollection.add(new Ship(coordinates));
    }

    private ArrayList<Coordinate> setVertically(int x, int y1, int y2){
        int diff = abs(y2-y1);
        ArrayList<Coordinate> tmp = new ArrayList<Coordinate>();
        for( int i = 0 ; i <= diff ; i++){
            tmp.add(new Coordinate.OccupiedCoordinate(x,y1+diff));
        }
        return tmp;
    }

    private ArrayList<Coordinate> setHorizontally(int x1, int x2, int y){
        int diff = abs(x2-x1);
        ArrayList<Coordinate> tmp = new ArrayList<Coordinate>();
        for( int i = 0 ; i <= diff ; i++){
            tmp.add(new Coordinate.OccupiedCoordinate(x1+diff,y));
        }
        return tmp;
    }

    private void setUnavailableCoordinates(){

    }

}
