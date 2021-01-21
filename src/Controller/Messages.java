package Controller;

public enum Messages {

    //==GENERAL
    NONE(""),
    WELCOME("Witaj w grze Statki!" +"<br>" + " Aby rozpocząć grę zacznij rozstawiać statki " +
            "zaznaczając ich koniec i początek na planszy." +"<br>"+
            "Do rozstawienia jest: Jednomasztowców x4, Dwumasztowcówx3, Trójmasztowców x2, Czteromasztowców x1 "+"<br>"+
            "Statki ustawiać można jedynie w pionie lub poziomie" +"<br>" + " Rozpoczyna Gracz 1. Powodzenia!"),
    END("Koniec gry. Zwyciężył: "),
    PLAY_AGAIN("Zagraj raz jeszcze klikając przycisk Reset."),
    WHO_STARTS("Rozpoczyna: "),
    ALREADY_IN_BATTLE("Jesteś już w trakcie rozgrywki!"),
    //====SET
    NOT_ALL_SHIPS_SET("Gracze nie rozstawili jeszcze wszystkich statków." +"<br>"+
            "Dokończ rozstawianie lub poczekaj aż zrobi to przeciwnik."),
    POSSIBLE_LENGTH_TO_SET(""),
    SUCCESSFUL_SET("Statek został ustawiony pomyślnie."),
    WRONG_ORIENTATION_SET("Statek nie został ustawiony."+"<br>"+"Statek może być ustawiony tylko w pionie lub poziomie”"),
    WRONG_LENGTH("Statek nie został ustawiony."+"<br>"+"Podana długość statku nie odpowiada możliwym do ustawienia"),
    UNAVAILABLE_COORDINATE_SET("Statek nie został ustawiony."+"<br>"+"Już tu coś jest."),
    ALL_SHIPS_SET("Wygląda na to że wszystkie statki zostały rozstawione."+"<br>"+
            " Rozpocznij grę klikając BATTLE lub (jeśli chcesz zmienić ustawienie statków) wciśnij RESET."),
    //===SHOOT
    SHOOT_WELCOME("Walka rozpoczęta."+"</br>"+" Kliknij pole na planszy przeciwnika i spróbuj zatopić wszystkie jego statki zanim on zatopi twoje! Powodzenia!"),
    HIT_SHOOT("Trafiony! Strzelaj dalej."),
    HIT_SUNK_SHOOT("Trafiony zatopiony!"),
    MISS_SHOOT("Pudło! Kolej na przeciwnika.");

    private final String message;


    Messages(final String message) {
        this.message = message;
    }
    @Override
    public String toString(){
        return message;
    }
}
