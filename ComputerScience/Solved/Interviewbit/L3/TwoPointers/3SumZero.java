//https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
//https://www.interviewbit.com/problems/3-sum-zero/


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        for(int low=0;low<A.size();low++)
        {
            //taking two pointers end & mid
            int end=A.size()-1;
            int mid=low+1;
            //taking smallest element from left
            int x=A.get(low);
            while(mid<end)
            {
                int y=A.get(end),z=A.get(mid);
                int sum=x+y+z;
                if(sum==0)
                {
                    //adding the pair
                    ArrayList<Integer> ad=new ArrayList<Integer>();
                    ad.add(x);ad.add(z);ad.add(y);
                    //add only if pair is not in Arraylist i.e, not a duplicate
                    if(!res.contains(ad))
                        res.add(ad);
                }
                if(sum<=0)
                    mid++;
                else
                    end--;
            }
        }
        return res;
    }
}

