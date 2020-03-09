import java.io.*;
import java.util.*;

class SpiralMatrix {
    // Implement your solution by completing the below function

    public List<Integer> goup(int[][] matrix, int depth, int m, int n) {
        List<Integer> up = new ArrayList<Integer>();
        for(int i = m - 2 - depth; i > depth; i--) {
            up.add(matrix[i][depth]);            
        }
        return up;
    }
    public List<Integer> godown(int[][] matrix, int depth, int m, int n) {
        List<Integer> down = new ArrayList<Integer>();
        for(int i = depth + 1; i <= m - 1 - depth; i++) {
            down.add(matrix[i][n - 1 - depth]);            
        }
        return down;
    }
    public List<Integer> goright(int[][] matrix, int depth, int m, int n) {
        List<Integer> right = new ArrayList<Integer>();
        for(int i = depth; i <= n - 1 - depth; i++) {
            right.add(matrix[depth][i]);            
        }
        return right;
    }
    public List<Integer> goleft(int[][] matrix, int depth, int m, int n) {
        List<Integer> left = new ArrayList<Integer>();
        for(int i = n - 2 - depth; i >= depth; i--) {
            left.add(matrix[m - 1 - depth][i]);            
        }
        return left;
    }

    public List<Integer> add(List<Integer> ans, List<Integer> toadd) {
        for(int i = 0; i < toadd.size(); i++) {
            ans.add(toadd.get(i));
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        try {

            for(int i = 0; i < Math.min(m,n) - 1; i++) {
                
                lst = add(lst, goright(matrix, i, m, n));
                lst = add(lst, godown(matrix, i, m, n));
                lst = add(lst, goleft(matrix, i, m, n));
                lst = add(lst, goup(matrix, i, m, n));
            }
        }
        catch(Exception e)
        {
            return lst;
        }
        
        return lst;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                matrix[i][j] = scanner.nextInt();
        scanner.close();

        List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        for (int i = 0; i < result.size(); ++i)
            System.out.printf("%d ", result.get(i));
    }
}
