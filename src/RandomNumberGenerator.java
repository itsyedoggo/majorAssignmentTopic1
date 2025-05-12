import java.util.Random;

/**
 * Generates random numbers for the game.
 */
public class RandomNumberGenerator{
    Random rand;

    /**
     * Constructs a new RandomNumberGenerator.
     */
    public RandomNumberGenerator(){
        rand = new Random();
    }

    /**
     * Gets a random number between 0 and max.
     * @param max The maximum value.
     * @return A random number between 0 and max.
     */
    public int getRandomNumber(int max){
        return rand.nextInt(max);
    }

    /**
     * Gets a random number within a specified range.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A random number within the specified range.
     */
    public int getRandomNumberInRange(int min, int max){
        return rand.nextInt(max-min+1) + min;
    }

    /**
     * Rolls a six-sided dice.
     * @return A random number between 1 and 6.
     */
    public int rollDice(){
        return getRandomNumberInRange(1, 6);
    }
}