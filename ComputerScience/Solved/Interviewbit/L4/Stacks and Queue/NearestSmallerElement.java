//https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public int[] prevSmaller(int[] A) {
        if(A==null||A.length==0){
            return A;
        }
        int[] res = new int[A.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<A.length;i++){
            if(st.isEmpty()){
                res[i]=-1;
                st.push(A[i]);
            }
            else{
                while(!st.isEmpty() && A[i]<=st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i]=-1;
                    st.push(A[i]);
                }
                else{
                    int c =st.peek();
                    res[i]=c;
                    st.push(A[i]);
                }
            }
        }
        return res;
    }
}
