//https://leetcode.com/problems/fraction-to-recurring-decimal/
//https://www.youtube.com/watch?v=2cRS9dNa780&ab_channel=Pepcoding

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator, d = denominator;
        if (n % d == 0) {
            return n / d + "";
        }
        boolean neg = false;
        if ((n < 0 && d > 0) || (n > 0 && d < 0)) {
            neg = true;
        }
        if (n < 0) {
            n = -n;
        }
        if (d < 0) {
            d = -d;
        }
        HashMap<Long, Integer> index = new HashMap<Long, Integer>();
        StringBuilder result = new StringBuilder();
        result.append(n / d );
        result.append("." );
        n = n % d;
        while (n != 0) {
            if (index.containsKey(n)) {
                //recurring
                result.insert(index.get(n),"(");
                result.append(")");
                break;
            }
            index.put(n, result.length());
            result.append(n*10/d);
            n = n*10 % d;
        }
        if (neg == true) {
            result.insert(0,"-");
        }
        return result.toString();
    }
}