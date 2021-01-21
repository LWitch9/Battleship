package Game;
import java.util.Random;

public enum WhichPlayer {
    GRACZ1,
    GRACZ2;

    public static WhichPlayer getRandomPlayer() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
