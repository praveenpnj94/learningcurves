//https://www.interviewbit.com/problems/sudoku/

public class Solution {
	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
	    if(a==null||a.size()==0||a.get(0).size()==0){
	        return;
	    }
	    solve(a);
	}
	
	public boolean solve(ArrayList<ArrayList<Character>> a){
	    int m = a.size();
	    int n = a.get(0).size();
	    for(int i=0;i<m;i++){
	        for(int j=0;j<n;j++){
	            if(a.get(i).get(j)=='.'){
	                for(char c='1';c<='9';c++){
	                    if(isValid(i,j,a,c)){
	                        a.get(i).set(j,c);
	                        if(solve(a)){
	                            return true;
	                        }
	                        a.get(i).set(j,'.');
	                    }
	                }
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	public boolean isValid(int row,int col,ArrayList<ArrayList<Character>> a,char c){
	    for(int i=0;i<9;i++){
	        if(a.get(i).get(col)!='.' && a.get(i).get(col)==c){
	            return false;
	        }
	        if(a.get(row).get(i)!='.' && a.get(row).get(i)==c){
	            return false;
	        }
	        if(a.get(3*(row/3) + i/3).get(3*(col/3 )+ i%3)!='.' && a.get(3*(row/3) + i/3).get(3*(col/3) + i%3)==c){
	            return false;
	        }
	    }
	    return true;
	}
}
