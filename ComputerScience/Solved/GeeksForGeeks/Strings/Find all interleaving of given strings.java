//https://www.techiedelight.com/find-interleavings-of-given-strings/

class Main
{
    // Function to find all interleaving of string `X` and `Y`
    public static void findInterleavings(String curr, String X, String Y,
                                        Set<String> result)
    {
        // insert `curr` into the set if the end of both strings is reached
        if (X.length() == 0 && Y.length() == 0)
        {
            result.add(curr);
            return;
        }
 
        // if the string `X` is not empty, append its first character in the
        // result and recur for the remaining substring
 
        if (X.length() > 0) {
            findInterleavings(curr + X.charAt(0), X.substring(1), Y, result);
        }
 
        // if the string `Y` is not empty, append its first character in the
        // result and recur for the remaining substring
 
        if (Y.length() > 0) {
            findInterleavings(curr + Y.charAt(0), X, Y.substring(1), result);
        }
    }
 
    public static void main(String[] args)
    {
        String X = "ABC";
        String Y = "ACB";
 
        // use set to handle duplicates
        Set<String> result = new HashSet<>();
        findInterleavings("", X, Y, result);
 
        System.out.println(result);
    }
}