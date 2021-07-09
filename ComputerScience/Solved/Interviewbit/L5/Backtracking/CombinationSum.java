//https://www.interviewbit.com/problems/combination-sum/

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A==null||A.size()==0){
            result.add(new ArrayList<>());
            return result;
        }
        Set<Integer> set = new LinkedHashSet<>();
        for(int a:A){
            set.add(a);
        }
        ArrayList<Integer> c = new ArrayList<>();
        for(int a:set){
            c.add(a);
        }
        Collections.sort(c);
        helper(c,B,result,new ArrayList<Integer>(),0);
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
            item.add(A.get(i));
            helper(A,remain-A.get(i),result,item,i);
            item.remove(item.size()-1);
        }
    }
}
