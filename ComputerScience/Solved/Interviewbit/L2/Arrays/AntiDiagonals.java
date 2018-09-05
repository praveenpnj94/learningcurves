//https://www.interviewbit.com/problems/anti-diagonals/
//https://practice2code.blogspot.com/2016/08/anti-diagonals.html
//https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/

public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n=A.size();
        if(n == 0)
        return result;
        for(int d = 0; d <= 2*(n-1); d++) {
            ArrayList<Integer> diagonal=new ArrayList<Integer>();
            for(int i = 0; i <= d; i++) {
                int j = d - i;
                //continue if i or j exceeds their bounds
                if(i >= n || j >= n){
                 continue;   
                }
              diagonal.add(A.get(i).get(j));
            }   
        result.add(diagonal);
   }
   return result;
    }
}
