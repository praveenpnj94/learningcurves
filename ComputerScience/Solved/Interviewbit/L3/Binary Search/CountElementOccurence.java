//https://www.interviewbit.com/problems/count-element-occurence/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    public int occur(List<Integer>a,int b,boolean c){
        int start=0,end=a.size()-1,result=-1;
        
        while(start<=end){
            int mid=(start+end)/2;
            if(a.get(mid)==b){
                result=mid;
                if(c)
                end=mid-1;
                else
                start=mid+1;
            }
            else if(a.get(mid)<b)
            start=mid+1;
            else
            end=mid-1;
        }
        return result;
    }
    public int findCount(final List<Integer> A, int B) {
        
        int a=occur(A,B,true);
        int b=occur(A,B,false);
        
        if(a!=-1 && b!=-1){
            return (b-a+1);
        }
        return 0;
    }
}
