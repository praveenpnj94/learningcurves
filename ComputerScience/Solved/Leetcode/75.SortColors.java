//https://leetcode.com/problems/sort-colors/
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/

class Solution {
    public void sortColors(int[] a) {
        int low=0;
        int i=0; int high= a.length-1;
	    while(i<=high){
	        switch(a[i]){
	            case 0:
	                int temp = a[low];
	                a[low] =a[i];
	                a[i] = temp;
	                low++;
	                i++;
	                break;
	           case 1:
	               i++;
	               break;
	           case 2:
	               	int tem = a[i];
	                a[i] = a[high];
	                a[high] = tem;
	                high--;
	                break;
	        }
	    }
    }
}