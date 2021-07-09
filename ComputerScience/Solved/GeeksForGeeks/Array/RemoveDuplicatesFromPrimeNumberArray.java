//https://www.geeksforgeeks.org/remove-duplicates-from-an-array-of-small-primes/
//Amazon Tag

// Removes duplicates using multiplication of 
// distinct primes in array 
import java.util.*; 

class GFG { 

	static int[] removeDups(int[] vect) 
	{ 

		int prod = vect[0]; 
		int res_ind = 1; 
		for (int i = 1; i < vect.length; i++) { 
			if (prod % vect[i] != 0) { 
				vect[res_ind++] = vect[i]; 
				prod *= vect[i]; 
			} 
		} 
		return Arrays.copyOf(vect, res_ind); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int[] vect = { 3, 5, 7, 2, 2, 5, 7, 7 }; 
		vect = removeDups(vect); 
		for (int i = 0; i < vect.length; i++) 
			System.out.print(vect[i] + " "); 
	} 
} 

// This code is contributed by 29AjayKumar 



class Solution
{
    ArrayList<Integer> removeDuplicate(int arr[], int n)
    {
        if(arr==null||arr.length==0){
            return new ArrayList<Integer>();
        }
        LinkedHashSet<Integer> m = new LinkedHashSet<>();
        for(int num:arr){
            m.add(num);
        }
        ArrayList<Integer> l = new ArrayList<Integer>();
        int i=0;
        for(int na:m){
            l.add(na);
        }
        return l;
    }
}