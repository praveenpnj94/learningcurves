//https://leetcode.com/problems/combinations/
//https://media.geeksforgeeks.org/wp-content/uploads/tree12345.png

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        if(n<=0||n<k){
            return result;
        }
        helper(result, new ArrayList<Integer>(),1,n,k);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int start, int n, 
                       int k){
        if(item.size()==k){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<=n;i++){
            item.add(i);
            helper(result, item,i+1,n,k);
            item.remove(item.size()-1);
        }
    }
}