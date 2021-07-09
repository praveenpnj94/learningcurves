//https://www.interviewbit.com/problems/4-sum/

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A==null||A.size()==0){
            return res;
        }
        Collections.sort(A);
        int n = A.size();
        for(int i=0;i<n-3;i++){
            // if(i!=0 && A.get(i)==A.get(i-1)){
            //     continue;
            // }
            int a = A.get(i);
            for(int j=i+1;j<n-2;j++){
                // if(j!=i+1 && A.get(j)==A.get(j-1)){
                //     continue;
                // }
                int b = A.get(j);
                int l = j+1;
                int r = n-1;
                while(l<r){
                    int c = A.get(l);
                    int d = A.get(r);
                    int sum = a+b+c+d;
                    if(sum>B){
                        r--;
                    }
                    else if(sum<B){
                        l++;
                    }
                    else{
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(a);
                        al.add(b);
                        al.add(c);
                        al.add(d);
                        if(!res.contains(al)){
                            res.add(al);                            
                        }
                        l++;
                        r--;
                        
                        // while(l<r && A.get(l)==A.get(l-1)){
                        //     l++;
                        // }
                        
                        // while(l<r && A.get(r)==A.get(r+1)){
                        //     r--;
                        // } 
                    }
                }
            }
        }
        return res;
    }
}
