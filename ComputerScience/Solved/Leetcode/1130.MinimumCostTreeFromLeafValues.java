//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
//https://www.youtube.com/watch?v=pYs3qj42h3c&ab_channel=faadcoder

class Solution {
    public int mctFromLeafValues(int[] arr) {
        // Stack<Integer> stack = new Stack<>();
        // stack.push(Integer.MAX_VALUE);
        // int res = 0;
        // for(int i = 0; i < arr.length; i++) {
        //     while(stack.peek() <= arr[i]) {
        //         res += stack.pop() * Math.min(arr[i], stack.peek());
        //     }
        //     stack.push(arr[i]);
        // }
        // while(stack.size() > 2) {
        //     res += stack.pop() * stack.peek();
        // }
        // return res;
        if(arr==null||arr.length==0){
            return 0;
        }
        Res res = helper(0,arr.length-1,arr);
        return res.minSum;
    }
    
    public Res helper(int start, int end, int[] arr){
        
        if(start==end){
            return new Res(arr[start],0);
        }
        
        int minSum=Integer.MAX_VALUE;
        
        int maxLeaf = Integer.MIN_VALUE;
        
        for(int i= start;i<end;i++){
            Res left = helper(start,i,arr);
            Res right = helper(i+1,end,arr);
            
            maxLeaf = Math.max(left.maxLeaf,right.maxLeaf);
            
            minSum = Math.min(minSum,left.minSum+right.minSum+left.maxLeaf*right.maxLeaf);
        }
        
        return new Res(maxLeaf,minSum);
        
    } 
    
    
}
class Res{
    int maxLeaf;
    int minSum;
    
    Res(int maxLeaf, int minSum){
        this.maxLeaf = maxLeaf;
        this.minSum = minSum;
    }
}