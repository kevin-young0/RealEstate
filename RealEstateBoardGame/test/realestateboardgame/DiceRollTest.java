/*
 * This test class is for checking that methods
 * of the DiceRoll class function as expected.
 */
package realestateboardgame;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin
 */
public class DiceRollTest {
    protected int HIGHEST_DICE_VALUE = 6;
    protected int LOWEST_DICE_VALUE = 1;
    
    public DiceRollTest() {
    }

    /**
     * Test of getValue method
     */
    @Test
    public void testGetValue() {
        System.out.println("Test 1 Junit4: testSetGetValue");
        int number = 4;
        DiceRoll Die1 = new DiceRoll();
        System.out.println("This is a randomly generated number " +
                Die1.getDiceValue() + " It is automatically created when the Die" +
                " class is called.");
    }
    
    /**
     * Test of DiceRoll method
     */
    @Test
    public void testDiceRoll(){
        DiceRoll diceRoll;
        for(int i = 0; i < 100; i++){
           diceRoll = new DiceRoll();
           assertTrue(i + "diceRoll failed here" + diceRoll,LOWEST_DICE_VALUE <= diceRoll.getDiceValue() && 
                   diceRoll.getDiceValue() <= HIGHEST_DICE_VALUE);
        }
    }
}