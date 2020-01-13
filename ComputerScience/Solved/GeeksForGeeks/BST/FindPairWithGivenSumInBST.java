//https://www.geeksforgeeks.org/find-pair-given-sum-bst/


/*/class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/
class GFG {
    // This function should return true
    // if there is a pair in given BST with
    // given sum.
    static boolean findPair(Node root, int sum) {
        HashSet<Integer> hs = new HashSet();
        return findPairUtil(root,sum,hs);
    }
    
    static boolean findPairUtil(Node root, int sum, HashSet<Integer> hs) {
        if(root==null){
            return false;
        }
        if(findPairUtil(root.left,sum,hs)){
            return true;
        }
        if(hs.contains(sum-root.data)){
            return true;
        }
        else{
            hs.add(root.data);
        }
        return findPairUtil(root.right,sum,hs);
    }
}
