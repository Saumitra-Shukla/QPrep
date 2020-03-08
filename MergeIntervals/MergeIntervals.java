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
        public void print()
        {
            System.out.print(begin+","+end +"   ");
        }
    }
    
    public void printer(List<Interval> interv)
    {
        for(Interval i : interv)
        {
            i.print();
        }
    }
    public List<Interval> sort(List<Interval> interv) {
        
        for(int i = 0; i < interv.size()-1; i++) {
            for(int j = 0; j < interv.size()-1-i; j++) {
                if(interv.get(j).begin > interv.get(j + 1).begin) {
                    Interval swp = interv.get(j);
                    interv.set(j, interv.get(j + 1));
                    interv.set(j + 1, swp);
                }
            }
        }
        
        return interv;
    }

    public List<Interval> merger(List<Interval> interv, int index) {
        int i = index;
        if(interv.size() == index) {
            //System.out.println("\n last   ");
            
            return interv;
            
        }
        if(interv.get(i - 1).end >= interv.get(i).begin) {
            int begin = Math.min(interv.get(i-1).begin, interv.get(i).begin);
            int end = Math.max(interv.get(i-1).end, interv.get(i).end);
            Interval temp = new Interval(begin, end);
            interv.set(i-1, temp);
            interv.remove(i);
            //System.out.print("\n i    ");
            //printer(interv); 
            return merger(interv, i);
            
        }
        //System.out.print("\n i+1   ");
        //printer(interv);
        return merger(interv, i+1);
    }

    public int[][] merge(int[][] intervals) {
        
        List<Interval> interv = new ArrayList<Interval>();

        for(int i = 0; i < intervals.length; i++ ) {
            interv.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        interv = merger(sort(interv), 1);
        
        int [][] ans = new int[interv.size()][2];
        for(int i1 = 0; i1 < interv.size(); i1++) {
            ans[i1][0] = interv.get(i1).begin;
            ans[i1][1] = interv.get(i1).end;
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
        //System.out.println("*************************");
        for (int i = 0; i < results.length; ++i)
            System.out.println(String.valueOf(results[i][0]) + " " + String.valueOf(results[i][1]));
    }
}
