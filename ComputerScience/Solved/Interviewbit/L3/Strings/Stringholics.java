//https://www.interviewbit.com/problems/stringoholics/

public class Solution {
    public int solve(ArrayList<String> A) {
        int[] arr = new int[A.size()];
        for(int i =0; i<A.size();i++){
            arr[i] = getTimeForString(A.get(i));
        }
        long r = lcm(arr);
        return(int)r;
    }
    
    public int getTimeForString(String s){
        String temp="";
        if(s.length()==1){
            return 1;
        }
        else{
            int i=0;
            while(!temp.equalsIgnoreCase(s)){
                if(i==0){
                    temp = s;
                }
                i++;
                temp = rotate(temp,i);
            }
            return i;
        }
    }
    
    public String rotate(String temp, int n){
        n = n%temp.length();
        String first = temp.substring(0,n);
        String second = temp.substring(n);
        if(first == ""){
            return second;
        }
        else if(second == ""){
            return first;
        }
        else{
            String res = second+first;
            return res;
        }
    }
    
public  long lcm(int[] numbers) {
        long lcm = 1;
        int divisor = 2;
        while (true) {
            int cnt = 0;
            boolean divisible = false;
            for (int i = 0; i < numbers.length; i++) {
                /**
                 * lcm (n1,n2,... 0)=0.For negative number we convert into
                 * positive and calculate lcm.
                 */
                if (numbers[i] == 0) {
                    return 0;
                } else if (numbers[i] < 0) {
                    numbers[i] = numbers[i] * (-1);
                }
                if (numbers[i] == 1) {
                    cnt++;
                }
                /**
                 * divide numbers by devisor if complete division i.e. without
                 * remainder then replace number with quotient; used for find
                 * next factor
                 */
                if (numbers[i] % divisor == 0) {
                    divisible = true;
                    numbers[i] = numbers[i] / divisor;
                }
            }
            /**
             * If divisor able to completely divide any number from array
             * multiply with lcm and store into lcm and continue to same divisor
             * for next factor finding. else increment divisor
             */
            if (divisible) {
                lcm = lcm * divisor;
            } else {
                divisor++;
            }
            /**
             * Check if all numbers is 1 indicate we found all factors and
             * terminate while loop.
             */
            if (cnt == numbers.length) {
                return lcm;
            }
        }
    }
}
