package realestateboardgame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the Real Estate Board game it will play 1000 games
 * It will run until the player is out of money or 1000 dice rolls
 * 
 * @author Kevin
 */
public class RealEstateBoardGame {

    
    private int cashFlow;
    private int playerToken;
    private int numberOfDiceRolls = 0;
    private static final int NUMBEROFGAMES = 1000;
    private int gameCount = 0;
    private boolean newGame = true;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        RealEstateBoardGame realEstate = new RealEstateBoardGame();
        
        try {
            GameBoard gb = new GameBoard();
        } catch (IOException ex) {
            Logger.getLogger(
                    RealEstateBoardGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Keep track of each games dice count
        int diceCount = 0;
        
        while(realEstate.gameCount < NUMBEROFGAMES){
            
            //instantiate a new game when needed
            if(realEstate.newGame){
                realEstate.cashFlow = 1500;
                realEstate.playerToken= 0;
                
                realEstate.newGame = false;
            }
            
            
            realEstate.gameCount++;
        }
    }
    
    
}
