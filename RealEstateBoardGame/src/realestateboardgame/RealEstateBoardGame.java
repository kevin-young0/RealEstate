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
    private int squarePurchased = 0;
    private int indianaAve = 0;
    private int numberOfDiceRolls = 0;
    private static final int NUMBEROFGAMES = 1000;
    private int gameCount = 0;
    private boolean newGame = true;
    private int trip;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //Call the class within the main method to have access to non-static variables
        RealEstateBoardGame realEstate = new RealEstateBoardGame();
        
        try {
            //Create the game board that will be used for all of the games
            GameBoard gameBoard = new GameBoard();
            
            //Keep track of each games dice count
            int diceCount = 0;
            int arrayPosition = 0;
            //Initiate the dice that will be rolled
            DiceRoll dice1;
            DiceRoll dice2;

            while(realEstate.gameCount < NUMBEROFGAMES){
                int totalDice = 0;
                int location = 0;
                String square;
                String type;
                int cost = 0;
                boolean purchase;

                //instantiate a new game when needed
                if(realEstate.newGame){
                    realEstate.cashFlow = 1500;
                    realEstate.playerToken= 0;
                    realEstate.trip = 0;
                    diceCount = 0;
                    realEstate.newGame = false;
                    for(int i = 0; i < gameBoard.getLength(); i++){
                        gameBoard.setPurchase(false, i);
                    }
                }
            
                dice1 = new DiceRoll();
                dice2 = new DiceRoll();
                diceCount++;
            
                totalDice = dice1.getDiceValue() + dice2.getDiceValue();
                
                //add totalDice to playerToken to track location
                realEstate.playerToken += totalDice;
                
                if(realEstate.playerToken == 40){
                    realEstate.cashFlow += 200;
                }
                else if(realEstate.playerToken > 40){
                    realEstate.playerToken -= 40;
                    realEstate.trip ++;
                    realEstate.cashFlow += 200;
                }
                arrayPosition = realEstate.playerToken - 1;
                location = gameBoard.getLocation(arrayPosition);
                square = gameBoard.getGameSquare(arrayPosition);
                type = gameBoard.getSquareType(arrayPosition);
                cost = gameBoard.getLocationCost(arrayPosition);
                purchase = gameBoard.getPurchase(arrayPosition);
                
                if(square.equals("Income Tax")){
                    int tax = (int) (realEstate.cashFlow * .10);
                    
                    if(tax > cost){
                        cost = tax;
                    }
                }
                
                if((type.equals("property") && !purchase) || type.equals("penalty")) {
                    realEstate.cashFlow -= cost;
                    if(realEstate.cashFlow >= 0 && !type.equals("penalty")){
                        purchase = true;
                        gameBoard.setPurchase(purchase, arrayPosition);
                        realEstate.squarePurchased++;
                        
                        if(square.equals("Indiana Avenue")){
                            realEstate.indianaAve++;
                        }
                    }
                }
                
                if(realEstate.cashFlow < 0 || diceCount == 1000){
                    realEstate.newGame = true;
                    realEstate.numberOfDiceRolls += diceCount;
                    realEstate.gameCount++;
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(
                    RealEstateBoardGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        float averageTurns = 0;
        float propertyPurchaseAverage = 0;
        int indianaPurchase = 0;
        
        averageTurns = realEstate.numberOfDiceRolls / (float) NUMBEROFGAMES;
        propertyPurchaseAverage = realEstate.squarePurchased /(float) NUMBEROFGAMES;
        indianaPurchase = ((realEstate.indianaAve * 100) / NUMBEROFGAMES);
        
        System.out.println("After " + NUMBEROFGAMES + " games\n");
        System.out.println("The average number of turns in a game is " +
                averageTurns + "\n" + "The number of dice rolls was " +
                realEstate.numberOfDiceRolls + "\n");
        System.out.println("The average number of properties purchased was " + 
                propertyPurchaseAverage + "\n" + " The total properties purchased was "
                 + realEstate.squarePurchased);
        System.out.println("The percentage of games that Indiana Avenue was purchased "
                + indianaPurchase + "%\n" + "Indiana Avenue was purchased " +
                 realEstate.indianaAve + " times\n");
    }
}
