package ShipsManagement;

import board.Coordinate;

import java.util.ArrayList;

public class Ship {
    private ArrayList<Coordinate> coordinates;

    public Ship(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
        //this.occupiedCoordinates = new ArrayList<board.Coordinate>();
    }
    private Coordinate searchForCoordinate(int x , int y){
        Coordinate tmp = new Coordinate.OccupiedCoordinate(x,y);
        String tmpStr = tmp.toString();
        for ( int i = 0 ; i < coordinates.size() ; i++){
            if(coordinates.get(i).toString().equals(tmpStr)){
                return coordinates.get(i);
            }
        }
        return null;
    }
    public boolean removeCoordinate(int x , int y){
        Coordinate tmp = searchForCoordinate(x,y);
        if(tmp == null){
            return false;
        }
        else{
            coordinates.remove(tmp);
            return true;
        }

    }
    public int getShipSize(){
        return coordinates.size();
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }
}


