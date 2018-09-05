//https://www.interviewbit.com/problems/flip/
//https://www.geeksforgeeks.org/maximize-number-0s-flipping-subarray/

/* O(n^2) solution

public class Solution {
    public ArrayList<Integer> flip(String A) {
        int max=0;
        int originalmax=countOne(A);
        int lindex=0;
        int rindex=0;
        ArrayList<Integer> l =new ArrayList<Integer>();
        for(int i=0;i<A.length();i++){
            for(int j=i;j<A.length();j++){
                String s= reverse(A,i,j);
                int numberOfOnes=countOne(s);
                if(max<numberOfOnes){
                    max=numberOfOnes;
                    lindex=i+1;
                    rindex=j+1;
                }
            }
        }
        if(max<=originalmax){
            return l;
        }
        else{
            l.add(lindex);
            l.add(rindex);
            return l;
        }
    }
    
    public String reverse(String A, int i,int j){
        char[] c = A.toCharArray();
        for(int index=i;index<=j;index++){
            if(c[index]=='0'){
                c[index]='1';
            }
            else if(c[index]=='1'){
                c[index]='0';
            }
        }
        return new String(c);
    }
    
    public int countOne(String A){
        char[] c = A.toCharArray();
        int count=0;
        for(int index=0;index<c.length;index++){
            if(c[index]=='1'){
                count++;
            }
        }
        return count;
    }
}
*/

public class Solution{
    public ArrayList<Integer> flip(String A){
    int[] ZeroOrOne=new int[A.length()]; // if zero then 1, if one then -1.
    ArrayList<Integer> ans=new ArrayList<Integer>();
    char[] c = A.toCharArray();
    for(int i = 0; i<c.length; i++){
        
        if(c[i]=='0')
            ZeroOrOne[i] = 1;
        
        else
            ZeroOrOne[i] = -1;
    }
    
    int cumulative=0, left=0, right=0, maxSum=Integer.MIN_VALUE;
    int leftAns=0, rightAns=0;
    
    for(int i=0; i<A.length(); i++){
        cumulative+=ZeroOrOne[i];
        
        if(cumulative<0){
            left=i+1;
            cumulative=0;
        }
        
        else if(cumulative>maxSum){
            leftAns = left;
            rightAns = i;
            maxSum=cumulative;
        }
    }
    
    if(maxSum<=0){
        return ans;
    }
    
    else{
        ans.add(leftAns+1);
        ans.add(rightAns+1);
    }
    
    return ans;
    }
}
