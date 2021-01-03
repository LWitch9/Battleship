package Controller;

public enum Messages {

    //==GENERAL
    NONE(""),
    WELCOME("Hello everyone"),
    END("Winner"),
    PLAY_AGAIN(""),
    WHO_STARTS(""),
    ALREADY_IN_BATTLE(""),
    //====SET
    NOT_ALL_SHIPS_SET(""),
    POSSIBLE_LENGTH_TO_SET(""),
    SUCCESSFUL_SET("Hurray"),
    WRONG_ORIENTATION_SET("Wrong orientation!!"),
    WRONG_LENGTH("Wrong length!"),
    UNAVAILABLE_COORDINATE_SET("Coordinate is unavailable"),
    ALL_SHIPS_SET("You've already set all ships. Click battle and enjoy the game"),
    //===SHOOT
    HIT_SHOOT("HIT!"),
    HIT_SUNK_SHOOT("HIT and SUNK!"),
    MISS_SHOOT("Ouu you missed");

    private final String message;


    Messages(final String message) {
        this.message = message;
    }
    @Override
    public String toString(){
        return message;
    }
}
