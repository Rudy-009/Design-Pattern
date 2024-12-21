import java.util.Random;

class RandIntInRange {
    private static final Random random = new Random();

    public static int nextInt(int min, int max) {
        return random.nextInt(max + 1 - min) + min;    
    }
}