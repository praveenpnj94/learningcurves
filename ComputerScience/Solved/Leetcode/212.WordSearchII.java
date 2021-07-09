//https://leetcode.com/problems/word-search-ii/
//https://www.youtube.com/watch?v=B5wAm6pFYS8&ab_channel=codebix

// class Solution {
//     public List<String> findWords(char[][] board, String[] words) {
//         List<String> res = new ArrayList<>();
//         for(String w: words){
//             if(exist(board,w)){
//                 res.add(w);
//             }
//         }
//         return res;
//     }
    
//     public boolean exist(char[][] board, String word) {
//         if (word == null || word.length() == 0) {
//             return true;
//         }
//         char[] chs = word.toCharArray();
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 if(dfs(board, chs, 0, i, j)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
    
//     private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
//         if (idx == words.length) {
//             return true;
//         } 
//         if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
//             return false;
//         }
//         if (board[x][y] != words[idx]) {
//             return false;
//         }
//         board[x][y] ^= 256;
//         boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
//         dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
//         dfs(board, words, idx + 1, x - 1, y) ;
//         board[x][y] ^= 256;
//         return exist;
//     }
// }



class Solution {
    
    public class TrieNode{
        public boolean isWord = false;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){
            
        }
    }
    
    TrieNode root = new TrieNode();
    boolean[][] flag;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];
        
        addToTrie(words);
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i, j, root, "", result);
                }
            }
        }
        
        return new LinkedList<>(result);
    }
    
    private void addToTrie(String[] words){
        for(String word: words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }
    
    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result){
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]|| node.child[board[i][j] - 'a'] == null){
            return;
        }
        
        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if(node.isWord){
            result.add(word + board[i][j]);
        }
        
        search(board, i-1, j, node, word + board[i][j], result);
        search(board, i+1, j, node, word + board[i][j], result);
        search(board, i, j-1, node, word + board[i][j], result);
        search(board, i, j+1, node, word + board[i][j], result);
        
        flag[i][j] = false;
    }
}