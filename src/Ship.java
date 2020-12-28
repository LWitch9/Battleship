import java.util.ArrayList;

import static java.lang.Math.abs;
//TODO Maybe divide this class to : Ship and ShipManagement
public class Ship {
    private ArrayList<Coordinate> coordinates;
    private ArrayList<Coordinate> occupiedCoordinates;

    public Ship(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
        //this.occupiedCoordinates = new ArrayList<Coordinate>();
    }
}


