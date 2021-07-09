//https://leetcode.com/problems/largest-rectangle-in-histogram/
//https://www.youtube.com/watch?v=RVIh0snn4Qc&ab_channel=IrfanBaqui

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int i =0;
        int n = heights.length;
        while(i<n){
            if(st.isEmpty()||heights[i]>=heights[st.peek()]){
                st.push(i++);
            }
            else{
                int currMaxIdx = st.pop();
                int currMaxArea = heights[currMaxIdx]*(st.isEmpty()?(i):(i-1-st.peek()));
                maxArea = Math.max(maxArea,currMaxArea);
            }

        }
        while(!st.isEmpty()){
            int currMaxIdx = st.pop();
            int currMaxArea = heights[currMaxIdx]*(st.isEmpty()?(i):(i-1-st.peek()));
            maxArea = Math.max(maxArea,currMaxArea); 
        }
        return maxArea;
    }
}