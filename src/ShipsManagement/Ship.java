package ShipsManagement;

import board.Coordinate;

import java.util.ArrayList;

public class Ship {
    private ArrayList<Coordinate> coordinates;

    public Ship(ArrayList<Coordinate> coordinates) {
        this.coordinates = coordinates;
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

    private Coordinate searchForCoordinate(int x , int y){
        String tmpStr = "" + (char)(x+64) + y;
        for ( int i = 0 ; i < coordinates.size() ; i++){
            if(coordinates.get(i).toString().equals(tmpStr)){
                return coordinates.get(i);
            }
        }
        return null;
    }
}


