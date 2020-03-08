import java.io.*;
import java.util.*;

class MergeIntervals {

    final int[][] resize(int[][] matrix, int w, int h) {
        int[][] temp = new int[h][w];
        h = Math.min(h, matrix.length);
        w = Math.min(w, matrix[0].length);
        for (int i = 0; i < h; i++)
            System.arraycopy(matrix[i], 0, temp[i], 0, w);
        return temp;
    }

    final Comparator<int[]> newcomparator=new Comparator<int[]>(){
    @Override
    public int compare(int[] a1, int[] a2){
        if(a1[0]==a2[0]){
            if(a1[1]>a2[1]){
                return 1;
            }
            return -1;
        }
        if(a1[0]>a2[0]){
            return 1;
        }
            return -1;
    }
};

    public int[][] merge(int[][] intervals) {

        int r = intervals.length;
        int c = 2;
        if(r<=0){
            return null;
        }
        Arrays.sort(intervals, newcomparator);
        int[][] ans = new int[r][c];
        int j = 0;
        ans[0][0] = intervals[0][0];
        ans[0][1] = intervals[0][1];
        int maxi = intervals[0][1];
        for (int i = 1; i < r; i++) {
            if (intervals[i][0] <= maxi) {
                maxi = Math.max(maxi,intervals[i][1]);
                ans[j][1] = maxi; 
            } else {
                j++;
                ans[j][0] = intervals[i][0];
                ans[j][1] = intervals[i][1];
                maxi = ans[j][1];
            }
        }

        int[][] res = resize(ans,2,j+1);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        scanner.close();

        int[][] results = new MergeIntervals().merge(nums);

        for (int i = 0; i < results.length; ++i) {
            System.out.println(String.valueOf(results[i][0]) + " " + String.valueOf(results[i][1]));
        }
    }
}