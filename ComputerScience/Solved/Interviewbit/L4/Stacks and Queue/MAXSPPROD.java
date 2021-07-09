//https://www.interviewbit.com/problems/maxspprod/

public class Solution {
    public int maxSpecialProduct(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int[] l = nextGreaterLeft(A);
        int[] r = nextGreaterRight(A);
        long max = -1;
        int idx =0;
        for(int i=0;i<A.length;i++){
            if(l[i]*r[i]>max){
                max = 1L*l[i]*r[i];
                idx=i;
            }
        }
        return (int)(max% 1000000007);
    }
    
    public int[] nextGreaterRight(int[] nums){
        if(nums==null||nums.length==0){
            return nums;
        }
        int[] res = new int[nums.length];
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=0;
            }
            else{
                int c = st.peek();
                res[i] = c;
            }
            st.push(i);
        }
        return res;
    }
    
    public int[] nextGreaterLeft(int[] nums){
        if(nums==null||nums.length==0){
            return nums;
        }
        int[] res = new int[nums.length];
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=0;
            }
            else{
                int c = st.peek();
                res[i] = c;
            }
            st.push(i);
        }
        return res;
    }
}
