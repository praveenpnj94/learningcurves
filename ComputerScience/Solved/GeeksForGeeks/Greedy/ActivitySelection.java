//https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String[] start = br.readLine().trim().split(" ");
		    String[] end = br.readLine().trim().split(" ");
		    List<Activity> list = new ArrayList<>();
		    for(int i=0;i<start.length;i++){
		        Activity act = new Activity(Integer.parseInt(start[i]),Integer.parseInt(end[i]));
		        list.add(act);
		    }
		    System.out.println(activitySelection(list,n));
		}
	}
	public static int activitySelection(List<Activity> list, int n){
		    Collections.sort(list, new Comparator<Activity>(){
		        public int compare(Activity a1, Activity a2){
		            return a1.end-a2.end;
		        }
		    });
		    int count =1;
		    int j=0;
		    for(int i=1;i<list.size();i++){
		        if(list.get(i).start>=list.get(j).end){
		            j=i;
		            count++;
		        }
		    }
		    return count;
	}
}
class Activity{
    int start;
    int end;
    Activity(int start, int end){
        this.start = start;
        this.end = end;
    }
}