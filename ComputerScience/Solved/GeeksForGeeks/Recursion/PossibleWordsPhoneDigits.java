//https://www.geeksforgeeks.org/find-possible-words-phone-digits/
//https://www.techiedelight.com/find-possible-combinations-words-formed-from-mobile-keypad/
//https://www.youtube.com/watch?v=21OuwqIC56E

import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		List<List<Character>> keypad = Arrays.asList(
				// 0 and 1 digit don't have any characters associated
				Arrays.asList(),
				Arrays.asList(),
				Arrays.asList( 'A', 'B', 'C' ),
				Arrays.asList( 'D', 'E', 'F' ),
				Arrays.asList( 'G', 'H', 'I' ),
				Arrays.asList( 'J', 'K', 'L' ),
				Arrays.asList( 'M', 'N', 'O' ),
				Arrays.asList( 'P', 'Q', 'R', 'S'),
				Arrays.asList( 'T', 'U', 'V' ),
				Arrays.asList( 'W', 'X', 'Y', 'Z')
		);
		while(t-->0){
		    int size = Integer.parseInt(br.readLine());
		    String[] arr = br.readLine().split(" ");
		    ArrayList<String> list = new ArrayList<String>();
		    findCombinations(keypad,arr,"",arr.length-1,list);
		    Collections.sort(list);
		    for(int i=0;i<list.size();i++){
		        System.out.print(list.get(i)+" ");
		    }
		    System.out.println();
		}
	}
	
	public static void findCombinations(List<List<Character>> keypad,
										String[] input, String res, int index,ArrayList<String> list)
	{
		// if we have processed every digit of key, print result
		if (index == -1)
		{
			list.add(res.toLowerCase());
			return;
		}

		// stores current digit
		int digit = Integer.parseInt(input[index]);

		// size of the list corresponding to current digit
		int len = keypad.get(digit).size();

		// one by one replace the digit with each character in the
		// corresponding list and recur for next digit
		for (int i = 0; i < len; i++) {
			findCombinations(keypad, input, keypad.get(digit).get(i) + res,
							index - 1,list);
		}
	}
}


/*package whatever //do not write package name here */
/*
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int size = Integer.parseInt(br.readLine());
		    String[] arr = br.readLine().split(" ");
		    String digits="";
		    for(int k=0;k<arr.length;k++){
		        digits+=arr[k];
		    }
		    List<String> list = printKeyWords(digits);
		    for(int i=0;i<list.size();i++){
		        System.out.print(list.get(i)+" ");
		    }
		}
	}
  
    public static List<String> printKeyWords(String digits) 
    { 
        List<String> result = new ArrayList<String>();
        if (digits==null || digits.length() == 0) { 
            return result; 
        } 
        String[] mapping  = { "0","1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
        printKeyWordsRecursive(result,digits,"",0,mapping);
        Collections.sort(result);
        return result; 
    }
    
    public static void printKeyWordsRecursive(List<String> result,String digits,String current,int index,String[] mapping){
        if(index==digits.length()){
            result.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++){
            printKeyWordsRecursive(result,digits,current+letters.charAt(i),index+1,mapping);
        }
    }
}
*/