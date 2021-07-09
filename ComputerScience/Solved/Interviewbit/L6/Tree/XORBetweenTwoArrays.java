//https://www.interviewbit.com/problems/xor-between-two-arrays/

public class Solution {
    public static class node{
        node left;
        node right;
        node(){
            
        }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        node root = new node();
        for(int item : A){
            node curr = root;
            for(int i = 31; i >= 0; --i){
                int bit = item & (1 << i);
                if(bit != 0){
                    if(curr.right == null) curr.right = new node();
                    curr = curr.right;
                }else{
                    if(curr.left == null) curr.left = new node();
                    curr = curr.left;
                }
            }
        }
        int max = 0;
        for(int item : B){
            node curr = root;
            int total = 0;
            for(int i = 31; i >= 0; --i){
                int bit = item & (1 << i);
                if(bit != 0){
                    if(curr.left != null){
                        curr  = curr.left;
                        total += (1 << i);
                    }else curr = curr.right;
                   
                }else{
                    if(curr.right != null){
                        curr  = curr.right;
                        total += (1 << i);
                    }else curr = curr.left;
                }
            }
            max = Math.max(max,total);
        }
        return max;
    }
}