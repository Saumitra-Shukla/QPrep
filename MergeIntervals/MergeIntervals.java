import java.io.*;
import java.util.*;

class MergeIntervals {
    // Implement your solution by completing the below function

    class Interval {
        int begin;
        int end;
        Interval(int b, int e) {
            begin = b;
            end = e;
        }
    }
    public List<Interval> sort(List<Interval> interv) {
        
        for(int i = 0; i < interv.size-1; i++) {
            for(int j = 0; j < interv.size-1-i; j++) {
                if(interv.get(j).begin > interv.get(j + 1).begin) {
                    Interval swp = interv.get(j);
                    interv.set(j, interv.get(j + 1));
                    interv.set(j + 1, swp);
                }
            }
        }
        
        return interv;
    }

    public List<Interval> merger(List<Interval> interv) {
        
        for(int i = 1; i < interv.size(); i++){
            if(interv.get(i-1).end > interv.get(i).begin) {
                int begin = Math.min(interv.get(i-1).begin, interv.get(i).begin);
                int end = Math.max(interv.get(i-1).end, interv.get(i).end);
                Intervals temp = new Interval(begin, end);
                interv.set(i-1, temp);
                interv.remove(i);
            }
        }
        return interv;
        
    }

    public int[][] merge(int[][] intervals) {
        
        List<Interval> interv = new ArrayList<Interval>();

        for(int i = 0; i < intervals.length; i++ ) {
            interv.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        interv = merger(sort(interv));
        
        int [][] ans = new int[inter.size()][2];
        for(int i1 = 0; i1 < interv.size(); i1++) {
            ans[i][0] = interv.get(i).begin;
            ans[i][1] = inter.get(i).end;
        }


        return ans;
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
        for (int i = 0; i < results.length; ++i)
            System.out.println(String.valueOf(results[i][0]) + " " + String.valueOf(results[i][1]));
    }
}
