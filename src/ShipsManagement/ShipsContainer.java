package ShipsManagement;

import board.Coordinate;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class ShipsContainer {
    ArrayList<Ship> shipsCollection;
    public ShipsContainer() {

    }
    public void addShip(Ship ship){
        ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
        ArrayList<Coordinate> unavailableCoordinates = new ArrayList<Coordinate>();

        shipsCollection.add(ship);
    }



    private void setUnavailableCoordinates(){

    }

}
