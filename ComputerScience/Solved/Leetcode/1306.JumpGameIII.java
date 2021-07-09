//https://leetcode.com/problems/jump-game-iii/
//https://www.youtube.com/watch?v=7Cz91Uj0VCU&ab_channel=AlgorithmsMadeEasy

class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int p = q.remove();
            
            if(p-arr[p]>=0){
                if(arr[p-arr[p]]==0){
                    return true;
                }
                else if(arr[p-arr[p]]>0){
                    q.add(p-arr[p]);
                }
            }
            
            
            if(p+arr[p]<arr.length){
                if(arr[p+arr[p]]==0){
                    return true;
                }
                else if(arr[p+arr[p]]>0){
                    q.add(p+arr[p]);
                }
            }
            
            arr[p]=-1;
        }
        
        return false;
    }
}