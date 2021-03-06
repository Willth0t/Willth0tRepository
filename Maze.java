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
            { WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL,  WALL, WALL},
            {START, EMPTY,  WALL,  WALL, EMPTY, EMPTY, EMPTY, EMPTY,  WALL, WALL},
            { WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,  WALL, EMPTY,  WALL, WALL},
            { EMPTY,  WALL,  WALL,  WALL, EMPTY,  WALL, EMPTY,  WALL, EMPTY, WALL},
            { EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,  WALL, EMPTY, EMPTY, EMPTY, WALL},
            { EMPTY,  WALL, EMPTY,  WALL,  WALL, EMPTY, EMPTY,  WALL, EMPTY, WALL},
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
        
        int Row = 1;
        int Col = 0;
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
                    System.out.println("MESSAGE 1 -> ur mumma"); // Invalid direction.
            }         
            switch(grid[Row][Col])
            {
                case Maze.EMPTY:
                    grid[Row][Col] = Maze.VISTED;
                    break;
                case Maze.WALL:
                    done = true;
                    System.out.println("you stumble blindly into a solid concrete wall.");
                    break;
                case Maze.END:
                    done = true;
                    solved = true;
                    Sysyem.out.println("SOLVED");
                    break;
                default:
            
            }
            charIndex++;
        }
        
        if(!solved)
        {
            System.out.println("MESSAGE 5"); // Did not reach the end.
        }
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                switch(grid[i][j])
                {
                    case EMPTY:
                        System.out.print("  ");
                        break;
                        
                    case WALL:
                        System.out.print("##");
                        break;
                        
                    case START:
                        System.out.print("^^");
                        break;
                        
                    case END:
                        System.out.print("$$");
                        break;
                        
                    case VISITED:
                        System.out.print("..");
                        break;
                        
                    default:
                        throw new AssertionError();
                }
            }
            System.out.println();
        }
    }
}
