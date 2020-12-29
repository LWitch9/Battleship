package board;

public abstract class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //TODO maybe remove getters for x and y (replace it with toString method)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "" + (char)(x+64) + y;
    }

    public abstract boolean isOccupied();
    public abstract boolean isSetAvailable();

    public static final class  OccupiedCoordinate extends Coordinate {

        public OccupiedCoordinate(int x, int y) {
            super(x, y);
        }

        @Override
        public boolean isOccupied() {
            return true;
        }

        @Override
        public boolean isSetAvailable() {
            return false;
        }
    }
    public static final class  EmptyCoordinate extends Coordinate {

        public EmptyCoordinate(int x, int y) {
            super(x, y);
        }

        @Override
        public boolean isOccupied() {
            return false;
        }

        @Override
        public boolean isSetAvailable() {
            return true;
        }
    }
    public static final class  UnavailableCoordinate extends Coordinate {
        public UnavailableCoordinate(int x, int y) {
            super(x, y);
        }
        @Override
        public boolean isOccupied() {
            return false;
        }

        @Override
        public boolean isSetAvailable() {
            return false;
        }
    }

}
