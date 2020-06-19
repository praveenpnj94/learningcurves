//https://www.interviewbit.com/problems/sort-by-color/
//https://leetcode.com/problems/sort-colors/solution/

public class Solution {
    public void sortColors(ArrayList<Integer> a) {
        int n=a.size();
        // int low =0;
        // int mid =low+1;
        // int high = a.size()-1;
        // int zeroCnt=0; int oneCnt = 0; int twoCnt = 0;
        // for(int i=0;i<n;i++){
        //     if(a.get(i).intValue()==0){
        //         zeroCnt++;
        //     }
        //     else if(a.get(i).intValue()==1){
        //         oneCnt++;
        //     }
        //     else{
        //         twoCnt++;
        //     }
        // }
        // int idx=0;
        // for(int j=0;j<zeroCnt;j++){
        //     a.set(idx,0);
        //     idx++;
        // }
        // for(int k=0;k<oneCnt;k++){
        //     a.set(idx,1);
        //     idx++;
        // }
        // for(int l=0;l<twoCnt;l++){
        //     a.set(idx,2);
        //     idx++;
        // }
        int low =0;
	    int mid =0;
	    int high = n-1;
	    while(mid<=high){
	        switch(a[mid]){
	            case 0:
	                int temp = a[low];
	                a[low] =a[mid];
	                a[mid] = temp;
	                low++;
	                mid++;
	                break;
	           case 1:
	               mid++;
	               break;
	           case 2:
	               	int tem = a[mid];
	                a[mid] = a[high];
	                a[high] = tem;
	                high--;
	                break;
	        }
	    }
    }
}


