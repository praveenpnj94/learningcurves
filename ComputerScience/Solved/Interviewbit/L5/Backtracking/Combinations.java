//https://www.interviewbit.com/problems/combinations/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(A,B,result,new ArrayList<Integer>(),1);
        return result;
    }
    
    public void helper(int A, int B, ArrayList<ArrayList<Integer>> result, 
    ArrayList<Integer> item, int start){
        if(item.size()==B){
            result.add(new ArrayList<>(item));
        }
        for(int i=start;i<=A;i++){
            item.add(i);
            helper(A,B,result,item,i+1);
            item.remove(item.size()-1);
        }
    }
}
