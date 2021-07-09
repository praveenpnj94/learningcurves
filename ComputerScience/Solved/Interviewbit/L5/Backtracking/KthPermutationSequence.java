//https://www.interviewbit.com/problems/kth-permutation-sequence/

public class Solution {
    public String getPermutation(int n, int k) {
        List < Integer > numbers = new ArrayList < > ();
        int[] factorial = new int[n + 1];
        Arrays.fill(factorial,1);
        StringBuilder sb = new StringBuilder();
        // create an array of factorial lookup
        int fact = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(i>12){
                factorial[i] = Integer.MAX_VALUE;
            }
            else{
                fact *= i;
                factorial[i] = fact;
            }

        }
        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        try{
            for (int i = 1; i <= n; i++) {
                int index = (k / factorial[n - i]);
                sb.append(String.valueOf(numbers.get(index)));
                numbers.remove(index);
                k -= index * factorial[n - i];
            }
        }
        catch(Exception e){
            System.out.println("n is "+n+" and k is "+k);
        }
        return String.valueOf(sb);
    }
}
