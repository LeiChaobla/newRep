import java.util.Scanner;

public class Maze
{
    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int END = 3;
    public static final int VISITED = 4;
    
    public static final char NORTH = 'n';
    public static final char EAST = 'e';
    public static final char SOUTH = 's';
    public static final char WEST = 'w';

    public static void main(String[] args)
    {
        int[][] grid = {
            { START,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL, WALL},
            {WALL, EMPTY,  WALL,  WALL, EMPTY, EMPTY, EMPTY, EMPTY,  WALL, WALL},
            { WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,  WALL, EMPTY,  WALL, WALL},
            { WALL,  WALL,  WALL,  WALL, EMPTY,  WALL, EMPTY,  WALL, EMPTY, WALL},
            { WALL, EMPTY, EMPTY, EMPTY, EMPTY,  WALL, EMPTY, EMPTY, EMPTY, WALL},
            { WALL,  WALL, EMPTY,  WALL,  WALL, EMPTY, EMPTY,  WALL, EMPTY, WALL},
            { WALL,  WALL, EMPTY, EMPTY, EMPTY, EMPTY,  WALL,  WALL, EMPTY,  END},
            { WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL, WALL},
        };
                
        GridViewer.view(grid);
        
        String solution;
        Scanner sc = new Scanner(System.in);
        System.out.println("Find a solution to get from ^^ to $$, using the characters " 
            + "'" + NORTH + "', '" + EAST + "', '" + SOUTH + "' and '" + WEST + "'"
            + " (for north, east, south and west).");
        System.out.print("Your solution: ");
        solution = sc.nextLine();
        
        int currentRow = 1;
        int currentCol = 0;
        boolean done = false;
        boolean solved = false;
        int charIndex = 0;
        int solutionLength = solution.length();
        
        while(!done && charIndex < solutionLength)
        {
            char direction = solution.charAt(charIndex);
            System.out.println("Location: (" + currentRow + ", " + currentCol 
                + "), next direction: '" + direction + "'");
            
            switch(direction)
            {
                case NORTH:
                    currentRow--;
                    break;
                
                case EAST:
                    currentCol++;
                    break;
                    
                case SOUTH:
                    currentRow++;
                    break;
                    
                case WEST:
                    currentCol--;
                    break;
            
                default:
                    System.out.println("M1: You have no idea where you are going"); // Invalid direction.
            }
            
            if(currentRow < 0 || currentCol < 0
                || currentRow >= grid.length || currentCol >= grid[currentRow].length)
            {
                done = true;
                System.out.println("M2: You fall into the chasm of doom"); // Out of bounds.
            }
            else
            {
                switch(grid[row][col])
                {
                    case Maze.EMPTY;
                        grid[row][col] = Maze.VISITED;
                        break;

                    case Maze.WALL;
                        done = true;
                        System.out.println("M3: You stumble blindly into a solid concrete wall");
                        break;
                    
                    case Maze.END;
                        done = true;
                        solved = true;
                        System.out.println("M4: Solved");
                        break;
                    
                    default:
                        //Do nothing

                }
            }
            
            charIndex++;
        }
        
        if(!solved)
        {
            System.out.println("M5: You have failed to escape. Future archeologist gaze upon your remains in embafflement"); // Did not reach the end.
        }
        
   	GridViewer.view(grid);
    }
}
