package realestateboardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * This class will build the game board for play
 * 
 * @author Kevin
 */
public class GameBoard {
    
    private int[] location;
    private String[] gameSquare;
    private String[] squareType;
    private int[] locationCost;
    private int boardSize;
    private boolean[] purchase;
    
    /**
     * All the work for the game board is done in the constructor
     * @throws IOException 
     */
    public GameBoard() throws IOException{
        
        URL url = getClass().getResource("locations.txt");
        
        // first, determine the number of entries in the file to size the array..
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(url.openStream()));
        boardSize = 0;
        while (br.ready()) {
            boardSize++;
            br.readLine();
        }
        br.close();
        
        location = new int[boardSize];
        gameSquare = new String[boardSize];
        squareType = new String[boardSize];
        locationCost = new int[boardSize];
        purchase = new boolean[boardSize];
        
        //Populate the Array of entries
       br = new BufferedReader(new InputStreamReader(url.openStream()));

        int i = 0;
        while (br.ready()) {
            String str = br.readLine();
            
            String[] splits = str.split(",");
            
            //Creating the maps that will be accessed by the dice rolls
            location[i] = Integer.parseInt(splits[0]);
            gameSquare[i] = splits[1];
            squareType[i] = splits[2];
            locationCost[i] = Integer.parseInt(splits[3]);
            purchase[i] = false;
            
            i++;
        }
    }
    
    /**
     * These getters return the position, type, and cost 
     * There is an off by 1 error between the arrays and the dice rolls
     * @param playerToken
     * @return 
     */
    public int getLocation(int arrayPosition) {
        return location[arrayPosition];
    }

    public String getGameSquare(int arrayPosition) {
        return gameSquare[arrayPosition];
    }

    public String getSquareType(int arrayPosition) {
        return squareType[arrayPosition];
    }

    public int getLocationCost(int arrayPosition) {
        return locationCost[arrayPosition];
    }

    public boolean getPurchase(int arrayPosition) {
        return purchase[arrayPosition];
    }

    public void setPurchase(boolean purchase, int arrayPosition) {
        this.purchase[arrayPosition] = purchase;
    }

    public int getLength() {
        return purchase.length;
    }
    
}