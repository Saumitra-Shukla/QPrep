import java.io.*;
import java.util.*;

class SpiralMatrix  {
    
    static int x=0,y=0;

  // complete the below function implementation
  public List<Integer> valueAtNewPosition(int[][] matrix, int currX, int currY, int dir, int steps) {
    List<Integer> lst = new ArrayList<Integer>();
    while(steps > 0) {
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
          //System.out.println("-1");
        }
        //System.out.println(steps + "dir = " + dir);
        lst.add(matrix[currX][currY]);
        y = currY;
        x = currX;
      }
      catch(Exception e) {
        System.out.println("-1");
        return lst;
      }
    }
    return lst;
  }
  
    public List<Integer> add(List<Integer> lst, List<Integer> toadd) {
    
        for(int i = 0; i < toadd.size(); i++)
        {
            lst.add(toadd.get(i));
        }
        return lst;
    }

    public List<Integer> ans(int[][] matrix , int m, int n) {
        List<Integer> lst= new ArrayList<Integer>();
        int r=0,c=0;
       m--;n--;
        while(r <= m && c <= n) {
            //right
            lst = add(lst,valueAtNewPosition(matrix,x,y,1,n - c));
            r++;
            //down
            lst = add(lst,valueAtNewPosition(matrix,x,y,2,m - r));
            n--;
            //left
            //if(m > r) {
            lst = add(lst,valueAtNewPosition(matrix,x,y,3,n - c));
            
            m--;
            //System.out.println((n-c)+"  "+(m-r));
            
            
            //up
            //System.out.println(x+"  "+y);
            lst = add(lst,valueAtNewPosition(matrix,x,y,4,m - r));
            //lst.add(-1);
            c++;
            
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
    /*
    int currPosX = scanner.nextInt();
    int currPosY = scanner.nextInt();
    int dirToMove = scanner.nextInt();
    int stepsToMove = scanner.nextInt();
    */

    scanner.close();
    List<Integer> result = new SpiralMatrix().ans(matrix,n,m);

    for (int i = 0; i < result.size(); ++i) {
      System.out.printf("%d ", result.get(i));
    }
  }
}