package ShipsManagement;

import board.Coordinate;

import java.util.ArrayList;

public class Ship {
    private ArrayList<Coordinate> coordinates;
    private ArrayList<Coordinate> occupiedCoordinates;

    public Ship(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
        //this.occupiedCoordinates = new ArrayList<board.Coordinate>();
    }
}


