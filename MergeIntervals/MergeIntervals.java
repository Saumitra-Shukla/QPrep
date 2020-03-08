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

    public static void sortbyColumn(int arr[][], int col) 
    { 
        
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
   
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });
    }


    public List<Interval> merger(List<Interval> interv) {
        
        int idx = 0;
        for (int i=1; i<interv.size(); i++)  
        {  
        
            if (interv.get(idx).end >=  interv.get(i).begin)  
            {  
                   // Merge previous and current Intervals  
                interv.get(idx).end = Math.max(interv.get(idx).end, interv.get(i).end);  
                interv.get(idx).begin = Math.min(interv.get(idx).begin, interv.get(i).begin);  
            }  
            else { 
                interv.set(i, interv.get(i));  
                idx++; 
            }     
        }
        return interv; 
    }

    public int[][] merge(int[][] intervals) {
        
        List<Interval> interv = new ArrayList<Interval>();
        sortbyColumn(intervals, 0);
        for(int i = 0; i < intervals.length; i++ ) {
            interv.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        interv = merger(interv);
        
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
        for (int i = 0; i < results.length; ++i)
            System.out.println(String.valueOf(results[i][0]) + " " + String.valueOf(results[i][1]));
    }
}
