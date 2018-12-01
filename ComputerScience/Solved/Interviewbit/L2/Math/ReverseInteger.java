public class Solution {
    public int reverse(int A) {
        if(A<0){
            A =A*-1; 
            String c = Integer.toString(A);
            StringBuilder sb = new StringBuilder(c);
            sb.reverse();
            Long l = Long.parseLong(sb.toString());
            if(l>2147483647){
                return 0;
            }
            return Integer.parseInt(sb.toString())*-1;
        }
            String c = Integer.toString(A);
            StringBuilder sb = new StringBuilder(c);
            sb.reverse();
            Long l = Long.parseLong(sb.toString());
            if(l>2147483647){
                return 0;
            }
            return Integer.parseInt(sb.toString());
    }
}
