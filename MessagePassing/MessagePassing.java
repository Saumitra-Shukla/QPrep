import java.io.*;
import java.util.*;

class MessagePassing  {

  public List<Integer> add(List<Integer> ans, List<Integer> toadd) {
    for(int i = 0; i < toadd.size(); i++) {
        ans.add(toadd.get(i));
    }
    return ans;
}

  public List<Integer> ans(int[][] matrix) {
      List<Integer> lst = new ArrayList<Integer>();
      int m = matrix.length;
      int n = matrix[0].length;
      
      int i, k = 0, l = 0; 

      while (k < m && l < n) { 
          for (i = l; i < n; ++i) { 
              lst.add(matrix[k][i]); 
          } 
          k++; 

          for (i = k; i < m; ++i) { 
              lst.add(matrix[i][n - 1]); 
          } 
          n--; 

          if (k < m) { 
              for (i = n - 1; i >= l; --i) { 
                  lst.add(matrix[m - 1][i]); 
              } 
              m--; 
          } 

          if (l < n) { 
              for (i = m - 1; i >= k; --i) { 
                  lst.add(matrix[i][l]); 
              } 
              l++; 
          } 
      }
      
      return lst;
  }

  // Complete the below function implementation
  // Print "Yes" for success and "No" for Failure
  public void messagePassTest(int n, int s, int m, int[][] matrix) {
    
    List<Integer> result = ans(matrix);
    int i=0;
    int steps=s;
    while(steps > 0)
    {
      if(i==result.size())
      {
        System.out.println("Yes");
        return;
      }
      steps--;
      steps=Math.max(steps,result.get(i));
      i++;

    }
    System.out.println("No");
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int s = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        matrix[i][j] = 0;
      }
    }

    for(int i = 0 ; i < m ; ++i) {
        int x , y , p;
        x = scanner.nextInt();
        y = scanner.nextInt();
        p = scanner.nextInt();
        matrix[x][y] = Math.max(matrix[x][y],p);
    }
    scanner.close();
    new MessagePassing().messagePassTest(n,s,m,matrix);
  }
}
