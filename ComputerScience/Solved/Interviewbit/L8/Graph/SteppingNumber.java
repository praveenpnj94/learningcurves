//https://www.interviewbit.com/problems/stepping-numbers/
//https://leetcode.com/problems/stepping-numbers/discuss/397600/Simple-BFS

public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=A;i<=B;i++){
            if(steppingNum(i)){
                al.add(i);
            }
        }
        return al;
    }
    public boolean steppingNum(int num){
        int prev=-1;
        int r=-1;
        while(num>0){
            prev=r;
            r = num%10;
            num = num/10;
            if(prev!=-1){
                if(Math.abs(prev-r)!=1){
                    return false;
                }
            }
        }
        return true;
    }


    public static ArrayList<Integer> countSteppingNumbers(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        if (low > high) return res;

        Queue<Long> queue = new LinkedList<>();
        for (long i = 1; i <= 9; i++) queue.add(i);

        if (low == 0) res.add(0);
        while (!queue.isEmpty()) {
            long p = queue.poll();
            if (p < high) {
                long last = p % 10;
                if (last > 0) queue.add(p * 10 + last - 1);
                if (last < 9) queue.add(p * 10 + last + 1);
            }
            if (p >= low && p <= high) {
                res.add((int) p);
            }
        }
        return res;
    }
}
