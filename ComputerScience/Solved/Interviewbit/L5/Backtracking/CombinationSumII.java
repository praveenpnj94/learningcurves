//https://www.interviewbit.com/problems/combination-sum-ii/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a==null||a.size()==0){
            result.add(new ArrayList<>());
            return result;
        }
        Collections.sort(a);
        helper(a,b,result,new ArrayList<Integer>(),0);
        return result;
    }
    
    public void helper(ArrayList<Integer> A, int remain, ArrayList<ArrayList<Integer>> result, 
    ArrayList<Integer> item, int start){
        if(remain<0){
            return;
        }
        else if(remain==0){
            result.add(new ArrayList<>(item));
            return;
        }
        for(int i=start;i<A.size();i++){
            if(i>start && A.get(i).intValue()==A.get(i-1).intValue()) continue;
            item.add(A.get(i));
            helper(A,remain-A.get(i),result,item,i+1);
            item.remove(item.size()-1);
        }
    }
}
