//https://www.geeksforgeeks.org/job-sequencing-problem/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");
            List<Job> joblist = new ArrayList<Job>();
            List<Integer> ids = new ArrayList<>();
            for(int i=0;i<arr.length;i=i+3){
                ids.add(Integer.parseInt(arr[i]));
            }
            List<Integer> deadlines = new ArrayList<>();
            for(int i=1;i<arr.length;i=i+3){
                deadlines.add(Integer.parseInt(arr[i]));
            }
            List<Integer> profits = new ArrayList<>();
            for(int i=2;i<arr.length;i=i+3){
                profits.add(Integer.parseInt(arr[i]));
            }
            for(int i=0;i<ids.size();i++){
                int id = ids.get(i);
                int deadline = deadlines.get(i);
                int profit = profits.get(i);
                Job job = new Job(id,deadline,profit);
                joblist.add(job);
            }
            jobSequence(joblist,n);
        }
    }

    public static void jobSequence(List<Job> joblist, int n){
        Collections.sort(joblist,new JobComparator());
        Job[] res = new Job[n];
        boolean slot[] = new boolean[n];
        Arrays.fill(slot,false);
        for(int i =0;i<n;i++){
            for(int j= Math.min(n,joblist.get(i).deadline)-1;j>=0;j--){
                if(slot[j]==false){
                    res[j]=joblist.get(i);
                    slot[j]=true;
                    break;
                }
            }
        }
        //System.out.println(res);
        int cnt =0;
        int val=0;
         for(int i=0;i<n;i++){
             if(res[i]!=null){
                 cnt++;
                 val+=res[i].profit;
             }
         }
         System.out.println(cnt+" "+val);
    }
}
class Job{
    int id;
    int deadline;
    int profit;
    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job j1, Job j2) {
        return j2.profit-j1.profit;
    }
}