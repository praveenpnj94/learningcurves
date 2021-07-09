//https://www.interviewbit.com/problems/subset/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A==null||A.size()==0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        Collections.sort(A);
        helper(A,result,al,0);
        return result;
    }
    
    public void helper(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> item,int start){
        result.add(new ArrayList<Integer>(item));
        for(int i=start;i<A.size();i++){
            item.add(A.get(i));
            helper(A,result,item,i+1);
            item.remove(item.size()-1);
        }
    }
}
