import java.io.*;
import java.util.*;

class NumberOfIslands {

    // Implement your solution by completing the below function
    public int numIslands(char[][] grid) {
        
        Ones[][] gridn = new Ones[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                gridn[i][j].value = grid[i][j];
                gridn[i][j].visited = 0;
            }
        }
        int ans = numOnes(gridn);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        char[][] grid = new char[rows][columns];

        for (int i = 0; i < rows; ++i) {
            String s = scanner.next();
            for (int j = 0; j < columns; ++j) {
                grid[i][j] = s.charAt(j);
            }
        }
        scanner.close();
        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
    }
}