//https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/

// Java program to generate power set
import java.util.*;

class GFG
{

    // str : Stores input string
    // curr : Stores current subset
    // index : Index in current subset, curr
    static void powerSet(String str, int index,
                         String curr)
    {
        int n = str.length();

        // base case
        if (index == n)
        {
            return;
        }

        // First print current subset
        System.out.println(curr);

        // Try appending remaining characters
        // to current subset
        for (int i = index + 1; i < n; i++)
        {
            curr += str.charAt(i);
            powerSet(str, i, curr);

            // Once all subsets beginning with
            // initial "curr" are printed, remove
            // last character to consider a different
            // prefix of subsets.
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "abc";
        int index = -1;
        String curr = "";
        powerSet(str, index, curr);
    }
}

// Java program to generate power set 
class GFG { 

// str : Stores input string 
// curr : Stores current subset 
// index : Index in current subset, curr 
static void powerSet(String str, int index, 
			String curr) 
	
{ 
	int n = str.length(); 

	// base case 
	if (index == n) 
	{ 
		System.out.println(curr); 
		return; 
	} 

	// Two cases for every character 
	// (i) We consider the character 
	// as part of current subset 
	// (ii) We do not consider current 
	// character as part of current 
	// subset 
	powerSet(str, index + 1, curr + str.charAt(index)); 
	powerSet(str, index + 1, curr); 

} 

// Driver code 
public static void main(String[] args) 
{ 
	String str = "abc"; 
		int index = 0; 
		String curr=""; 
	powerSet(str,index,curr); 

	} 
} 
// This code is contributed by 29AjayKumar 


// This code is contributed by PrinciRaj1992
