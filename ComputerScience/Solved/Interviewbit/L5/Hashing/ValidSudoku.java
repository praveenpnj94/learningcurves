//https://www.interviewbit.com/problems/valid-sudoku/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isValidSudoku(final String[] A) {
        Set seen = new HashSet();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                String s = A[i];
                char c = s.charAt(j);
                if(c!='.'){
                    if(!seen.add(c+" in row "+i)||!seen.add(c+" in column "+j)
                    ||!seen.add(c+" in block "+i/3+"-"+j/3)){
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}
