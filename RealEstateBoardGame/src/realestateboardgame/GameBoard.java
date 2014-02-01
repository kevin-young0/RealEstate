package realestateboardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

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
    
    /**
     * All the work for the game board is done in the constructor
     * @throws IOException 
     */
    public GameBoard() throws IOException{
        
        URL url = getClass().getResource("dictionaryOne.txt");
        
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
            
            i++;
        }
    }
    
}
