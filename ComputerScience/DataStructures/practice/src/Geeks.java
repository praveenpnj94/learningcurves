import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Geeks
{
    public static void main (String[] args){
        int[] height = {6,2,4,5};
        System.out.println(mctFromLeafValues(height));
    }

    public static int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            while(stack.peek() <= arr[i]) {
                res += stack.pop() * Math.min(arr[i], stack.peek());
            }
            stack.push(arr[i]);
        }
        while(stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
