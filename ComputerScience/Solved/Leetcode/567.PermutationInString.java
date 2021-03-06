//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
//https://leetcode.com/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String p, String s) {
      int ns = s.length(), np = p.length();
      if (ns < np) return false;
  
      int [] pCount = new int[26];
      int [] sCount = new int[26];
      // build reference array using string p
      for (char ch : p.toCharArray()) {
        pCount[(int)(ch - 'a')]++;
      }
  
      List<Integer> output = new ArrayList();
      // sliding window on the string s
      for (int i = 0; i < ns; ++i) {
        // add one more letter 
        // on the right side of the window
        sCount[(int)(s.charAt(i) - 'a')]++;
        // remove one letter 
        // from the left side of the window
        if (i >= np) {
          sCount[(int)(s.charAt(i - np) - 'a')]--;
        }
        // compare array in the sliding window
        // with the reference array
        if (Arrays.equals(pCount, sCount)) {
          return true;
        }
      }
      return false;
    }
}