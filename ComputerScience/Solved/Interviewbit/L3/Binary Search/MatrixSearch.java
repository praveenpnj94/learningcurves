//https://www.interviewbit.com/problems/matrix-search/
//https://www.geeksforgeeks.org/search-element-sorted-matrix/

public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    int rowstart =0;
	    int colstart =0;
	    int rowend = a.size();
	    int colend = a.get(0).size();
	    boolean detected = false;
	    int i;
	    for(i =0;i<rowend;i++){
	        if(b<=a.get(i).get(colend-1)){
	            detected = true;
	            break;
	        }
	    }
	    if(!detected){
	        return 0;
	    }
	    else{
	        int start =0;
	        int end = colend-1;
	        while(start<=end){
	            int mid = (start+end)/2;
	            if(b==a.get(i).get(mid)){
	                return 1;
	            }
	            else if(b>a.get(i).get(mid)){
	                start = mid +1;
	            }
	            else{
	                end = mid-1;
	            }
	        }
	        return 0;
	    }
	}
}
