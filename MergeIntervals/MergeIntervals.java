import java.io.*;
import java.util.*;

class Interval 
{ 
	int start,end; 
	
	Interval(int start, int end) 
	{ 
		this.start=start; 
		this.end=end; 
	} 
} 

class MergeIntervals { 
	
	public  int[][] merger(Interval arr[]) 
	{ 
		Arrays.sort(arr,new Comparator<Interval>(){ 
			public int compare(Interval i1,Interval i2) 
			{ 
				return i2.start - i1.start; 
			} 
		}); 
	
		int index = 0;
		for (int i=1; i<arr.length; i++) 
		{ 
			if (arr[index].end >= arr[i].start) 
			{ 
				arr[index].end = Math.max(arr[index].end, arr[i].end); 
				arr[index].start = Math.min(arr[index].start, arr[i].start); 
			} 
			else { 
				arr[index] = arr[i]; 
				index++; 
			}	 
		} 
		
		int [][] ans=new int[index+1][2];
		for (int i = 0; i <= index; i++) 
		{ 
			ans[i][0]=arr[i].start;
			ans[i][1]=arr[i].end; 
		} 

		return ans;
	} 
    
    public int[][] merge(int[][] intervals) {
        
        Interval arr[]=new Interval[intervals.length];
        
        for(int i=0; i<intervals.length; i++) {
            arr[i]=new Interval(intervals[i][0],intervals[i][1]);
        }
        return merger(arr);
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
        //System.out.println(results);
        for (int i = 0; i < results.length; ++i)
            System.out.println(String.valueOf(results[i][0]) + " " + String.valueOf(results[i][1]));
    }
}
