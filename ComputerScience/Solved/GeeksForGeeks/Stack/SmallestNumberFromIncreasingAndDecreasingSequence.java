//https://www.techiedelight.com/decode-the-given-sequence-construct-minimum-number-without-repeated-digits/



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static StringBuilder decode(String seq)
    {
        // `result` store the output string
        StringBuilder result = new StringBuilder();

        // create an empty stack of integers
        Stack<Integer> stack = new Stack<>();

        // run `n+1` times, where `n` is the length of the input sequence
        for (int i = 0; i <= seq.length(); i++)
        {
            // push number `i+1` into the stack
            stack.push(i + 1);

            // if all characters of the input sequence are processed, or
            // the current character is `I` (increasing)
            if (i == seq.length() || seq.charAt(i) == 'I')
            {
                // run till stack is empty
                while (!stack.empty())
                {
                    // remove a top element from the stack and add it to the solution
                    result.append(stack.pop());
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        // input sequence
        String seq = "IIDDIDID";

        System.out.println("The minimum number is " + decode(seq));
    }
}
