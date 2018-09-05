//https://www.interviewbit.com/problems/pascal-triangle/
//https://www.geeksforgeeks.org/pascal-triangle/


public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> pl=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A;i++){
            ArrayList<Integer> rl=new ArrayList<Integer>();
            if(i==0){
                rl.add(1);
                pl.add(rl);
            }
            else{
                if(i==1){
                    rl.add(1);
                    rl.add(1);
                    pl.add(rl);
                }
                else{
                    rl.add(1);
                    for(int j=1;j<i;j++){
                        rl.add(pl.get(i-1).get(j-1)+pl.get(i-1).get(j));
                    }
                    rl.add(1);
                    pl.add(rl);
                }
                            
            }

            
        }
        return pl;
    }
}
