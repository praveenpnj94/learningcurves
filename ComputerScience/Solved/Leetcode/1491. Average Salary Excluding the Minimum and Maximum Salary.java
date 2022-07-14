//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/


class Solution {
    public double average(int[] salary) {
        int n=0;
        int sum=0;
        if(salary==null||salary.length==0){
            return 0.0;
        }
        else{
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int s:salary){
                min = Math.min(min,s);
                max = Math.max(max,s);
            }
            for(int s:salary){
                if(s!= min && s!=max){
                    n++;
                    sum+=s;
                }                
            }
        }
        return (double)sum/n;
    }


    public double average(int[] salary) {
        double sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = salary.length;
        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (sum - min - max) / (n - 2);
    }
}

