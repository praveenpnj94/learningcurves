//https://www.interviewbit.com/problems/rotated-array/
//https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
    int low = 0;
    int high = a.size()-1;   
    int n = a.size();
    while(low<=high){
        if(a.get(low)<=a.get(high)){
            return a.get(low);
        }
        int mid = (low+high)/2;
        int next = (mid+1)%n;
        int prev = (mid+n-1)%n;
        if(a.get(mid)<=a.get(prev) && a.get(mid)<=a.get(next)){
            return a.get(mid);
        }
        else if(a.get(mid)<=a.get(high)){
            high = mid-1;
        }
        else if(a.get(mid)>=a.get(low)){
            low = mid+1;
        }
    }
    return -1;
    }
}
