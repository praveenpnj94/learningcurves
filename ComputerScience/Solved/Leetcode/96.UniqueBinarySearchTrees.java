//https://leetcode.com/problems/unique-binary-search-trees/
//https://www.youtube.com/watch?v=GgP75HAvrlY


// class Solution {
//     public int numTrees(int n) {
//         long c = binomialCoeff(2 * n, n); 
//         // return 2nCn/(n+1)  
//         return (int)(c / (n + 1));
//     } 
//     public long binomialCoeff(int n, int k) { 
//         long res = 1; 
//         // Since C(n, k) = C(n, n-k)  
//         if (k > n - k) { 
//             k = n - k; 
//         } 
//         // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]  
//         for (int i = 0; i < k; ++i) { 
//             res *= (n - i); 
//             res /= (i + 1); 
//         } 
//         return res; 
//     } 
// }
public class Solution {
  public int numTrees(int n) {
    int[] G = new int[n + 1];
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        G[i] += G[j] * G[i - j-1];
      }
    }
    return G[n];
  }
}