//https://www.interviewbit.com/problems/merge-intervals/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals,new IntervalComparator());
        int size = intervals.size();
        if(size == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        boolean inserted = false;
        for(int i=0;i<size;i++) {
            Interval iIter = intervals.get(i);
            if(iIter.start > newInterval.start) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }
        if(!inserted) {
            intervals.add(newInterval);
        }
        //merge and return
        return merge(intervals);
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a , Interval b){
            return a.start-b.start;
        }
    }
    
        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        ArrayList<Interval> result = new ArrayList<Interval>();        
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(prev.end >= current.start){
                Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));                
                prev = merged;
            }
            else{
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        return result;
    }
}
