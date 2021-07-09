//https://leetcode.com/problems/maximal-rectangle/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] hist = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    hist[j]=0;
                }
                else{
                    int val= matrix[i][j]=='0'?0:1;
                    hist[j]+=val;
                }
                
            }
            maxArea = Math.max(maxArea,largestRectangleArea(hist));
        }
        return maxArea;
    }
    
    public int largestRectangleArea(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int[] l = nsl(A);
        int[] r = nsr(A);
        int[] m = new int[A.length];
        int n = A.length;
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            m[i]=r[i]-l[i]-1;
            maxArea = Math.max(maxArea,A[i]*m[i]);
        }
        return maxArea;
    }
    
    public int[] nsl(int[] A){
        if(A==null||A.length==0){
            return A;
        }
        int[] res = new int[A.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<A.length;i++){
                while(!st.isEmpty() && A[i]<=A[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i]=-1;
                }
                else{
                    int c =st.peek();
                    res[i]=c;
                }
                st.push(i);
        }
        return res;
    }
    
    public int[] nsr(int[] A){
        if(A==null||A.length==0){
            return A;
        }
        int[] res = new int[A.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        int n = A.length;
        for(int i=n-1;i>=0;i--){
                while(!st.isEmpty() && A[i]<=A[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i]=n;
                }
                else{
                    int c =st.peek();
                    res[i]=c;
                }
                st.push(i);
        }
        return res;
    }
}