//https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates==null||candidates.length==0){
            return result;
        }
        helper(candidates,result,new ArrayList<>(), target,0);
        return result;
    }
    
    public void helper(int[] candidates, List<List<Integer>> result,List<Integer> item, int remain,int start){
        if(remain<0){
            return;
        }
        else if(remain==0){
            result.add(new ArrayList<>(item));
        }
        else{
            for(int i=start;i<candidates.length;i++){
                item.add(candidates[i]);
                helper(candidates,result,item, remain-candidates[i],i);
                item.remove(item.size()-1);
            }
        }
    }
}

//https://www.thealgorists.com/Algo/DynamicProgramming/01Knapsack/CombinationSum
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Set<List<Integer>>[] dp = new HashSet[target + 1]; // set contains no duplicates
        for (int i = 0; i <= target; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(new ArrayList<Integer>()); // target is zero

        // this is a space optimed solution
        // and how we landed this template is discussed in details in Unbounded Knapsack Core Concept chapter
        for (int item = 0; item < candidates.length; item++) {
            for (int t = target; t >= candidates[item]; t--) {
                Set<List<Integer>> lists = dp[t - candidates[item]];
                for (List<Integer> list : lists) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(candidates[item]);
                    Collections.sort(newList); // sort so that we can identofy duplicates
                        // example: [3,5] and [5,3] are same according to this problem.
                        // if we sort both becomes [3,5] and duplicate gets eliminated in the set
                        res.add(currPath); // set does not contain duplicates
                    dp[t].add(newList);
                }
            }
        }
        // Print the solution
        int t = 0;
        for (Set<List<Integer>> list : dp) {
            System.out.println("Target = " + t++);
            for (List<Integer> l : list) {
                for (int a : l) {
                    System.out.print(a + "   ");
                }
                System.out.println();
            }
            System.out.println("-------------------");
        }

        return new ArrayList<List<Integer>>(dp[target]);
    } 
}


//https://leetcode.com/problems/combination-sum/discuss/16509/Iterative-Java-DP-solution

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // sort candidates to try them in asc order
    Arrays.sort(candidates); 
    // dp[t] stores all combinations that add up to t
    List<List<Integer>>[] dp = new ArrayList[target+1];
    
    
    // build up dp
    for(int t=0; t<=target; t++) {
        // initialize
        dp[t] = new ArrayList();
        // initialize
        List<List<Integer>> combList = new ArrayList();
        
        // for each t, find possible combinations
        for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
            if(candidates[j] == t) {
                combList.add(Arrays.asList(candidates[j])); // itself can form a list
            } else {
                for(List<Integer> prevlist: dp[t-candidates[j]]) { // here use our dp definition
                    // i thought it makes more sense to compare with the last element
                    // only add to list when the candidates[j] >= the last element
                    // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
                    // equal is needed since we can choose the same element many times   
                    if(candidates[j] >= prevlist.get(prevlist.size()-1)){
                        List temp = new ArrayList(prevlist); // temp is needed since 
                        temp.add(candidates[j]); // cannot edit prevlist inside 4eeach looop
                        combList.add(temp);
                    }
                }
            }
        }
        dp[t] = combList;
    }
    return dp[target];
}
