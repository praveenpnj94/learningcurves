//https://www.interviewbit.com/problems/permutations/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A==null||A.size()==0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        Collections.sort(A);
        helper(A,result,0);
        return result;
    }
    public void helper(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> result,int start){
        if(start==A.size()){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int a:A){
                curr.add(a);
            }
            result.add(curr);
        }
        for(int i=start;i<A.size();i++){
            swap(A,i,start);
            helper(A,result,start+1);
            swap(A,i,start);
        }
    }
    
    public void swap(ArrayList<Integer> A,int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }
}
