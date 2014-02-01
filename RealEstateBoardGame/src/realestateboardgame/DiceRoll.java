package realestateboardgame;

import java.util.Random;

/**
 *
 * @author Kevin
 */
public class DiceRoll {
    public Random randDiceRoll;
    public static final int HIGHEST_DICE_VALUE = 6;
    public static final int LOWEST_DICE_VALUE = 1;
    private int DiceValue = 0;
    
    /**
     * This constructor generates a dice roll each time the class is called
     */
    public DiceRoll(){
       randDiceRoll = new Random(); 
       DiceValue = roll(); 
    }
    
    //Get the value of the dice roll
    public int getDiceValue(){
        return DiceValue;
    }
    
    /**
      * This is a randomly generated number from 1 - 6
      * @return 
      */
     public int roll(){
        DiceValue = randDiceRoll.nextInt(HIGHEST_DICE_VALUE) + LOWEST_DICE_VALUE;
        return DiceValue;
     }
}
