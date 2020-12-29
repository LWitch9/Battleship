package ShipsManagement;

import board.Coordinate;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class ShipsContainer {
    ArrayList<Ship> shipsCollection;
    public ShipsContainer() {
        this.shipsCollection = new ArrayList<Ship>();
    }
    public void addShip(Ship ship){
        shipsCollection.add(ship);
    }
    public void removeCoordinateFromShip(int x, int y){
        Ship tmp;
        for(Ship ship :shipsCollection){
            if(ship.removeCoordinate(x,y)){
                if(ship.getShipSize() == 0){
                    //Zatopiony TODO some information about Zatopiony state
                    removeShip(ship);
                }
                else{
                    //Trafiony
                }
                break;
            }
        }
    }

    private void removeShip(Ship ship){
        this.shipsCollection.remove(ship);
    }


}
