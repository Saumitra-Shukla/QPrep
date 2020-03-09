import java.io.*;
import java.util.*;

class MatrixTraversal  {

  // complete the below function implementation
  public List<Integer> valueAtNewPosition(int[][] matrix, int currX, int currY, int dir, int steps) {
    List<Integer> lst = new ArrayList<Integer>();
    if(matrix == null){
      lst.add(-1);
      return lst;
    }
    while(steps > 0) {
        steps--;
      try {
        if(dir == 1) {

          currY++;

        }
        else if(dir == 2) {
          currX++;
        }
        else if(dir ==3) {
          currY--;
        }
        else if(dir ==4) {
          currX--;
        }
        else {
          lst.add(-1);
          return lst;
        }
        //System.out.println(matrix[currY][currX]);
        lst.add(matrix[currX][currY]);
      }
      catch(Exception e) {
        //System.out.println("-1");
        lst.add(-1);
        return lst;
      }
    }
    return lst;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    int currPosX = scanner.nextInt();
    int currPosY = scanner.nextInt();
    int dirToMove = scanner.nextInt();
    int stepsToMove = scanner.nextInt();

    scanner.close();
     List<Integer> result = new MatrixTraversal().valueAtNewPosition(matrix, currPosX, currPosY, dirToMove, stepsToMove);

    for (int i = 0; i < result.size(); ++i) {
      System.out.printf("%d ", result.get(i));
    }
  }
}