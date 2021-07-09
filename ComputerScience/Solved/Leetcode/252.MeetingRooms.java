//https://leetcode.com/problems/meeting-rooms/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals==null||intervals.size()==0){
            return true;
        }

        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];


        int idx=0;
        for(Interval i:intervals){
            starts[idx]=i.start;
            ends[idx]=i.end;
            idx++;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for(int i=0;i<starts.length-1;i++){
            if(starts[i+1]<ends[i]){
                return false;
            }
        }

        return true;
    }
}