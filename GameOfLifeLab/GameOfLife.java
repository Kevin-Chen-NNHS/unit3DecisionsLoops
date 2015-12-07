import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Thread;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 5 rows and 5 columns
    public final int ROWS = 10;
    public final int COLS = 10;
    
    public Location loc1;
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
        world.show();
        
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    public void populateGame()
    {
        // constants for the location of the three cells initially alive
        final int X1 = 1, Y1 = 2;
        final int X2 = 3, Y2 = 3;
        final int X3 = 0, Y3 = 4;
        final int X4 = 1, Y4 = 4;
        final int X5 = 4, Y5 = 4;
        final int X6 = 5, Y6 = 4;

        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(Y1, X1);
        grid.put(loc1, rock1);
        
        Rock rock2 = new Rock();
        Location loc2 = new Location(Y2, X2);
        grid.put(loc2, rock2);
        
        Rock rock3 = new Rock();
        Location loc3 = new Location(Y3, X3);
        grid.put(loc3, rock3);
        
        Rock rock4 = new Rock();
        Location loc4 = new Location(Y4,X4);
        grid.put(loc4, rock4);
        
        Rock rock5 = new Rock();
        Location loc5 = new Location(Y5,X5);
        grid.put(loc5, rock5);
        
        Rock rock6 = new Rock();
        Location loc6 =new Location(Y6,X6);
        grid.put(loc6, rock6);
        
        
        
        
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration(int ROWS)
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
       
    int i = 0;
    int g = 0;
    Rock rocki = new Rock();
    Location loci = new Location(i, g);
        //(i,g)
        //getNeighbors(Location loc)
        //getOccupiedAdjacentLocations(loc1)
        for (i = 0; i < ROWS; i++)
        {
            for (g = 0; g < ROWS; i++)
            {
    
                int lifecounter = 0;
                //X+(n+1), X+n, X+(n-1)
                //Y + (i+1), Y + (i), Y + (i-1)
               //int num = (Y+i),(X+n).checkGrid()
               
                ArrayList<Location> list = grid.getOccupiedAdjacentLocations(loc1);
                int num = list.size();
                num = 3; //num/2;
                
                if ( num == 0) 
                {
                    lifecounter = lifecounter + 1;
                }
                
                else if (lifecounter == 3)
                {
                    rocki = new Rock();
                    loci = new Location(i,g);
                    grid.remove(loci);
                }
                else if (lifecounter <2)
                {
                    
                    loci = new Location(i,g);
                    grid.remove(loci);
                }
                else if (lifecounter > 4)
                {
                    
                    loci = new Location(i,g);
                    grid.remove(loci);
                }
        // insert magic here...
        
        g++;
        }
        i++;
        Thread.sleep(1000);
        createNextGeneration(ROWS);
    }
    //world.show
    
    
    
    }
    public void step()
    {
        createNextGeneration(ROWS);
    }
    
        
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     *
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
       
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
    }

}
