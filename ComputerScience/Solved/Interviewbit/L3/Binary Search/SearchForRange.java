//https://www.interviewbit.com/problems/search-for-a-range/

public class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int f = firstOccurence(a,b);
        int l = lastOccurence(a,b);
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(f);
        al.add(l);
        return al;
    }
    public int firstOccurence(final List<Integer> A, int B) {
        int start =0;
        int count =0;
        int end = A.size()-1;
        int result =-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(B== A.get(mid)){
                result = mid;
                end = mid-1;
            }
            else if(B<A.get(mid)){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return result;
    }
    public int lastOccurence(final List<Integer> A, int B) {
        int start =0;
        int count =0;
        int end = A.size()-1;
        int result =-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(B== A.get(mid)){
                result = mid;
                start = mid+1;
            }
            else if(B<A.get(mid)){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return result;
    }
}
